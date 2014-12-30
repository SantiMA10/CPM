package modulo.igu;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import modulo.logica.*;
import modulo.util.ComponentsUtil;
import modulo.util.DateUtil;
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
import java.net.URI;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;

import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Color DEFAULT_COLOR = new Color(32, 178, 170);
	public static final int DEFAULT_BUTTON_SIZE = 18;//35
	public static final int DEFAULT_TITTLE_SIZE = 60;
	public static final int DEFAULT_TEXTAREA_SIZE = 25;
	public static final int DEFAULT_BORDER_TITTLE_SIZE = 30;
	public static final int TABLE_HEADER_HEIGHT = 32;
	public static final int TABLE_HEADER_SIZE = 18;
	
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
	private JScrollPane scrollPanePrecios;
	private JScrollPane scrollPanePedido;
	private JList<Pelicula> listaPedido;
	private DefaultListModel<Pelicula> modeloListaPedido;
	private JPanel panelCarteleraPedidoSur;
	private JButton btnCarteleraIrPedido;
	private JTextArea txtrCarteleraPrecios;
	private JPanel panelPelicula;
	private JLabel lblPeliculaTitulo;
	private JPanel panelPeliculaSur;
	private JPanel panelPeliculaSurIzquierda;
	private JPanel panelPeliculaSurDerecha;
	private JButton btnPeliculaAtras;
	private JButton btnPeliculaSiguiente;
	private JPanel panelPeliculaOeste;
	private JPanel panelPeliculaCentro;
	private JPanel panelPeliculaInformacion;
	private JPanel panelPeliculaSinopsis;
	private JLabel lblPeliculaImagen;
	private JButton btnPeliculaVerTrailer;
	private JScrollPane scrollPaneInformacion;
	private JScrollPane scrollPaneSinopsis;
	private JTextArea txtrSinopsis;
	private JTextArea txtrInformacion;
	private JButton btnPeliculaFormato;
	private JPanel panelHorario;
	private JCalendar calendar;
	private JPanel panelHorarioCentro;
	private JPanel panelHorarioHoras;
	private JScrollPane scrollPaneHoras;
	private JList<String> listaHoras;
	private DefaultListModel<String> modeloListaHoras;
	private JLabel lblHorarioTitulo;
	private JPanel panelHorarioSur;
	private JPanel panelHorarioOeste;
	private JPanel panelHorarioSurIzquierda;
	private JPanel panelHorarioSurCentro;
	private JPanel panelHorarioSurDerecha;
	private JButton btnHorarioAtras;
	private JButton btnHorarioVolverCartelera;
	private JButton btnHorarioSiguiente;
	private JLabel lblHorarioImagen;
	private Component horizontalGlue;
	private JPanel panelHorarioJCalendar;
	private JPanel panelSala;
	private JPanel panelSalaNorte;
	private JPanel panelSalaSur;
	private JPanel panelSalaSurDerecha;
	private JPanel panelSalaSurCentro;
	private JPanel panelSalaSurIzquierda;
	private JPanel panelSalaEste;
	private JPanel panelSalaEsteLeyenda;
	private JPanel panelSalaEsteAbajo;
	private JPanel panelSalaTipoEntrada;
	private JPanel panelSalaPedido;
	private JButton btnSalaAtras;
	private JButton btnSalaVolverCartelera;
	private JButton btnSalaSiguiente;
	private JLabel lblSalaTitulo;
	private JLabel lblSalaSesion;
	private JLabel lblLeyendaLibre;
	private JLabel lblLeyendaLibreImagen;
	private JLabel lblLeyendaOcupado;
	private JLabel lblLeyendaOcupadoImagen;
	private JLabel lblLeyendaNormal;
	private JLabel lblLeyendaNormalImagen;
	private JLabel lblLeyendaJubilado;
	private JLabel lblLeyendaJubiladoImagen;
	private JLabel lblLeyendaCumple;
	private JLabel lblLeyendaCumpleImagen;
	private JLabel lblLeyendaJubicumpleImagen;
	private JPanel panelSalaTipoEntradaCheck;
	private JCheckBox chckbxJubilado;
	private JCheckBox chckbxCumple;
	private JScrollPane scrollPaneTipoEntrada;
	private JTextArea txtrTipoEntrada;
	private JPanel panelSalaPedidoTotal;
	private JScrollPane scrollPanelSalaPedido;
	private JTextArea txtrSalaPedido;
	private JLabel lblEntradasTotales;
	private JTextField txtEntradasTotales;
	private JTextArea txtrLeyendaJubiCumple;
	private JPanel panelSalaCentro;
	private JButton btnButaca;
	private JButton btnButaca_1;
	private JButton btnButaca_2;
	private JButton btnButaca_3;
	private JButton btnButaca_4;
	private Component horizontalGluePasillo3;
	private JButton btnButaca_5;
	private JButton btnButaca_6;
	private JButton btnButaca_7;
	private JButton btnButaca_8;
	private JButton btnButaca_9;
	private Component horizontalGlueHueco2I;
	private JButton btnButaca_10;
	private JButton btnButaca_11;
	private JButton btnButuca;
	private JButton btnButaca_12;
	private Component horizontalGluePasillo2;
	private JButton btnButaca_13;
	private JButton btnButaca_14;
	private JButton btnButaca_15;
	private JButton btnButaca_16;
	private Component horizontalGlueHueco2D;
	private Component horizontalGlueHueco1I;
	private JButton btnButaca_18;
	private JButton btnButaca_19;
	private JButton btnButaca_20;
	private JButton btnButaca_21;
	private Component horizontalGluePasillo1;
	private JButton btnButaca_22;
	private JButton btnButaca_23;
	private JButton btnButaca_24;
	private JButton btnButaca_25;
	private Component horizontalGlueHueco1D;
	private Component horizontalGlueHueco0I2;
	private Component horizontalGlueHueco0I1;
	private Component horizontalGlueHueco0I0;
	private JButton btnButaca_17;
	private JButton btnButaca_26;
	private Component horizontalGluePasillo0;
	private JButton btnButaca_27;
	private JButton btnButaca_28;
	private Component horizontalGlueHueco0D0;
	private Component horizontalGlueHueco0D1;
	private Component horizontalGlueHueco0D2;


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
		contentPane.add(getPanelCartelera(), "cartelera");
		contentPane.add(getPanelPelicula(), "pelicula");
		contentPane.add(getPanelHorario(), "horario");
		contentPane.add(getPanelSala(), "sala");
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
		btnCarteleraIrPedido.setText(traduccion.getString("btnIrPedido"));
		modeloCartelera.setColumnIdentifiers(new String[]{traduccion.getString("pelicula"),traduccion.getString("informacion"),"Oculto"});
		ajustarTablaCartelera();
		txtrCarteleraPrecios.setText(gestor.getListaPrecios(traduccion));
		//Pelicula
		btnPeliculaAtras.setText(traduccion.getString("btnAtras"));
		btnPeliculaSiguiente.setText(traduccion.getString("btnSiguiente"));
		btnPeliculaVerTrailer.setText(traduccion.getString("btnVerTrailer"));
		panelPeliculaSinopsis.setBorder(ComponentsUtil.getBorder(traduccion.getString("sinopsis")));
		panelPeliculaInformacion.setBorder(ComponentsUtil.getBorder(traduccion.getString("informacion")));
		//Horario
		btnHorarioAtras.setText(traduccion.getString("btnAtras"));
		btnHorarioVolverCartelera.setText(traduccion.getString("btnVolverACartelera"));
		btnHorarioSiguiente.setText(traduccion.getString("btnSiguiente"));
		lblHorarioTitulo.setText(traduccion.getString("horario"));
		panelHorarioJCalendar.setBorder(ComponentsUtil.getBorder(traduccion.getString("calendario")));
		//Sala
		panelSalaEsteLeyenda.setBorder(ComponentsUtil.getBorder(traduccion.getString("leyenda")));
		panelSalaTipoEntrada.setBorder(ComponentsUtil.getBorder(traduccion.getString("tipoEntrada")));
		panelSalaPedido.setBorder(ComponentsUtil.getBorder(traduccion.getString("pedidoActual")));
		lblLeyendaLibre.setText(traduccion.getString("libre"));
		lblLeyendaOcupado.setText(traduccion.getString("ocupado"));
		lblLeyendaNormal.setText(traduccion.getString("normal"));
		lblLeyendaJubilado.setText(traduccion.getString("jubilado"));
		lblLeyendaCumple.setText(traduccion.getString("cumple"));
		txtrLeyendaJubiCumple.setText(traduccion.getString("jubicumple"));
		chckbxCumple.setText(traduccion.getString("cumple"));
		chckbxJubilado.setText(traduccion.getString("jubilado"));
		btnSalaAtras.setText(traduccion.getString("btnAtras"));
		btnSalaSiguiente.setText(traduccion.getString("btnSiguiente"));
		btnSalaVolverCartelera.setText(traduccion.getString("btnVolverACartelera"));
		txtrTipoEntrada.setText(traduccion.getString("notaTipoEntrada"));
		txtrSalaPedido.setText(traduccion.getString("pedidoVacio"));
		lblEntradasTotales.setText(traduccion.getString("entradasTotales"));
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
			tablaCartelera.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int fila = tablaCartelera.getSelectedRow();
					if(fila != -1){
						if(e.getClickCount() == 1){
							btnCarteleraSiguiente.setEnabled(true);
						}
						if(e.getClickCount() == 2){
							gestor.setPeliculaActual((Pelicula) modeloCartelera.getValueAt(fila, 2));
							pasarAPanelPelicula();
						}
					}
				}
			});
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
			nuevaFila[1] = ComponentsUtil.getJTextPane(gestor.getCartelera().get(i) + "\n" + 
			gestor.getCartelera().get(i).getNombreSala());
			nuevaFila[2] = gestor.getCartelera().get(i);
			modeloCartelera.addRow(nuevaFila);
		}
	}
	private void ajustarTablaCartelera(){
		for(int i = 0; i < tablaCartelera.getRowCount(); i++){
			tablaCartelera.setRowHeight(i, 300);
		}
		ComponentsUtil.changeJTableHeaderSize(tablaCartelera);
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
					((CardLayout)contentPane.getLayout()).show(contentPane,"inicial");
				}
			});
		}
		return btnCarteleraAtras;
	}
	private JButton getBtnCarteleraSiguiente() {
		if (btnCarteleraSiguiente == null) {
			btnCarteleraSiguiente = new JButton("Cartelera Siguiente");
			btnCarteleraSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int fila = tablaCartelera.getSelectedRow();
					if(fila != -1){
						gestor.setPeliculaActual((Pelicula) modeloCartelera.getValueAt(fila, 2));
						pasarAPanelPelicula();
					}
				}
			});
			btnCarteleraSiguiente.setEnabled(false);
			btnCarteleraSiguiente.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnCarteleraSiguiente;
	}
	private void pasarAPanelPelicula(){
		prepararPanelPelicula();
		((CardLayout)contentPane.getLayout()).show(contentPane,"pelicula");
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
			panelCarteleraPrecios.setLayout(new BorderLayout(0, 0));
			panelCarteleraPrecios.add(getScrollPanePrecios());
		}
		return panelCarteleraPrecios;
	}
	private JPanel getPanelCarteleraPedido() {
		if (panelCarteleraPedido == null) {
			panelCarteleraPedido = new JPanel();
			if(gestor.isPedidoVacio()){
				panelCarteleraPedido.setVisible(false);
			}
			panelCarteleraPedido.setBackground(DEFAULT_COLOR);
			panelCarteleraPedido.setLayout(new BorderLayout(0, 0));
			panelCarteleraPedido.add(getScrollPanePedido());
			panelCarteleraPedido.add(getPanelCarteleraPedidoSur(), BorderLayout.SOUTH);
		}
		return panelCarteleraPedido;
	}
	private JLabel getLblCarteleraRecomendada1() {
		if (lblCarteleraRecomendada1 == null) {
			lblCarteleraRecomendada1 = new JLabel("");
			lblCarteleraRecomendada1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					gestor.setPeliculaActual(gestor.getRecomendadas()[0]);
					pasarAPanelPelicula();
				}
			});
			lblCarteleraRecomendada1.setHorizontalAlignment(SwingConstants.CENTER);
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
			lblCarteleraRecomendada2.setHorizontalAlignment(SwingConstants.CENTER);
			lblCarteleraRecomendada2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					gestor.setPeliculaActual(gestor.getRecomendadas()[1]);
					pasarAPanelPelicula();
				}
			});
			lblCarteleraRecomendada2.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					ImageUtil.adaptarImagen(lblCarteleraRecomendada2, gestor.getRecomendadas()[1].getRutaImagen());
				}
			});
		}
		return lblCarteleraRecomendada2;
	}
	private JScrollPane getScrollPanePrecios() {
		if (scrollPanePrecios == null) {
			scrollPanePrecios = new JScrollPane();
			scrollPanePrecios.setBackground(DEFAULT_COLOR);
			scrollPanePrecios.setViewportView(getTxtrCarteleraPrecios());
		}
		return scrollPanePrecios;
	}
	private JScrollPane getScrollPanePedido() {
		if (scrollPanePedido == null) {
			scrollPanePedido = new JScrollPane();
			scrollPanePedido.setBackground(DEFAULT_COLOR);
			scrollPanePedido.setViewportView(getListaPedido());
		}
		return scrollPanePedido;
	}
	private JList<Pelicula> getListaPedido() {
		if (listaPedido == null) {
			modeloListaPedido = new DefaultListModel<Pelicula>();
			listaPedido = new JList<Pelicula>(modeloListaPedido);
		}
		return listaPedido;
	}
	private JPanel getPanelCarteleraPedidoSur() {
		if (panelCarteleraPedidoSur == null) {
			panelCarteleraPedidoSur = new JPanel();
			panelCarteleraPedidoSur.setBackground(DEFAULT_COLOR);
			panelCarteleraPedidoSur.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panelCarteleraPedidoSur.add(getBtnCarteleraIrPedido());
		}
		return panelCarteleraPedidoSur;
	}
	private JButton getBtnCarteleraIrPedido() {
		if (btnCarteleraIrPedido == null) {
			btnCarteleraIrPedido = new JButton("Cartelera Ir Pedido");
		}
		return btnCarteleraIrPedido;
	}
	private JTextArea getTxtrCarteleraPrecios() {
		if (txtrCarteleraPrecios == null) {
			txtrCarteleraPrecios = new JTextArea();
			txtrCarteleraPrecios.setText("Cartelera Precios");
		}
		return txtrCarteleraPrecios;
	}
	private JPanel getPanelPelicula() {
		if (panelPelicula == null) {
			panelPelicula = new JPanel();
			panelPelicula.setBackground(DEFAULT_COLOR);
			panelPelicula.setLayout(new BorderLayout(0, 0));
			panelPelicula.add(getLblPeliculaTitulo(), BorderLayout.NORTH);
			panelPelicula.add(getPanelPeliculaSur(), BorderLayout.SOUTH);
			panelPelicula.add(getPanelPeliculaOeste(), BorderLayout.WEST);
			panelPelicula.add(getPanelPeliculaCentro(), BorderLayout.CENTER);
		}
		return panelPelicula;
	}
	private JLabel getLblPeliculaTitulo() {
		if (lblPeliculaTitulo == null) {
			lblPeliculaTitulo = new JLabel("Pelicula Titulo");
			lblPeliculaTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TITTLE_SIZE));
		}
		return lblPeliculaTitulo;
	}
	private JPanel getPanelPeliculaSur() {
		if (panelPeliculaSur == null) {
			panelPeliculaSur = new JPanel();
			panelPeliculaSur.setBackground(DEFAULT_COLOR);
			panelPeliculaSur.setLayout(new GridLayout(0, 2, 0, 0));
			panelPeliculaSur.add(getPanelPeliculaSurIzquierda());
			panelPeliculaSur.add(getPanelPeliculaSurDerecha());
		}
		return panelPeliculaSur;
	}
	private JPanel getPanelPeliculaSurIzquierda() {
		if (panelPeliculaSurIzquierda == null) {
			panelPeliculaSurIzquierda = new JPanel();
			panelPeliculaSurIzquierda.setBackground(DEFAULT_COLOR);
			panelPeliculaSurIzquierda.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			panelPeliculaSurIzquierda.add(getBtnPeliculaAtras());
		}
		return panelPeliculaSurIzquierda;
	}
	private JPanel getPanelPeliculaSurDerecha() {
		if (panelPeliculaSurDerecha == null) {
			panelPeliculaSurDerecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelPeliculaSurDerecha.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelPeliculaSurDerecha.setBackground(DEFAULT_COLOR);
			panelPeliculaSurDerecha.add(getBtnPeliculaFormato());
			panelPeliculaSurDerecha.add(getBtnPeliculaSiguiente());
		}
		return panelPeliculaSurDerecha;
	}
	private JButton getBtnPeliculaAtras() {
		if (btnPeliculaAtras == null) {
			btnPeliculaAtras = new JButton("Pelicula Atras");
			btnPeliculaAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblPeliculaImagen.setIcon(null);
					lblPeliculaImagen.removeComponentListener(lblPeliculaImagen.getComponentListeners()[0]);
					((CardLayout)contentPane.getLayout()).show(contentPane,"cartelera");
				}
			});
			btnPeliculaAtras.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnPeliculaAtras;
	}
	private JButton getBtnPeliculaSiguiente() {
		if (btnPeliculaSiguiente == null) {
			btnPeliculaSiguiente = new JButton("Pelicula Siguiente");
			btnPeliculaSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblPeliculaImagen.setIcon(null);
					lblPeliculaImagen.removeComponentListener(lblPeliculaImagen.getComponentListeners()[0]);
					prepararPanelHorario();
					((CardLayout)contentPane.getLayout()).show(contentPane,"horario");
				}
			});
			btnPeliculaSiguiente.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnPeliculaSiguiente;
	}
	private JPanel getPanelPeliculaOeste() {
		if (panelPeliculaOeste == null) {
			panelPeliculaOeste = new JPanel();
			panelPeliculaOeste.setBackground(DEFAULT_COLOR);
			panelPeliculaOeste.setLayout(new BorderLayout(0, 0));
			panelPeliculaOeste.add(getLblPeliculaImagen());
			panelPeliculaOeste.add(getBtnPeliculaVerTrailer(), BorderLayout.SOUTH);
		}
		return panelPeliculaOeste;
	}
	private JPanel getPanelPeliculaCentro() {
		if (panelPeliculaCentro == null) {
			panelPeliculaCentro = new JPanel();
			panelPeliculaCentro.setBackground(DEFAULT_COLOR);
			panelPeliculaCentro.setLayout(new GridLayout(2, 0, 0, 0));
			panelPeliculaCentro.add(getPanelPeliculaInformacion());
			panelPeliculaCentro.add(getPanelPeliculaSinopsis());
		}
		return panelPeliculaCentro;
	}
	private JPanel getPanelPeliculaInformacion() {
		if (panelPeliculaInformacion == null) {
			panelPeliculaInformacion = new JPanel();
			panelPeliculaInformacion.setBackground(DEFAULT_COLOR);
			panelPeliculaInformacion.setLayout(new BorderLayout(0, 0));
			panelPeliculaInformacion.add(getScrollPaneInformacion());
		}
		return panelPeliculaInformacion;
	}
	private JPanel getPanelPeliculaSinopsis() {
		if (panelPeliculaSinopsis == null) {
			panelPeliculaSinopsis = new JPanel();
			panelPeliculaSinopsis.setBackground(DEFAULT_COLOR);
			panelPeliculaSinopsis.setLayout(new BorderLayout(0, 0));
			panelPeliculaSinopsis.add(getScrollPaneSinopsis());
		}
		return panelPeliculaSinopsis;
	}
	private JLabel getLblPeliculaImagen() {
		if (lblPeliculaImagen == null) {
			lblPeliculaImagen = new JLabel("");
			lblPeliculaImagen.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPeliculaImagen;
	}
	private void prepararPanelPelicula(){
		ImageUtil.adaptarImagen(lblPeliculaImagen, gestor.getPeliculaActual().getRutaImagen());
		lblPeliculaImagen.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ImageUtil.adaptarImagen(lblPeliculaImagen, gestor.getPeliculaActual().getRutaImagen());
			}
		});
		lblPeliculaTitulo.setText(gestor.getPeliculaActual().toString());
		txtrSinopsis.setText(gestor.getPeliculaActual().getSinopsis());
		txtrInformacion.setText(gestor.getPeliculaActual().getInformacion(traduccion));
		Pelicula pelicula = gestor.cambiarFormato();
		if(pelicula != null){
			btnPeliculaFormato.setVisible(true);
			if(!pelicula.isIs3D()){
				btnPeliculaFormato.setActionCommand("2D");
				btnPeliculaFormato.setText(traduccion.getString("btnFormato2D"));
			}
			else{
				btnPeliculaFormato.setActionCommand("3D");
				btnPeliculaFormato.setText(traduccion.getString("btnFormato3D"));
			}
		}
		else{
			btnPeliculaFormato.setVisible(false);
		}
		if(gestor.getPeliculaActual().getTrailerID() != null){
			btnPeliculaVerTrailer.setEnabled(true);
		}
		else{
			btnPeliculaVerTrailer.setEnabled(false);
		}
	}
	private void openOnYouTube(String id) {
	    if (Desktop.isDesktopSupported() && !id.isEmpty()) {
	      try{
	    	  URI url = new URI("http://www.youtube.com/v/" + id);
	    	  Desktop.getDesktop().browse(url);
	      }catch (Exception e) { 
	    	  e.printStackTrace();
	      }
	    }
	    else{
	    	JOptionPane.showMessageDialog(this, traduccion.getString("errorYouTube"), traduccion.getString("error"), JOptionPane.WARNING_MESSAGE);
	    }
	}
	private JButton getBtnPeliculaVerTrailer() {
		if (btnPeliculaVerTrailer == null) {
			btnPeliculaVerTrailer = new JButton("Pelicula Ver Trailer");
			btnPeliculaVerTrailer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					openOnYouTube(gestor.getPeliculaActual().getTrailerID());
				}
			});
			btnPeliculaVerTrailer.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnPeliculaVerTrailer;
	}
	private JScrollPane getScrollPaneInformacion() {
		if (scrollPaneInformacion == null) {
			scrollPaneInformacion = new JScrollPane();
			scrollPaneInformacion.setViewportView(getTxtrInformacion());
		}
		return scrollPaneInformacion;
	}
	private JScrollPane getScrollPaneSinopsis() {
		if (scrollPaneSinopsis == null) {
			scrollPaneSinopsis = new JScrollPane();
			scrollPaneSinopsis.setViewportView(getTxtrSinopsis());
		}
		return scrollPaneSinopsis;
	}
	private JTextArea getTxtrSinopsis() {
		if (txtrSinopsis == null) {
			txtrSinopsis = new JTextArea();
			txtrSinopsis.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TEXTAREA_SIZE));
			txtrSinopsis.setLineWrap(true);
			txtrSinopsis.setWrapStyleWord(true);
			txtrSinopsis.setEditable(false);
			txtrSinopsis.setText("Sinopsis");
		}
		return txtrSinopsis;
	}
	private JTextArea getTxtrInformacion() {
		if (txtrInformacion == null) {
			txtrInformacion = new JTextArea();
			txtrInformacion.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TEXTAREA_SIZE));
			txtrInformacion.setLineWrap(true);
			txtrInformacion.setEditable(false);
			txtrInformacion.setWrapStyleWord(true);
			txtrInformacion.setText("Informacion");
		}
		return txtrInformacion;
	}
	private JButton getBtnPeliculaFormato() {
		if (btnPeliculaFormato == null) {
			btnPeliculaFormato = new JButton("Pelicula Formato");
			btnPeliculaFormato.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
			btnPeliculaFormato.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gestor.setPeliculaActual(gestor.cambiarFormato());
					prepararPanelPelicula();
				}
			});
		}
		return btnPeliculaFormato;
	}
	private JPanel getPanelHorario() {
		if (panelHorario == null) {
			panelHorario = new JPanel();
			panelHorario.setBackground(DEFAULT_COLOR);
			panelHorario.setLayout(new BorderLayout(0, 0));
			panelHorario.add(getPanelHorarioSur(), BorderLayout.SOUTH);
			panelHorario.add(getPanelHorarioOeste(), BorderLayout.WEST);
			panelHorario.add(getPanelHorarioCentro());
			panelHorario.add(getLblHorarioTitulo(), BorderLayout.NORTH);
		}
		return panelHorario;
	}
	private void prepararPanelHorario(){
		ImageUtil.adaptarImagen(lblHorarioImagen, gestor.getPeliculaActual().getRutaImagen());
		iniciarJCalendar();
		prepararModeloListaHoras();
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {  
				calendar.getDayChooser().getDayPanel().getComponentAt(calendar.getDayChooser().getDayPanel().getLocation()).setForeground(DEFAULT_COLOR);
				String fecha = calendar.getDayChooser().getDay()+"/"+calendar.getMonthChooser().getMonth()+"/"+calendar.getYearChooser().getYear();
				panelHorarioHoras.setBorder(ComponentsUtil.getBorder(DateUtil.getFechaConFormato(fecha, traduccion.getLocale())));
				prepararModeloListaHoras();
			}
		});
	}
	//
	private void iniciarJCalendar(){
		String fechaMinima = gestor.getPeliculaActual().getFechas()[0];
		String fechaMaxima = gestor.getPeliculaActual().getFechas()[gestor.getPeliculaActual().getFechas().length-1];
		calendar = new JCalendar(DateUtil.getFecha(fechaMinima));
		calendar.setLocale(traduccion.getLocale());
		if(panelHorarioJCalendar.getComponentCount() == 1){
			panelHorarioJCalendar.remove(0);
			panelHorarioJCalendar.add(calendar);
		}
		else{
			panelHorarioJCalendar.add(calendar);
		}
		panelHorarioHoras.setBorder(ComponentsUtil.getBorder(DateUtil.getFechaConFormato(fechaMinima, traduccion.getLocale())));
		calendar.setSelectableDateRange(DateUtil.getFecha(fechaMinima), DateUtil.getFecha(fechaMaxima));
	}
	private void prepararModeloListaHoras(){
		modeloListaHoras.clear();
		for(int i = 0; i < gestor.getPeliculaActual().getHoras().length; i++){
			modeloListaHoras.addElement(gestor.getPeliculaActual().getHoras()[i]);
		}
	}
	private JPanel getPanelHorarioCentro() {
		if (panelHorarioCentro == null) {
			panelHorarioCentro = new JPanel();
			panelHorarioCentro.setBackground(DEFAULT_COLOR);
			panelHorarioCentro.setLayout(new GridLayout(2, 2, 2, 5));
			panelHorarioCentro.add(getPanelHorarioJCalendar());
			panelHorarioCentro.add(getPanelHorarioHoras());

		}
		return panelHorarioCentro;
	}
	private JPanel getPanelHorarioHoras() {
		if (panelHorarioHoras == null) {
			panelHorarioHoras = new JPanel();
			panelHorarioHoras.setBackground(DEFAULT_COLOR);
			panelHorarioHoras.setLayout(new BorderLayout(0, 0));
			panelHorarioHoras.add(getScrollPaneHoras(), BorderLayout.CENTER);
		}
		return panelHorarioHoras;
	}
	private JScrollPane getScrollPaneHoras() {
		if (scrollPaneHoras == null) {
			scrollPaneHoras = new JScrollPane();
			scrollPaneHoras.setViewportView(getListaHoras());
		}
		return scrollPaneHoras;
	}
	private JList<String> getListaHoras() {
		if (listaHoras == null) {
			modeloListaHoras = new DefaultListModel<String>();
			listaHoras = new JList<String>(modeloListaHoras);
			listaHoras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1){
						btnHorarioSiguiente.setEnabled(true);
					}
					else if(e.getClickCount() == 2){
						gestor.setSalaActual(DateUtil.getFechaSinFormato(((TitledBorder)panelHorarioHoras.getBorder()).getTitle(), traduccion.getLocale()), listaHoras.getSelectedValue());
					}
				}
			});
			listaHoras.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			listaHoras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listaHoras;
	}
	private JLabel getLblHorarioTitulo() {
		if (lblHorarioTitulo == null) {
			lblHorarioTitulo = new JLabel("Horario Titulo");
			lblHorarioTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TITTLE_SIZE));
		}
		return lblHorarioTitulo;
	}
	private JPanel getPanelHorarioSur() {
		if (panelHorarioSur == null) {
			panelHorarioSur = new JPanel();
			panelHorarioSur.setBackground(DEFAULT_COLOR);
			panelHorarioSur.setLayout(new GridLayout(0, 3, 0, 0));
			panelHorarioSur.add(getPanelHorarioSurIzquierda());
			panelHorarioSur.add(getPanelHorarioSurCentro());
			panelHorarioSur.add(getPanelHorarioSurDerecha());
		}
		return panelHorarioSur;
	}
	private JPanel getPanelHorarioOeste() {
		if (panelHorarioOeste == null) {
			panelHorarioOeste = new JPanel();
			panelHorarioOeste.setBackground(DEFAULT_COLOR);
			panelHorarioOeste.setLayout(new BorderLayout(5, 5));
			panelHorarioOeste.add(getLblHorarioImagen(), BorderLayout.CENTER);
			panelHorarioOeste.add(getHorizontalGlue(), BorderLayout.SOUTH);
		}
		return panelHorarioOeste;
	}
	private JPanel getPanelHorarioSurIzquierda() {
		if (panelHorarioSurIzquierda == null) {
			panelHorarioSurIzquierda = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelHorarioSurIzquierda.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelHorarioSurIzquierda.setBackground(DEFAULT_COLOR);
			panelHorarioSurIzquierda.add(getBtnHorarioAtras());
		}
		return panelHorarioSurIzquierda;
	}
	private JPanel getPanelHorarioSurCentro() {
		if (panelHorarioSurCentro == null) {
			panelHorarioSurCentro = new JPanel();
			panelHorarioSurCentro.setBackground(DEFAULT_COLOR);
			panelHorarioSurCentro.add(getBtnHorarioVolverCartelera());
		}
		return panelHorarioSurCentro;
	}
	private JPanel getPanelHorarioSurDerecha() {
		if (panelHorarioSurDerecha == null) {
			panelHorarioSurDerecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelHorarioSurDerecha.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelHorarioSurDerecha.setBackground(DEFAULT_COLOR);
			panelHorarioSurDerecha.add(getBtnHorarioSiguiente());
		}
		return panelHorarioSurDerecha;
	}
	private JButton getBtnHorarioAtras() {
		if (btnHorarioAtras == null) {
			btnHorarioAtras = new JButton("Horario Atras");
			btnHorarioAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prepararPanelPelicula();
					lblHorarioImagen.setIcon(null);
					((CardLayout)contentPane.getLayout()).show(contentPane,"pelicula");
				}
			});
			btnHorarioAtras.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnHorarioAtras;
	}
	private JButton getBtnHorarioVolverCartelera() {
		if (btnHorarioVolverCartelera == null) {
			btnHorarioVolverCartelera = new JButton("Horario Volver Cartelera");
			btnHorarioVolverCartelera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblHorarioImagen.setIcon(null);
					((CardLayout)contentPane.getLayout()).show(contentPane,"cartelera");
				}
			});
			btnHorarioVolverCartelera.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnHorarioVolverCartelera;
	}
	private JButton getBtnHorarioSiguiente() {
		if (btnHorarioSiguiente == null) {
			btnHorarioSiguiente = new JButton("Horario Siguiente");
			btnHorarioSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = listaHoras.getSelectedIndex();
					if(indice != -1){
						gestor.setSalaActual(DateUtil.getFechaSinFormato(((TitledBorder)panelHorarioHoras.getBorder()).getTitle(), traduccion.getLocale()), listaHoras.getSelectedValue());
						((CardLayout)contentPane.getLayout()).show(contentPane,"sala");
						prepararPanelSala();
					}
				}
			});
			btnHorarioSiguiente.setEnabled(false);
			btnHorarioSiguiente.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnHorarioSiguiente;
	}
	private JLabel getLblHorarioImagen() {
		if (lblHorarioImagen == null) {
			lblHorarioImagen = new JLabel("");
		}
		return lblHorarioImagen;
	}
	private Component getHorizontalGlue() {
		if (horizontalGlue == null) {
			horizontalGlue = Box.createHorizontalGlue();
		}
		return horizontalGlue;
	}
	private JPanel getPanelHorarioJCalendar() {
		if (panelHorarioJCalendar == null) {
			panelHorarioJCalendar = new JPanel();
			panelHorarioJCalendar.setBackground(DEFAULT_COLOR);
			panelHorarioJCalendar.setLayout(new GridLayout(1, 1, 0, 0));
		}
		return panelHorarioJCalendar;
	}
	private JPanel getPanelSala() {
		if (panelSala == null) {
			panelSala = new JPanel();
			panelSala.setBackground(DEFAULT_COLOR);
			panelSala.setLayout(new BorderLayout(0, 0));
			panelSala.add(getPanelSalaNorte(), BorderLayout.NORTH);
			panelSala.add(getPanelSalaSur(), BorderLayout.SOUTH);
			panelSala.add(getPanelSalaEste(), BorderLayout.EAST);
			panelSala.add(getPanelSalaCentro(), BorderLayout.CENTER);
		}
		return panelSala;
	}
	private JPanel getPanelSalaNorte() {
		if (panelSalaNorte == null) {
			panelSalaNorte = new JPanel();
			panelSalaNorte.setBackground(DEFAULT_COLOR);
			panelSalaNorte.setLayout(new GridLayout(2, 0, 0, 0));
			panelSalaNorte.add(getLblSalaTitutlo());
			panelSalaNorte.add(getLblSalaSesion());
		}
		return panelSalaNorte;
	}
	private JPanel getPanelSalaSur() {
		if (panelSalaSur == null) {
			panelSalaSur = new JPanel();
			panelSalaSur.setBackground(DEFAULT_COLOR);
			panelSalaSur.setLayout(new GridLayout(0, 3, 0, 0));
			panelSalaSur.add(getPanelSalaSurIzquierda());
			panelSalaSur.add(getPanelSalaSurCentro());
			panelSalaSur.add(getPanelSalaSurDerecha());
		}
		return panelSalaSur;
	}
	private JPanel getPanelSalaSurDerecha() {
		if (panelSalaSurDerecha == null) {
			panelSalaSurDerecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelSalaSurDerecha.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelSalaSurDerecha.setBackground(DEFAULT_COLOR);
			panelSalaSurDerecha.add(getBtnSalaSiguiente());
		}
		return panelSalaSurDerecha;
	}
	private JPanel getPanelSalaSurCentro() {
		if (panelSalaSurCentro == null) {
			panelSalaSurCentro = new JPanel();
			panelSalaSurCentro.setBackground(DEFAULT_COLOR);
			panelSalaSurCentro.add(getBtnSalaVolverCartelera());
		}
		return panelSalaSurCentro;
	}
	private JPanel getPanelSalaSurIzquierda() {
		if (panelSalaSurIzquierda == null) {
			panelSalaSurIzquierda = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelSalaSurIzquierda.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelSalaSurIzquierda.setBackground(DEFAULT_COLOR);
			panelSalaSurIzquierda.add(getBtnSalaAtras());
		}
		return panelSalaSurIzquierda;
	}
	private JPanel getPanelSalaEste() {
		if (panelSalaEste == null) {
			panelSalaEste = new JPanel();
			panelSalaEste.setBackground(DEFAULT_COLOR);
			panelSalaEste.setLayout(new GridLayout(2, 0, 0, 0));
			panelSalaEste.add(getPanelSalaEsteLeyenda());
			panelSalaEste.add(getPanelSalaEsteAbajo());
		}
		return panelSalaEste;
	}
	private JPanel getPanelSalaEsteLeyenda() {
		if (panelSalaEsteLeyenda == null) {
			panelSalaEsteLeyenda = new JPanel();
			panelSalaEsteLeyenda.setBackground(DEFAULT_COLOR);
			panelSalaEsteLeyenda.setLayout(new GridLayout(3, 4, 0, 0));
			panelSalaEsteLeyenda.add(getLblLeyendaLibre());
			panelSalaEsteLeyenda.add(getLblLeyendaLibreImagen());
			panelSalaEsteLeyenda.add(getLblLeyendaOcupado());
			panelSalaEsteLeyenda.add(getLblLeyendaOcupadoImagen());
			panelSalaEsteLeyenda.add(getLblLeyendaNormal());
			panelSalaEsteLeyenda.add(getLblLeyendaNormalImagen());
			panelSalaEsteLeyenda.add(getLblLeyendaJubilado());
			panelSalaEsteLeyenda.add(getLblLeyendaJubiladoImagen());
			panelSalaEsteLeyenda.add(getLblLeyendaCumple());
			panelSalaEsteLeyenda.add(getLblLeyendaCumpleImagen());
			panelSalaEsteLeyenda.add(getTxtrLeyendaJubiCumple());
			panelSalaEsteLeyenda.add(getLblLeyendaJubicumpleImagen());
		}
		return panelSalaEsteLeyenda;
	}
	private JPanel getPanelSalaEsteAbajo() {
		if (panelSalaEsteAbajo == null) {
			panelSalaEsteAbajo = new JPanel();
			panelSalaEsteAbajo.setBackground(DEFAULT_COLOR);
			panelSalaEsteAbajo.setLayout(new GridLayout(0, 1, 0, 0));
			panelSalaEsteAbajo.add(getPanelSalaTipoEntrada());
			panelSalaEsteAbajo.add(getPanelSalaPedido());
		}
		return panelSalaEsteAbajo;
	}
	private JPanel getPanelSalaTipoEntrada() {
		if (panelSalaTipoEntrada == null) {
			panelSalaTipoEntrada = new JPanel();
			panelSalaTipoEntrada.setBackground(DEFAULT_COLOR);
			panelSalaTipoEntrada.setLayout(new BorderLayout(0, 0));
			panelSalaTipoEntrada.add(getPanelSalaTipoEntradaCheck(), BorderLayout.SOUTH);
			panelSalaTipoEntrada.add(getScrollPaneTipoEntrada(), BorderLayout.CENTER);
		}
		return panelSalaTipoEntrada;
	}
	private JPanel getPanelSalaPedido() {
		if (panelSalaPedido == null) {
			panelSalaPedido = new JPanel();
			panelSalaPedido.setBackground(DEFAULT_COLOR);
			panelSalaPedido.setLayout(new BorderLayout(0, 0));
			panelSalaPedido.add(getPanelSalaPedidoTotal(), BorderLayout.SOUTH);
			panelSalaPedido.add(getScrollPanelSalaPedido(), BorderLayout.CENTER);
		}
		return panelSalaPedido;
	}
	private JButton getBtnSalaAtras() {
		if (btnSalaAtras == null) {
			btnSalaAtras = new JButton("Sala Atras");
			btnSalaAtras.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnSalaAtras;
	}
	private JButton getBtnSalaVolverCartelera() {
		if (btnSalaVolverCartelera == null) {
			btnSalaVolverCartelera = new JButton("Sala Volver Cartelera");
			btnSalaVolverCartelera.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnSalaVolverCartelera;
	}
	private JButton getBtnSalaSiguiente() {
		if (btnSalaSiguiente == null) {
			btnSalaSiguiente = new JButton("Sala Siguiente");
			btnSalaSiguiente.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnSalaSiguiente;
	}
	private JLabel getLblSalaTitutlo() {
		if (lblSalaTitulo == null) {
			lblSalaTitulo = new JLabel("Sala Titutlo");
			lblSalaTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TITTLE_SIZE));
		}
		return lblSalaTitulo;
	}
	private JLabel getLblSalaSesion() {
		if (lblSalaSesion == null) {
			lblSalaSesion = new JLabel("Sala Sesion");
			lblSalaSesion.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_TITTLE_SIZE/2));
		}
		return lblSalaSesion;
	}
	private JLabel getLblLeyendaLibre() {
		if (lblLeyendaLibre == null) {
			lblLeyendaLibre = new JLabel("Leyenda Libre");
		}
		return lblLeyendaLibre;
	}
	private JLabel getLblLeyendaLibreImagen() {
		if (lblLeyendaLibreImagen == null) {
			lblLeyendaLibreImagen = new JLabel("");
		}
		return lblLeyendaLibreImagen;
	}
	private JLabel getLblLeyendaOcupado() {
		if (lblLeyendaOcupado == null) {
			lblLeyendaOcupado = new JLabel("Leyenda Ocupado");
		}
		return lblLeyendaOcupado;
	}
	private JLabel getLblLeyendaOcupadoImagen() {
		if (lblLeyendaOcupadoImagen == null) {
			lblLeyendaOcupadoImagen = new JLabel("");
		}
		return lblLeyendaOcupadoImagen;
	}
	private JLabel getLblLeyendaNormal() {
		if (lblLeyendaNormal == null) {
			lblLeyendaNormal = new JLabel("Leyenda Normal");
		}
		return lblLeyendaNormal;
	}
	private JLabel getLblLeyendaNormalImagen() {
		if (lblLeyendaNormalImagen == null) {
			lblLeyendaNormalImagen = new JLabel("");
		}
		return lblLeyendaNormalImagen;
	}
	private JLabel getLblLeyendaJubilado() {
		if (lblLeyendaJubilado == null) {
			lblLeyendaJubilado = new JLabel("Leyenda Jubilado");
		}
		return lblLeyendaJubilado;
	}
	private JLabel getLblLeyendaJubiladoImagen() {
		if (lblLeyendaJubiladoImagen == null) {
			lblLeyendaJubiladoImagen = new JLabel("");
		}
		return lblLeyendaJubiladoImagen;
	}
	private JLabel getLblLeyendaCumple() {
		if (lblLeyendaCumple == null) {
			lblLeyendaCumple = new JLabel("Leyenda Cumple");
		}
		return lblLeyendaCumple;
	}
	private JLabel getLblLeyendaCumpleImagen() {
		if (lblLeyendaCumpleImagen == null) {
			lblLeyendaCumpleImagen = new JLabel("");

		}
		return lblLeyendaCumpleImagen;
	}
	private JLabel getLblLeyendaJubicumpleImagen() {
		if (lblLeyendaJubicumpleImagen == null) {
			lblLeyendaJubicumpleImagen = new JLabel("");

		}
		return lblLeyendaJubicumpleImagen;
	}
	private JPanel getPanelSalaTipoEntradaCheck() {
		if (panelSalaTipoEntradaCheck == null) {
			panelSalaTipoEntradaCheck = new JPanel();
			panelSalaTipoEntradaCheck.setBackground(DEFAULT_COLOR);
			panelSalaTipoEntradaCheck.add(getChckbxJubilado());
			panelSalaTipoEntradaCheck.add(getChckbxCumple());
		}
		return panelSalaTipoEntradaCheck;
	}
	private JCheckBox getChckbxJubilado() {
		if (chckbxJubilado == null) {
			chckbxJubilado = new JCheckBox("Jubilado");
		}
		return chckbxJubilado;
	}
	private JCheckBox getChckbxCumple() {
		if (chckbxCumple == null) {
			chckbxCumple = new JCheckBox("Cumple");
		}
		return chckbxCumple;
	}
	private JScrollPane getScrollPaneTipoEntrada() {
		if (scrollPaneTipoEntrada == null) {
			scrollPaneTipoEntrada = new JScrollPane();
			scrollPaneTipoEntrada.setBackground(DEFAULT_COLOR);
			scrollPaneTipoEntrada.setViewportView(getTxtrTipoEntrada());
		}
		return scrollPaneTipoEntrada;
	}
	private JTextArea getTxtrTipoEntrada() {
		if (txtrTipoEntrada == null) {
			txtrTipoEntrada = new JTextArea();
			txtrTipoEntrada.setWrapStyleWord(true);
			txtrTipoEntrada.setLineWrap(true);
			txtrTipoEntrada.setEditable(false);
			txtrTipoEntrada.setText("Tipo Entrada");
		}
		return txtrTipoEntrada;
	}
	private JPanel getPanelSalaPedidoTotal() {
		if (panelSalaPedidoTotal == null) {
			panelSalaPedidoTotal = new JPanel();
			panelSalaPedidoTotal.setBackground(DEFAULT_COLOR);
			panelSalaPedidoTotal.add(getLblEntradasTotales());
			panelSalaPedidoTotal.add(getTxtEntradasTotales());
		}
		return panelSalaPedidoTotal;
	}
	private JScrollPane getScrollPanelSalaPedido() {
		if (scrollPanelSalaPedido == null) {
			scrollPanelSalaPedido = new JScrollPane();
			scrollPanelSalaPedido.setBackground(DEFAULT_COLOR);
			scrollPanelSalaPedido.setViewportView(getTxtrSalaPedido());
		}
		return scrollPanelSalaPedido;
	}
	private JTextArea getTxtrSalaPedido() {
		if (txtrSalaPedido == null) {
			txtrSalaPedido = new JTextArea();
			txtrSalaPedido.setLineWrap(true);
			txtrSalaPedido.setEditable(false);
			txtrSalaPedido.setWrapStyleWord(true);
			txtrSalaPedido.setText("Sala Pedido");
		}
		return txtrSalaPedido;
	}
	private JLabel getLblEntradasTotales() {
		if (lblEntradasTotales == null) {
			lblEntradasTotales = new JLabel("Entradas Totales");
		}
		return lblEntradasTotales;
	}
	private JTextField getTxtEntradasTotales() {
		if (txtEntradasTotales == null) {
			txtEntradasTotales = new JTextField();
			txtEntradasTotales.setEditable(false);
			txtEntradasTotales.setText("Entradas totales");
			txtEntradasTotales.setColumns(10);
		}
		return txtEntradasTotales;
	}
	private void prepararPanelSala(){
		lblSalaTitulo.setText(gestor.getPeliculaActual().getTitulo());
		lblSalaSesion.setText(gestor.getSalaActual().getFecha()+" - "+gestor.getSalaActual().getHora());
		ImageUtil.adaptarImagen(lblLeyendaLibreImagen, "/modulo/img/silla.png");
		ImageUtil.adaptarImagen(lblLeyendaOcupadoImagen, "/modulo/img/sillaO.png");
		ImageUtil.adaptarImagen(lblLeyendaNormalImagen, "/modulo/img/sillaEN.png");
		ImageUtil.adaptarImagen(lblLeyendaJubiladoImagen, "/modulo/img/sillaEJ.png");
		ImageUtil.adaptarImagen(lblLeyendaCumpleImagen, "/modulo/img/sillaEC.png");
		ImageUtil.adaptarImagen(lblLeyendaJubicumpleImagen, "/modulo/img/sillaEJC.png");
		colocarButacas();
	}
	private JTextArea getTxtrLeyendaJubiCumple() {
		if (txtrLeyendaJubiCumple == null) {
			txtrLeyendaJubiCumple = new JTextArea();
			txtrLeyendaJubiCumple.setEditable(false);
			txtrLeyendaJubiCumple.setOpaque(false);
			txtrLeyendaJubiCumple.setLineWrap(true);
			txtrLeyendaJubiCumple.setWrapStyleWord(true);
			txtrLeyendaJubiCumple.setText("");
		}
		return txtrLeyendaJubiCumple;
	}
	private JPanel getPanelSalaCentro() {
		if (panelSalaCentro == null) {
			panelSalaCentro = new JPanel();
			panelSalaCentro.setBackground(DEFAULT_COLOR);
			panelSalaCentro.setLayout(new GridLayout(4, 11, 0, 0));
			panelSalaCentro.add(getBtnButaca());
			panelSalaCentro.add(getBtnButaca_1());
			panelSalaCentro.add(getBtnButaca_2());
			panelSalaCentro.add(getBtnButaca_3());
			panelSalaCentro.add(getBtnButaca_4());
			panelSalaCentro.add(getHorizontalGluePasillo3());
			panelSalaCentro.add(getBtnButaca_5());
			panelSalaCentro.add(getBtnButaca_6());
			panelSalaCentro.add(getBtnButaca_7());
			panelSalaCentro.add(getBtnButaca_8());
			panelSalaCentro.add(getBtnButaca_9());
			panelSalaCentro.add(getHorizontalGlueHueco2I());
			panelSalaCentro.add(getBtnButaca_10());
			panelSalaCentro.add(getBtnButaca_11());
			panelSalaCentro.add(getBtnButuca());
			panelSalaCentro.add(getBtnButaca_12());
			panelSalaCentro.add(getHorizontalGluePasillo2());
			panelSalaCentro.add(getBtnButaca_13());
			panelSalaCentro.add(getBtnButaca_14());
			panelSalaCentro.add(getBtnButaca_15());
			panelSalaCentro.add(getBtnButaca_16());
			panelSalaCentro.add(getHorizontalGlueHueco2D());
			panelSalaCentro.add(getHorizontalGlueHueco1I());
			panelSalaCentro.add(getBtnButaca_18());
			panelSalaCentro.add(getBtnButaca_19());
			panelSalaCentro.add(getBtnButaca_20());
			panelSalaCentro.add(getBtnButaca_21());
			panelSalaCentro.add(getHorizontalGluePasillo1());
			panelSalaCentro.add(getBtnButaca_22());
			panelSalaCentro.add(getBtnButaca_23());
			panelSalaCentro.add(getBtnButaca_24());
			panelSalaCentro.add(getBtnButaca_25());
			panelSalaCentro.add(getHorizontalGlueHueco1D());
			panelSalaCentro.add(getHorizontalGlueHueco0I2());
			panelSalaCentro.add(getHorizontalGlueHueco0I1());
			panelSalaCentro.add(getHorizontalGlueHueco0I0());
			panelSalaCentro.add(getBtnButaca_17());
			panelSalaCentro.add(getBtnButaca_26());
			panelSalaCentro.add(getHorizontalGluePasillo0());
			panelSalaCentro.add(getBtnButaca_27());
			panelSalaCentro.add(getBtnButaca_28());
			panelSalaCentro.add(getHorizontalGlueHueco0D0());
			panelSalaCentro.add(getHorizontalGlueHueco0D1());
			panelSalaCentro.add(getHorizontalGlueHueco0D2());
		}
		return panelSalaCentro;
	}
	private JButton getBtnButaca() {
		if (btnButaca == null) {
			btnButaca = new JButton("butaca,3,0");
		}
		return btnButaca;
	}
	private JButton getBtnButaca_1() {
		if (btnButaca_1 == null) {
			btnButaca_1 = new JButton("butaca,3,1");
		}
		return btnButaca_1;
	}
	private JButton getBtnButaca_2() {
		if (btnButaca_2 == null) {
			btnButaca_2 = new JButton("butaca,3,2");
		}
		return btnButaca_2;
	}
	private JButton getBtnButaca_3() {
		if (btnButaca_3 == null) {
			btnButaca_3 = new JButton("butaca,3,3");
		}
		return btnButaca_3;
	}
	private JButton getBtnButaca_4() {
		if (btnButaca_4 == null) {
			btnButaca_4 = new JButton("butaca,3,4");
		}
		return btnButaca_4;
	}
	private Component getHorizontalGluePasillo3() {
		if (horizontalGluePasillo3 == null) {
			horizontalGluePasillo3 = Box.createHorizontalGlue();
		}
		return horizontalGluePasillo3;
	}
	private JButton getBtnButaca_5() {
		if (btnButaca_5 == null) {
			btnButaca_5 = new JButton("butaca,3,5");
		}
		return btnButaca_5;
	}
	private JButton getBtnButaca_6() {
		if (btnButaca_6 == null) {
			btnButaca_6 = new JButton("butaca,3,6");
		}
		return btnButaca_6;
	}
	private JButton getBtnButaca_7() {
		if (btnButaca_7 == null) {
			btnButaca_7 = new JButton("butaca,3,7");
		}
		return btnButaca_7;
	}
	private JButton getBtnButaca_8() {
		if (btnButaca_8 == null) {
			btnButaca_8 = new JButton("butaca,3,8");
		}
		return btnButaca_8;
	}
	private JButton getBtnButaca_9() {
		if (btnButaca_9 == null) {
			btnButaca_9 = new JButton("butaca,3,9");
		}
		return btnButaca_9;
	}
	private Component getHorizontalGlueHueco2I() {
		if (horizontalGlueHueco2I == null) {
			horizontalGlueHueco2I = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco2I;
	}
	private JButton getBtnButaca_10() {
		if (btnButaca_10 == null) {
			btnButaca_10 = new JButton("butaca,2,1");
		}
		return btnButaca_10;
	}
	private JButton getBtnButaca_11() {
		if (btnButaca_11 == null) {
			btnButaca_11 = new JButton("butaca,2,2");
		}
		return btnButaca_11;
	}
	private JButton getBtnButuca() {
		if (btnButuca == null) {
			btnButuca = new JButton("butuca,2,3");
		}
		return btnButuca;
	}
	private JButton getBtnButaca_12() {
		if (btnButaca_12 == null) {
			btnButaca_12 = new JButton("butaca,2,4");
		}
		return btnButaca_12;
	}
	private Component getHorizontalGluePasillo2() {
		if (horizontalGluePasillo2 == null) {
			horizontalGluePasillo2 = Box.createHorizontalGlue();
		}
		return horizontalGluePasillo2;
	}
	private JButton getBtnButaca_13() {
		if (btnButaca_13 == null) {
			btnButaca_13 = new JButton("butaca,2,5");
		}
		return btnButaca_13;
	}
	private JButton getBtnButaca_14() {
		if (btnButaca_14 == null) {
			btnButaca_14 = new JButton("butaca,2,6");
		}
		return btnButaca_14;
	}
	private JButton getBtnButaca_15() {
		if (btnButaca_15 == null) {
			btnButaca_15 = new JButton("butaca,2,7");
		}
		return btnButaca_15;
	}
	private JButton getBtnButaca_16() {
		if (btnButaca_16 == null) {
			btnButaca_16 = new JButton("butaca,2,8");
		}
		return btnButaca_16;
	}
	private Component getHorizontalGlueHueco2D() {
		if (horizontalGlueHueco2D == null) {
			horizontalGlueHueco2D = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco2D;
	}
	private Component getHorizontalGlueHueco1I() {
		if (horizontalGlueHueco1I == null) {
			horizontalGlueHueco1I = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco1I;
	}
	private JButton getBtnButaca_18() {
		if (btnButaca_18 == null) {
			btnButaca_18 = new JButton("butaca,1,1");
		}
		return btnButaca_18;
	}
	private JButton getBtnButaca_19() {
		if (btnButaca_19 == null) {
			btnButaca_19 = new JButton("butaca,1,2");
		}
		return btnButaca_19;
	}
	private JButton getBtnButaca_20() {
		if (btnButaca_20 == null) {
			btnButaca_20 = new JButton("butaca,1,3");
		}
		return btnButaca_20;
	}
	private JButton getBtnButaca_21() {
		if (btnButaca_21 == null) {
			btnButaca_21 = new JButton("butaca,1,4");
		}
		return btnButaca_21;
	}
	private Component getHorizontalGluePasillo1() {
		if (horizontalGluePasillo1 == null) {
			horizontalGluePasillo1 = Box.createHorizontalGlue();
		}
		return horizontalGluePasillo1;
	}
	private JButton getBtnButaca_22() {
		if (btnButaca_22 == null) {
			btnButaca_22 = new JButton("butaca,1,5");
		}
		return btnButaca_22;
	}
	private JButton getBtnButaca_23() {
		if (btnButaca_23 == null) {
			btnButaca_23 = new JButton("butaca,1,6");
		}
		return btnButaca_23;
	}
	private JButton getBtnButaca_24() {
		if (btnButaca_24 == null) {
			btnButaca_24 = new JButton("butaca,1,7");
		}
		return btnButaca_24;
	}
	private JButton getBtnButaca_25() {
		if (btnButaca_25 == null) {
			btnButaca_25 = new JButton("butaca,1,8");
		}
		return btnButaca_25;
	}
	private Component getHorizontalGlueHueco1D() {
		if (horizontalGlueHueco1D == null) {
			horizontalGlueHueco1D = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco1D;
	}
	private Component getHorizontalGlueHueco0I2() {
		if (horizontalGlueHueco0I2 == null) {
			horizontalGlueHueco0I2 = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco0I2;
	}
	private Component getHorizontalGlueHueco0I1() {
		if (horizontalGlueHueco0I1 == null) {
			horizontalGlueHueco0I1 = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco0I1;
	}
	private Component getHorizontalGlueHueco0I0() {
		if (horizontalGlueHueco0I0 == null) {
			horizontalGlueHueco0I0 = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco0I0;
	}
	private JButton getBtnButaca_17() {
		if (btnButaca_17 == null) {
			btnButaca_17 = new JButton("butaca,0,3");
		}
		return btnButaca_17;
	}
	private JButton getBtnButaca_26() {
		if (btnButaca_26 == null) {
			btnButaca_26 = new JButton("butaca,0,4");
		}
		return btnButaca_26;
	}
	private Component getHorizontalGluePasillo0() {
		if (horizontalGluePasillo0 == null) {
			horizontalGluePasillo0 = Box.createHorizontalGlue();
		}
		return horizontalGluePasillo0;
	}
	private JButton getBtnButaca_27() {
		if (btnButaca_27 == null) {
			btnButaca_27 = new JButton("butaca,0,5");
		}
		return btnButaca_27;
	}
	private JButton getBtnButaca_28() {
		if (btnButaca_28 == null) {
			btnButaca_28 = new JButton("butaca,0,6");
		}
		return btnButaca_28;
	}
	private Component getHorizontalGlueHueco0D0() {
		if (horizontalGlueHueco0D0 == null) {
			horizontalGlueHueco0D0 = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco0D0;
	}
	private Component getHorizontalGlueHueco0D1() {
		if (horizontalGlueHueco0D1 == null) {
			horizontalGlueHueco0D1 = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco0D1;
	}
	private Component getHorizontalGlueHueco0D2() {
		if (horizontalGlueHueco0D2 == null) {
			horizontalGlueHueco0D2 = Box.createHorizontalGlue();
		}
		return horizontalGlueHueco0D2;
	}
	private void colocarButacas(){
		for(int i = 0; i < panelSalaCentro.getComponentCount(); i++){
			if(panelSalaCentro.getComponents()[i] instanceof JButton){
				JButton boton = (JButton)panelSalaCentro.getComponents()[i];
				if(!boton.getText().isEmpty()){
					boton.setActionCommand(boton.getText().split(",")[1]+","+boton.getText().split(",")[2]);
					boton.setText("");
				}
				boton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(e.getActionCommand());
					}
				});
			}
		}
	}
	private int getTipoEntrada(){
		if(chckbxCumple.isSelected() && !chckbxJubilado.isSelected()){
			chckbxCumple.setSelected(false);
			return Entrada.PACK_CUMPLE;
		}
		else if(!this.chckbxCumple.isSelected() && chckbxJubilado.isSelected()){
			chckbxJubilado.setSelected(false);
			return Entrada.JUBILADO;
		}
		else if(chckbxCumple.isSelected() && chckbxJubilado.isSelected()){
			chckbxCumple.setSelected(false);
			chckbxJubilado.setSelected(false);
			return Entrada.JUBILADO_Y_PACK_CUMPLE;
		}
		else{
			return Entrada.NORMAL;
		}
		}
}
