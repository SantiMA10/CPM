package modulo.logica;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestorDePedidos {
	private Cine cine;
	private ArrayList<Entrada> pedido;
	private Pelicula peliculaActual;
	private Sala salaActual;
	
	public GestorDePedidos(){
		cine = new Cine();
		pedido = new ArrayList<Entrada>();
	}
	
	public ArrayList<Pelicula> getCartelera(){
		return cine.getCartelera().getCartelera();
	}
	
	public void setPeliculaActual(Pelicula pelicula){
		this.peliculaActual = pelicula;
	}
	
	public Pelicula getPeliculaActual(){
		return peliculaActual;
	}
	
	public ArrayList<Entrada> getPedido() {
		return pedido;
	}

	public Sala getSalaActual() {
		return salaActual;
	}
	
	public Sala getSala(){
		return peliculaActual.getSala(salaActual.getFecha(), salaActual.getHora());
	}
	
	public Pelicula cambiarFormato(){
		if(getPeliculaActual().isIs3D()){
			return cine.getCartelera().hayEn2D(getPeliculaActual());
		}
		else{
			return cine.getCartelera().hayEn3D(getPeliculaActual());
		}
	}

	public void setSalaActual(Sala salaActual) {
		this.salaActual = salaActual;
	}
	
	public int getEntradasPeliculaActual(){
		int numEntradas = 0;
		for(int i = 0; i < pedido.size(); i++){
			if(pedido.get(i).getCodigo().equals(peliculaActual.getCodigo())){
				numEntradas++;
			}
		}
		return numEntradas;
	}

	public boolean comprarEntrada(int fila, int butaca, int tipo){
		Sala sala = peliculaActual.getSala(salaActual.getFecha(), salaActual.getHora());
		Entrada entrada = sala.cambiarTipoDeEntrada(fila, butaca, tipo);
		if(entrada != null){
			pedido.add(entrada);
			return true;
		}
		return false;
	}
	
	public void quitarEntrada(int fila, int butaca){
		for(int i = 0; i < pedido.size(); i++){
			if(pedido.get(i).getCodigo().equals(peliculaActual.getCodigo()) && pedido.get(i).getFecha().equals(salaActual.getFecha()) &&
					pedido.get(i).getHora().equals(salaActual.getHora())){
				Sala sala = peliculaActual.getSala(salaActual.getFecha(), salaActual.getHora());
				System.out.println("quitando entrada"+fila+butaca);
				System.out.println(pedido.get(i));
				pedido.remove(i);
				sala.cambiarTipoDeEntrada(fila, butaca, 0);
				break;
			}
		}
	}
	
	public String getListaPrecios(ResourceBundle traduccion){
		DecimalFormat formato = new DecimalFormat("###.##");
		StringBuilder sb = new StringBuilder(traduccion.getString("entradaNormal") + ": "
					+ formato.format(cine.getPrecioEntrada())+"€\n");
		sb.append(traduccion.getString("entradaNormal3D") + ": "
					+ formato.format(cine.getPrecioEntrada()+cine.getIncremento3D())+"€\n");
		sb.append(traduccion.getString("entradaJubilado") + ": "
					+ formato.format(cine.getPrecioEntrada()+cine.getDescuentoJubilado())+"€\n");
		sb.append(traduccion.getString("entradaJubilado3D") + ": " 
					+ formato.format(cine.getPrecioEntrada()+cine.getDescuentoJubilado()+cine.getIncremento3D())+"€\n");
		sb.append(traduccion.getString("entradaCumple") + ": "
					+ formato.format(cine.getPrecioEntrada()+cine.getIncrementoCumple())+"€\n");
		sb.append(traduccion.getString("entradaCumple3D") + ": "
				+ formato.format(cine.getPrecioEntrada()+cine.getIncrementoCumple()+cine.getIncremento3D())+"€\n");
		sb.append(traduccion.getString("entradaJubiCumple") + ": "
				+ formato.format(cine.getPrecioEntrada()+cine.getIncrementoCumple()+cine.getDescuentoJubilado())+"€\n");
	sb.append(traduccion.getString("entradaJubiCumple3D") + ": "
			+ formato.format(cine.getPrecioEntrada()+cine.getIncrementoCumple()+cine.getIncremento3D()+cine.getDescuentoJubilado())+"€");
		return sb.toString();
	}
	
	public boolean isPedidoVacio(){
		return pedido.size() == 0;
	}

	public String getNombreCine(){
		return cine.getNombre();
	}
	
	public void guardarSalas() {
		for(int i = 0; i < getCartelera().size(); i++){
			getCartelera().get(i).guardarSalas();
		}
	}
	
	public Pelicula[] getRecomendadas(){
		return cine.getCartelera().getRecomendadas();
	}

	public void setSalaActual(String fecha, String hora) {
		salaActual = peliculaActual.getSala(fecha, hora);
	}

	public String printPedidoPeliculaActual(ResourceBundle traduccion) {
		int numNormales = 0, numJubilado = 0, numCumple = 0, numJubiCumple = 0;
		for(int i = 0; i < pedido.size(); i++){
			if(pedido.get(i).getCodigo().equals(peliculaActual.getCodigo())){
				if(pedido.get(i).getTipo() == Entrada.NORMAL){
					numNormales++;
				}
				else if(pedido.get(i).getTipo() == Entrada.JUBILADO){
					numJubilado++;
				}
				else if(pedido.get(i).getTipo() == Entrada.JUBILADO_Y_PACK_CUMPLE){
					numCumple++;
				}
				else if(pedido.get(i).getTipo() == Entrada.PACK_CUMPLE){
					numJubiCumple++;
				}
			}
		}
		String printPedido = "";
		if(numNormales > 0){
			printPedido += traduccion.getString("entradaNormal")+": "+numNormales+"\n";
		}
		if(numJubilado > 0){
			printPedido += traduccion.getString("entradaJubilado")+": "+numJubilado+"\n";
		}
		if(numCumple > 0){
			printPedido += traduccion.getString("entradaCumple")+": "+numCumple+"\n";
		}
		if(numJubiCumple > 0){
			printPedido += traduccion.getString("entradaJubiCumple")+": "+numJubiCumple;
		}
		if(numNormales == 0 && numJubilado == 0 && numCumple == 0 && numJubiCumple == 0){
			printPedido = traduccion.getString("pedidoVacio");
		}
		return printPedido;
	}
}
