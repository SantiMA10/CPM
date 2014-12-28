package modulo.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
		setTitle(gestor.getNombreCine());
		setBounds(100, 100, 805, 481);
		contentPane = new JPanel();
		contentPane.setBackground(DEFAUL_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelInicial(), "inicial");
	}

	private JPanel getPanelInicial() {
		if (panelInicial == null) {
			panelInicial = new JPanel();
			panelInicial.setLayout(new BorderLayout(0, 0));
			panelInicial.add(getTxtpnBienvenidosA(), BorderLayout.CENTER);
			panelInicial.add(getPanel(), BorderLayout.SOUTH);
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
		}
		return btnEspaol;
	}
	private JButton getBtnIngls() {
		if (btnIngls == null) {
			btnIngls = new JButton("Ingl\u00E9s");
		}
		return btnIngls;
	}
}
