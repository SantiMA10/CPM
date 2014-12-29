package modulo.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import modulo.logica.*;
import modulo.util.ComponentsUtil;
import modulo.util.ImageUtil;
import modulo.util.MiCellRender;
import modulo.util.MiModeloTabla;

import java.awt.CardLayout;

import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.ImageIcon;

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

import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Color DEFAULT_COLOR = new Color(32, 178, 170);
	private static final int DEFAULT_BUTTON_SIZE = 18;
	private static final int DEFAULT_TITTLE_SIZE = 40;
	public static final int DEFAULT_BORDER_TITTLE_SIZE = 25;
	
	private JPanel contentPane;
	private GestorDePedidos gestor;
	private JPanel panelInicial;
	private JTextPane txtpnBienvenidosA;
	private JPanel panelInicialSur;
	private JButton btnInicioEspaol;
	private JButton btnInicioIngls;
	private ResourceBundle traduccion;
	private JPanel panelCartelera;
	private JLabel lblCarteleraTitulo;
	private JPanel panelCarteleraCentro;
	private JScrollPane scrollPaneTablaCartelera;
	private JTable tablaCartelera;
	private MiModeloTabla modeloCartelera;
	private JPanel panelCarteleraSur;
	private JPanel panelCarteleraSurIzquierda;
	private JPanel panelCarteleraSurDerecha;
	private JButton btnCarteleraAtras;
	private JButton btnCarteleraSiguiente;
	private JPanel panelCarteleraEste;
	private JPanel panelCarteleraRecomendadas;
	private JPanel panelCarteleraDatos;
	private JPanel panelCarteleraPrecios;
	private JPanel panelCarteleraPedido;
	private JLabel lblCarteleraRecomendada1;
	private JLabel lblCarteleraRecomendada2;

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
		contentPane.add(getPanelInicial(), "inicio");
		contentPane.add(getPanelCartelera(), "cartelera");
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
		//Cartelera
		lblCarteleraTitulo.setText(traduccion.getString("cartelera"));
		btnCarteleraAtras.setText(traduccion.getString("btnAtras"));
		btnCarteleraSiguiente.setText(traduccion.getString("btnSiguiente"));
		panelCarteleraRecomendadas.setBorder(ComponentsUtil.getBorder(traduccion.getString("recomendadas")));
		panelCarteleraPrecios.setBorder(ComponentsUtil.getBorder(traduccion.getString("precios")));
		panelCarteleraPedido.setBorder(ComponentsUtil.getBorder(traduccion.getString("pedido")));
		
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
			txtpnBienvenidosA.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TITTLE_SIZE));
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
					((CardLayout)contentPane.getLayout()).show(contentPane,"cartelera");
				}
			});
			btnInicioEspaol.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/modulo/img/banderaEs.jpg")));
			btnInicioEspaol.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnInicioEspaol;
	}
	private JButton getBtnInicioIngls() {
		if (btnInicioIngls == null) {
			btnInicioIngls = new JButton("Ingl\u00E9s");
			btnInicioIngls.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("en"));
					((CardLayout)contentPane.getLayout()).show(contentPane,"cartelera");
				}
			});
			btnInicioIngls.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/modulo/img/banderaEn.jpg")));
			btnInicioIngls.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
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
			panelCartelera.add(getPanelCarteleraEste(), BorderLayout.EAST);
		}
		return panelCartelera;
	}
	private JLabel getLblCarteleraTitutlo() {
		if (lblCarteleraTitulo == null) {
			lblCarteleraTitulo = new JLabel("Cartelera Titutlo");
			lblCarteleraTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TITTLE_SIZE));
		}
		return lblCarteleraTitulo;
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
			String[] nombreColumnas = {"Pelicula","Informacion","Oculto"};
			modeloCartelera = new MiModeloTabla(nombreColumnas, 0);
			tablaCartelera = new JTable(modeloCartelera);
			tablaCartelera.getTableHeader().setReorderingAllowed(false);
			tablaCartelera.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			prepararModeloCartelera();
			tablaCartelera.setDefaultRenderer(JTextPane.class,  new MiCellRender());
			
		}
		return tablaCartelera;
	}
	private void prepararModeloCartelera(){
		Object[] nuevaFila = new Object[3];
		for(int i = 0; i < gestor.getCartelera().size(); i++){
			nuevaFila[0] = ImageUtil.redimensionarImagen(gestor.getCartelera().get(i).getRutaImagen(), 432, 300);
			nuevaFila[1] = ComponentsUtil.getJTextPane(gestor.getCartelera().get(i).getTitulo() + "\n" + 
			gestor.getCartelera().get(i).getNombreSala());
			nuevaFila[2] = gestor.getCartelera().get(i);
			modeloCartelera.addRow(nuevaFila);
			tablaCartelera.setRowHeight(i, 300);
		}
		tablaCartelera.getColumnModel().getColumn(0).setMaxWidth(208);
		tablaCartelera.getColumnModel().getColumn(0).setMinWidth(208);

		tablaCartelera.getColumnModel().removeColumn(tablaCartelera.getColumnModel().getColumn(2));
	}
	private JPanel getPanelCarteleraSur() {
		if (panelCarteleraSur == null) {
			panelCarteleraSur = new JPanel();
			panelCarteleraSur.setBackground(DEFAULT_COLOR);
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
			btnCarteleraAtras = new JButton("Cartelera Atras");
			btnCarteleraAtras.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
			btnCarteleraAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)contentPane.getLayout()).show(contentPane,"inicio");
				}
			});
		}
		return btnCarteleraAtras;
	}
	private JButton getBtnCarteleraSiguiente() {
		if (btnCarteleraSiguiente == null) {
			btnCarteleraSiguiente = new JButton("Cartelera Siguiente");
			btnCarteleraSiguiente.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnCarteleraSiguiente;
	}
	private JPanel getPanelCarteleraEste() {
		if (panelCarteleraEste == null) {
			panelCarteleraEste = new JPanel();
			panelCarteleraEste.setBackground(DEFAULT_COLOR);
			panelCarteleraEste.setLayout(new GridLayout(2, 0, 0, 0));
			panelCarteleraEste.add(getPanelCarteleraRecomendadas());
			panelCarteleraEste.add(getPanelCarteleraDatos());
		}
		return panelCarteleraEste;
	}
	private JPanel getPanelCarteleraRecomendadas() {
		if (panelCarteleraRecomendadas == null) {
			panelCarteleraRecomendadas = new JPanel();
			panelCarteleraRecomendadas.setBackground(DEFAULT_COLOR);
			panelCarteleraRecomendadas.setLayout(new GridLayout(0, 2, 5, 5));
			panelCarteleraRecomendadas.add(getLblCarteleraRecomendada1());
			panelCarteleraRecomendadas.add(getLblCarteleraRecomendada2());
		}
		return panelCarteleraRecomendadas;
	}
	private JPanel getPanelCarteleraDatos() {
		if (panelCarteleraDatos == null) {
			panelCarteleraDatos = new JPanel();
			panelCarteleraDatos.setBackground(DEFAULT_COLOR);
			panelCarteleraDatos.setLayout(new GridLayout(2, 0, 0, 0));
			panelCarteleraDatos.add(getPanelCarteleraPrecios());
			panelCarteleraDatos.add(getPanelCarteleraPedido());
		}
		return panelCarteleraDatos;
	}
	private JPanel getPanelCarteleraPrecios() {
		if (panelCarteleraPrecios == null) {
			panelCarteleraPrecios = new JPanel();
			panelCarteleraPrecios.setBackground(DEFAULT_COLOR);
		}
		return panelCarteleraPrecios;
	}
	private JPanel getPanelCarteleraPedido() {
		if (panelCarteleraPedido == null) {
			panelCarteleraPedido = new JPanel();
			panelCarteleraPedido.setBackground(DEFAULT_COLOR);
		}
		return panelCarteleraPedido;
	}
	private JLabel getLblCarteleraRecomendada1() {
		if (lblCarteleraRecomendada1 == null) {
			lblCarteleraRecomendada1 = new JLabel("");
			lblCarteleraRecomendada1.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					ImageUtil.adaptarImagen(lblCarteleraRecomendada1, gestor.getRecomendadas()[0].getRutaImagen());
				}
			});
		}
		return lblCarteleraRecomendada1;
	}
	private JLabel getLblCarteleraRecomendada2() {
		if (lblCarteleraRecomendada2 == null) {
			lblCarteleraRecomendada2 = new JLabel("");
			lblCarteleraRecomendada2.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					ImageUtil.adaptarImagen(lblCarteleraRecomendada2, gestor.getRecomendadas()[0].getRutaImagen());
				}
			});
		}
		return lblCarteleraRecomendada2;
	}
}
