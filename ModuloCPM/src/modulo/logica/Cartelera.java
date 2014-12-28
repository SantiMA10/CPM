package modulo.logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Cartelera {
	private ArrayList<Pelicula> peliculas;
	
	public Cartelera(){
		peliculas = new ArrayList<Pelicula>();
		loadCartelera();
	}
	public ArrayList<Pelicula> getCartelera(){
		return peliculas;
	}
	public void loadCartelera(){
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
}
