package modulo.logica;

public class Sala {
	private String nombreSala;
	private String codigo;
	private String fecha;
	private String hora;
	private int[][] sala;
	
	public Sala(String nombreSala, String codigo, String fecha, String hora){
		setNombreSala(nombreSala);
		setCodigo(codigo);
		setFecha(fecha);
		setHora(hora);
		sala = new int[10][4];
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
