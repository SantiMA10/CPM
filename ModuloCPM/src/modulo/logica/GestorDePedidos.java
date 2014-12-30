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
				pedido.remove(i);
				sala.cambiarTipoDeEntrada(fila, butaca, 0);
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
}
