package modulo.igu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import modulo.logica.*;

import java.awt.CardLayout;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.imgscalr.Scalr;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;

public class VentanaPrincipal extends JFrame {
	private static Color DEFAULT_COLOR = new Color(32, 178, 170);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestorDePedidos gestor;
	private JPanel panelInicial;
	private JTextPane txtpnBienvenidosA;
	private JPanel panelInicialSur;
	private JButton btnInicioEspaol;
	private JButton btnInicioIngls;
	private ResourceBundle traduccion;
	private JPanel panelCartelera;
	private JLabel lblCarteleraTitutlo;
	private JPanel panelCarteleraCentro;
	private JScrollPane scrollPaneTablaCartelera;
	private JTable tablaCartelera;
	private JPanel panelCarteleraSur;
	private JPanel panelCarteleraSurIzquierda;
	private JPanel panelCarteleraSurDerecha;
	private JButton btnCarteleraAtras;
	private JButton btnCarteleraSiguiente;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gestor = new GestorDePedidos();
		setTitle(gestor.getNombreCine());
		setBounds(100, 100, 805, 481);
		contentPane = new JPanel();
		contentPane.setBackground(DEFAULT_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelInicial(), "inicial");
		contentPane.add(getPanelCartelera(), "name_1419811776191793000");
	}
	
	private void localizar(Locale localizacion){
		if(localizacion == null){
			localizacion = Locale.getDefault(Locale.Category.FORMAT);
		}
		traduccion = ResourceBundle.getBundle("modulo.traducciones/traduccion", localizacion);
		//Inicio
		txtpnBienvenidosA.setText(traduccion.getString("bienvenidos") + " " + gestor.getNombreCine());
		btnInicioEspaol.setText(traduccion.getString("btnEs"));
		btnInicioIngls.setText(traduccion.getString("btnEn"));
		
	}
	
	private void adaptarImagen(Component componente, String ruta){
		if(componente instanceof JButton){
			try{
				JButton boton = (JButton) componente;
				BufferedImage icono = ImageIO.read(VentanaPrincipal.class.getResource(ruta));
				boton.setIcon(new ImageIcon(Scalr.resize(icono, Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC,
			               boton.getWidth(),  boton.getHeight(), Scalr.OP_ANTIALIAS)));
			}catch(Exception e){
				
			}
		}
		else if(componente instanceof JLabel){
			try{
				JLabel label = (JLabel) componente;
				BufferedImage icono = ImageIO.read(VentanaPrincipal.class.getResource(ruta));
				label.setIcon(new ImageIcon(Scalr.resize(icono, Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC, 
						label.getWidth(),  label.getHeight(), Scalr.OP_ANTIALIAS)));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	private JPanel getPanelInicial() {
		if (panelInicial == null) {
			panelInicial = new JPanel();
			panelInicial.setBackground(DEFAULT_COLOR);
			panelInicial.setLayout(new BorderLayout(0, 0));
			panelInicial.add(getTxtpnBienvenidosA(), BorderLayout.CENTER);
			panelInicial.add(getPanelInicialSur(), BorderLayout.SOUTH);
		}
		return panelInicial;
	}
	private JTextPane getTxtpnBienvenidosA() {
		if (txtpnBienvenidosA == null) {
			txtpnBienvenidosA = new JTextPane();
			txtpnBienvenidosA.setBackground(DEFAULT_COLOR);
			txtpnBienvenidosA.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			txtpnBienvenidosA.setEditable(false);
			txtpnBienvenidosA.setText("Bienvenidos a "+gestor.getNombreCine());
			StyledDocument doc = txtpnBienvenidosA.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		return txtpnBienvenidosA;
	}
	private JPanel getPanelInicialSur() {
		if (panelInicialSur == null) {
			panelInicialSur = new JPanel();
			panelInicialSur.setBackground(DEFAULT_COLOR);
			panelInicialSur.add(getBtnInicioEspaol());
			panelInicialSur.add(getBtnInicioIngls());
		}
		return panelInicialSur;
	}
	private JButton getBtnInicioEspaol() {
		if (btnInicioEspaol == null) {
			btnInicioEspaol = new JButton("Espa\u00F1ol");
			btnInicioEspaol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("es"));
				}
			});
			btnInicioEspaol.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/modulo/img/banderaEs.jpg")));
			btnInicioEspaol.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		return btnInicioEspaol;
	}
	private JButton getBtnInicioIngls() {
		if (btnInicioIngls == null) {
			btnInicioIngls = new JButton("Ingl\u00E9s");
			btnInicioIngls.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("en"));
				}
			});
			btnInicioIngls.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/modulo/img/banderaEn.jpg")));
			btnInicioIngls.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		return btnInicioIngls;
	}
	private JPanel getPanelCartelera() {
		if (panelCartelera == null) {
			panelCartelera = new JPanel();
			panelCartelera.setBackground(DEFAULT_COLOR);
			panelCartelera.setLayout(new BorderLayout(0, 0));
			panelCartelera.add(getLblCarteleraTitutlo(), BorderLayout.NORTH);
			panelCartelera.add(getPanelCarteleraCentro(), BorderLayout.CENTER);
			panelCartelera.add(getPanelCarteleraSur(), BorderLayout.SOUTH);
		}
		return panelCartelera;
	}
	private JLabel getLblCarteleraTitutlo() {
		if (lblCarteleraTitutlo == null) {
			lblCarteleraTitutlo = new JLabel("Cartelera Titutlo");
			lblCarteleraTitutlo.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		}
		return lblCarteleraTitutlo;
	}
	private JPanel getPanelCarteleraCentro() {
		if (panelCarteleraCentro == null) {
			panelCarteleraCentro = new JPanel();
			panelCarteleraCentro.setBackground(DEFAULT_COLOR);
			panelCarteleraCentro.setLayout(new BorderLayout(0, 0));
			panelCarteleraCentro.add(getScrollPaneTablaCartelera(), BorderLayout.CENTER);
		}
		return panelCarteleraCentro;
	}
	private JScrollPane getScrollPaneTablaCartelera() {
		if (scrollPaneTablaCartelera == null) {
			scrollPaneTablaCartelera = new JScrollPane();
			scrollPaneTablaCartelera.setOpaque(false);
			scrollPaneTablaCartelera.setBackground(DEFAULT_COLOR);
			scrollPaneTablaCartelera.setViewportView(getTablaCartelera());
		}
		return scrollPaneTablaCartelera;
	}
	private JTable getTablaCartelera() {
		if (tablaCartelera == null) {
			tablaCartelera = new JTable();
		}
		return tablaCartelera;
	}
	private JPanel getPanelCarteleraSur() {
		if (panelCarteleraSur == null) {
			panelCarteleraSur = new JPanel();
			panelCarteleraSur.setLayout(new GridLayout(0, 2, 0, 0));
			panelCarteleraSur.add(getPanelCarteleraSurIzquierda());
			panelCarteleraSur.add(getPanelCarteleraSurDerecha());
		}
		return panelCarteleraSur;
	}
	private JPanel getPanelCarteleraSurIzquierda() {
		if (panelCarteleraSurIzquierda == null) {
			panelCarteleraSurIzquierda = new JPanel();
			panelCarteleraSurIzquierda.setBackground(DEFAULT_COLOR);
			panelCarteleraSurIzquierda.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			panelCarteleraSurIzquierda.add(getBtnCarteleraAtras());
		}
		return panelCarteleraSurIzquierda;
	}
	private JPanel getPanelCarteleraSurDerecha() {
		if (panelCarteleraSurDerecha == null) {
			panelCarteleraSurDerecha = new JPanel();
			panelCarteleraSurDerecha.setBackground(DEFAULT_COLOR);
			FlowLayout flowLayout = (FlowLayout) panelCarteleraSurDerecha.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelCarteleraSurDerecha.add(getBtnCarteleraSiguiente());
		}
		return panelCarteleraSurDerecha;
	}
	private JButton getBtnCarteleraAtras() {
		if (btnCarteleraAtras == null) {
			btnCarteleraAtras = new JButton("New button");
			btnCarteleraAtras.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnCarteleraAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnCarteleraAtras;
	}
	private JButton getBtnCarteleraSiguiente() {
		if (btnCarteleraSiguiente == null) {
			btnCarteleraSiguiente = new JButton("Cartelera Siguiente");
			btnCarteleraSiguiente.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		return btnCarteleraSiguiente;
	}
}
