package modulo.logica;

public class Sala {
	private static int NUMERO_FILAS = 4;
	private static int NUMERO_BUTACAS = 10;
	
	private String nombreSala;
	private String tituloPelicula;
	private String codigo;
	private String fecha;
	private String hora;
	private int[][] sala;
	private int entradasVendidas;
	
	public Sala(String nombreSala, String titulo, String codigo, String fecha, String hora){
		setNombreSala(nombreSala);
		setTituloPelicula(titulo);
		setCodigo(codigo);
		setFecha(fecha);
		setHora(hora);
		sala = new int[NUMERO_BUTACAS][NUMERO_FILAS];
		entradasVendidas = 0;
	}

	public Entrada cambiarTipoDeEntrada(int fila, int butaca, int tipo){
		sala[butaca][fila] = tipo;
		if(sala[butaca][fila] == 0 && tipo != 0){
			entradasVendidas++;
			return new Entrada(getCodigo(), getTituloPelicula(), getFecha(), getHora(), fila, butaca, tipo);
		}
		else{
			entradasVendidas--;
			return null;
		}
	}
	
	public boolean isSalaLlena(){
		return entradasVendidas == 30;
	}
	
	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}
	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
