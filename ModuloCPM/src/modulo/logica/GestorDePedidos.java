package modulo.logica;

import java.util.ArrayList;

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
	
	public Pelicula cambiarFormato(boolean is3D){
		if(is3D){
			return cine.getCartelera().hayEn2D(getPeliculaActual());
		}
		else{
			return cine.getCartelera().hayEn3D(getPeliculaActual());
		}
	}

	public void setSalaActual(Sala salaActual) {
		this.salaActual = salaActual;
	}

	public void comprarEntrada(int fila, int butaca, int tipo){
		Sala sala = peliculaActual.getSala(salaActual.getFecha(), salaActual.getHora());
		Entrada entrada = sala.cambiarTipoDeEntrada(fila, butaca, tipo);
		if(entrada != null){
			System.out.println("Entrada comprada :)");
			pedido.add(entrada);
		}
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

	public void guardarSalas() {
		for(int i = 0; i < getCartelera().size(); i++){
			getCartelera().get(i).guardarSalas();
		}
	}
}
