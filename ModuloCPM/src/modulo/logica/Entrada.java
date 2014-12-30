package modulo.logica;

public class Entrada {
	public static final int LIBRE = 0;
	public static final int NORMAL = 1;
	public static final int JUBILADO = 2;
	public static final int PACK_CUMPLE = 3;
	public static final int JUBILADO_Y_PACK_CUMPLE = 4;
	public static final int OCUPADA = -1;
	
	private String codigo;
	private String tituloPelicula; 
	private String fecha;
	private String hora;
	private int fila;
	private int butaca;
	private int tipo;
	
	public Entrada(String codigo, String tituloPelicula, String fecha,
			String hora, int fila, int butaca, int tipo) {
		setCodigo(codigo);
		setTituloPelicula(tituloPelicula);
		setFecha(fecha);
		setHora(hora);
		setFila(fila);
		setButaca(butaca);
		setTipo(tipo);
	}
	
	public String toString(){
		return getFila()+","+getButaca()+"";
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
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

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getButaca() {
		return butaca;
	}

	public void setButaca(int butaca) {
		this.butaca = butaca;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
