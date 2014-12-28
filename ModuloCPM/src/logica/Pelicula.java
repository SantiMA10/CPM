package logica;

import java.util.ArrayList;

public class Pelicula {
	private String codigo;
	private String titulo;
	private String sinopsis;
	private String genero;
	private int duracion;
	private String edadRecomendada;
	private String[] fechas;
	private String[] horas;
	private String nombreSala;
	private ArrayList<Sala> salas;
	private boolean is3D;
	
	public Pelicula(String codigo, String titulo, String sinopsis, String genero, int duracion, 
			String edadRecomendada, String fechas, String horas, String nombreSala, String is3D){
		setCodigo(codigo);
		setTitulo(titulo);
		setSinopsis(sinopsis);
		setGenero(genero);
		setDuracion(duracion);
		setEdadRecomendada(edadRecomendada);
		procesarFechas(fechas);
		procesarHoras(horas);
		setNombreSala(nombreSala);
		procesarFormato(is3D);
	}
	
	public Sala getSala(String fecha, String hora){
		for(int i = 0; i < salas.size(); i++){
			
		}
		return null;
	}
	
	private void procesarHoras(String horas) {
		this.horas = horas.split("%");	
	}
	
	private void procesarFechas(String fechas) {
		this.fechas = fechas.split("%");
	}

	private void procesarFormato(String is3D) {
		this.is3D = (is3D.equals("S") || is3D.equals("s"));
		
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getEdadRecomendada() {
		return edadRecomendada;
	}
	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	public String[] getFechas() {
		return fechas;
	}
	public void setFechas(String[] fechas) {
		this.fechas = fechas;
	}
	public String[] getHoras() {
		return horas;
	}
	public void setHoras(String[] horas) {
		this.horas = horas;
	}
	public String getNombreSala() {
		return nombreSala;
	}
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}
	public ArrayList<Sala> getSalas() {
		return salas;
	}
	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}
	public boolean isIs3D() {
		return is3D;
	}


	
}
