package modulo.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modulo.logica.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestorDePedidos gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		gestor = new GestorDePedidos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gestor.setPeliculaActual(gestor.getCartelera().get(0));
		gestor.setSalaActual(gestor.getPeliculaActual().getSala("29/11/2014", "22:00"));
		gestor.comprarEntrada(1, 1, Entrada.PACK_CUMPLE);
		gestor.guardarSalas();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
