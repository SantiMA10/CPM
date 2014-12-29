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
import java.net.URI;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.toedter.calendar.JDayChooser;
import java.awt.Component;
import javax.swing.Box;


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
	private JLabel lblHorarioFechaSeleccionada;
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
		try {
			String fechaMinima = gestor.getPeliculaActual().getFechas()[0];
			String fechaMaxima = gestor.getPeliculaActual().getFechas()[gestor.getPeliculaActual().getFechas().length-1];
			ImageUtil.adaptarImagen(lblHorarioImagen, gestor.getPeliculaActual().getRutaImagen());
			final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/M/yyyy");
			final DateFormat formatoFecha2 = DateFormat.getDateInstance(DateFormat.LONG, traduccion.getLocale());
			calendar = new JCalendar(formatoFecha.parse(fechaMinima));
			panelHorarioCentro.remove(getPanelHorarioHoras());
			if(panelHorarioCentro.getComponentCount() == 1){
				panelHorarioCentro.remove(0);
			}
			panelHorarioCentro.add(calendar);
			panelHorarioCentro.add(getPanelHorarioHoras());
			lblHorarioFechaSeleccionada.setText(formatoFecha2.format(formatoFecha.parse(fechaMinima)));
			modeloListaHoras.clear();
			for(int i = 0; i < gestor.getPeliculaActual().getHoras().length; i++){
				modeloListaHoras.addElement(gestor.getPeliculaActual().getHoras()[i]);
			}
			calendar.setSelectableDateRange(formatoFecha.parse(fechaMinima), formatoFecha.parse(fechaMaxima));
			calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent e) {  
					calendar.getDayChooser().getDayPanel().getComponentAt(calendar.getDayChooser().getDayPanel().getLocation()).setForeground(DEFAULT_COLOR);
					String fecha = calendar.getDayChooser().getDay()+"/"+calendar.getMonthChooser().getMonth()+"/"+
							calendar.getYearChooser().getYear();
					try {
						lblHorarioFechaSeleccionada.setText(formatoFecha2.format(formatoFecha.parse(fecha)));
						modeloListaHoras.clear();
						for(int i = 0; i < gestor.getPeliculaActual().getHoras().length; i++){
							modeloListaHoras.addElement(gestor.getPeliculaActual().getHoras()[i]);
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	private JPanel getPanelHorarioCentro() {
		if (panelHorarioCentro == null) {
			panelHorarioCentro = new JPanel();
			panelHorarioCentro.setBackground(DEFAULT_COLOR);
			panelHorarioCentro.setLayout(new GridLayout(0, 2, 0, 5));
			panelHorarioCentro.add(getPanelHorarioHoras());

		}
		return panelHorarioCentro;
	}
	private JPanel getPanelHorarioHoras() {
		if (panelHorarioHoras == null) {
			panelHorarioHoras = new JPanel();
			panelHorarioHoras.setBackground(DEFAULT_COLOR);
			panelHorarioHoras.setLayout(new BorderLayout(0, 0));
			panelHorarioHoras.add(getLblHorarioFechaSeleccionada(), BorderLayout.NORTH);
			panelHorarioHoras.add(getScrollPaneHoras(), BorderLayout.CENTER);
		}
		return panelHorarioHoras;
	}
	private JLabel getLblHorarioFechaSeleccionada() {
		if (lblHorarioFechaSeleccionada == null) {
			lblHorarioFechaSeleccionada = new JLabel();
		}
		return lblHorarioFechaSeleccionada;
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
			btnHorarioVolverCartelera.setFont(new Font("Lucida Grande", Font.PLAIN, DEFAULT_BUTTON_SIZE));
		}
		return btnHorarioVolverCartelera;
	}
	private JButton getBtnHorarioSiguiente() {
		if (btnHorarioSiguiente == null) {
			btnHorarioSiguiente = new JButton("Horario Siguiente");
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
}
