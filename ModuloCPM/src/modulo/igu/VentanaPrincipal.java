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

public class VentanaPrincipal extends JFrame {
	private static Color DEFAUL_COLOR = new Color(32, 178, 170);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestorDePedidos gestor;
	private JPanel panelInicial;
	private JTextPane txtpnBienvenidosA;
	private JPanel panel;
	private JButton btnEspaol;
	private JButton btnIngls;
	private JLabel lblMelon;
	private JPanel panel_1;

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
		contentPane.setBackground(DEFAUL_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelInicial(), "inicial");
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
			panelInicial.setLayout(new BorderLayout(0, 0));
			panelInicial.add(getPanel(), BorderLayout.SOUTH);
			panelInicial.add(getTxtpnBienvenidosA(), BorderLayout.NORTH);
			panelInicial.add(getPanel_1(), BorderLayout.CENTER);
		}
		return panelInicial;
	}
	private JTextPane getTxtpnBienvenidosA() {
		if (txtpnBienvenidosA == null) {
			txtpnBienvenidosA = new JTextPane();
			txtpnBienvenidosA.setBackground(DEFAUL_COLOR);
			txtpnBienvenidosA.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			txtpnBienvenidosA.setEditable(false);
			txtpnBienvenidosA.setText("Bienvenidos a "+gestor.getNombreCine());
			System.out.println(txtpnBienvenidosA.getHeight());
			StyledDocument doc = txtpnBienvenidosA.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
		}
		return txtpnBienvenidosA;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(DEFAUL_COLOR);
			panel.add(getBtnEspaol());
			panel.add(getBtnIngls());
		}
		return panel;
	}
	private JButton getBtnEspaol() {
		if (btnEspaol == null) {
			btnEspaol = new JButton("Espa\u00F1ol");
			btnEspaol.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/modulo/img/banderaEs.jpg")));
			btnEspaol.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		return btnEspaol;
	}
	private JButton getBtnIngls() {
		if (btnIngls == null) {
			btnIngls = new JButton("Ingl\u00E9s");
			btnIngls.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/modulo/img/banderaEn.jpg")));
			btnIngls.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		return btnIngls;
	}
	private JLabel getLblMelon() {
		if (lblMelon == null) {
			lblMelon = new JLabel("");
			lblMelon.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					adaptarImagen((JLabel) e.getSource(), "/modulo/img/AMP0001.jpg");
				}
			});
		}
		return lblMelon;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLblMelon());
		}
		return panel_1;
	}
}
