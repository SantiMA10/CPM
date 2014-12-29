package modulo.logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Cartelera {
	private ArrayList<Pelicula> peliculas;
	private Pelicula[] recomendadas;
	
	public Cartelera(){
		peliculas = new ArrayList<Pelicula>();
		recomendadas = new Pelicula[2];
		cargarCartelera();
		generarRecomendadas();
	}
	protected Pelicula[] getRecomendadas(){
		return recomendadas;
	}
	private void generarRecomendadas(){
		recomendadas[0] = peliculas.get((int) (Math.random()*peliculas.size()));
		do{
			recomendadas[1] = peliculas.get((int) (Math.random()*peliculas.size()));
		}while(recomendadas[1].getCodigo().equals(recomendadas[0].getCodigo()));
	}
	
	public ArrayList<Pelicula> getCartelera(){
		return peliculas;
	}
	public void cargarCartelera(){
		String linea = "";
	    try {
	    	BufferedReader fichero = new BufferedReader(new FileReader("data/cartelera.dat"));
	    	while (fichero.ready()) {
	    		linea = fichero.readLine();
	    		if(!linea.isEmpty()){
		    		String[] pelicula = linea.split(";");
		    		peliculas.add(new Pelicula(pelicula[0], pelicula[1], pelicula[2], pelicula[3], Integer.parseInt(pelicula[4]), 
		    				pelicula[5], pelicula[6], pelicula[7], pelicula[8], pelicula[9]));
	    		}
	    	}
	    	fichero.close();
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
	}
	public Pelicula hayEn3D(Pelicula pelicula){
		for(int i = 0; i < peliculas.size(); i++){
			if(peliculas.get(i).getTitulo().equals(pelicula.getTitulo()) && peliculas.get(i).isIs3D()){
				return peliculas.get(i);
			}
		}
		return null;
	}
	
	public Pelicula hayEn2D(Pelicula pelicula){
		for(int i = 0; i < peliculas.size(); i++){
			if(peliculas.get(i).getTitulo().equals(pelicula.getTitulo()) && !peliculas.get(i).isIs3D()){
				return peliculas.get(i);
			}
		}
		return null;
	}
}
