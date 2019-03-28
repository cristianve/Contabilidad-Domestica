package com.codo.vista.movimientos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorMovimientos;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.componentes.ModeloTablaMovimientos;
import com.codo.vista.interfaces.movimientos.InterfazMovimientos;
import com.toedter.calendar.JDateChooser;

public class VentanaMovimientos extends JDialog implements InterfazMovimientos {

	private static final long serialVersionUID = 1L;
	private static final int SET_LOCATION_X = 380;
	private static final int SET_LOCATION_Y = 150;
	private static final int ANCHURA_MINIMA_VENTANA = 700;
	private static final int ALTURA_MINIMA_VENTANA = 450;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelCentral;
	private JPanel panelComponentes;
	private JPanel panelFunciones;
	private JPanel buttonPane;
	private JTable tablaMovimientos;
	private JScrollPane panelDesplazamiento;
	private ModeloTablaMovimientos mtm;
	private JLabel lblFiltros;
	private JLabel lblCuentas;
	private JLabel lblTipos;
	private JLabel lblEtiquetas;
	private JLabel lblFechaDesde;
	private JLabel lblFechaHasta;
	private JComboBox<Cuentas> cajaCuentas;
	private JComboBox<Tipos> cajaTipos;
	private JComboBox<Etiquetas> cajaEtiquetas;
	private JDateChooser fechaDesde;
	private JDateChooser fechaHasta;
	private JButton btnConsultar;
	private JButton btnRevertir;
	private JButton btnSalir;
	private JPanel paneLblCampos;
	private JPanel paneCampos;
	private JPanel paneLblFechas;
	private JPanel paneFechas;

	public VentanaMovimientos(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiquetasDeIngresos,
			List<Tipos> listaDeTipos) {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Movimientos");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout(0, 0));

		// CONFIGURACION DE CONTENTPANEL
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		// CONFIGURACIÓN DE PANELCENTRAL
		panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout(0, 0));
		contentPanel.add(panelCentral, BorderLayout.CENTER);

		// CONSTRUCCION DE TABLA
		tablaMovimientos = new JTable();
		tablaMovimientos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaMovimientos.setFillsViewportHeight(false);
		tablaMovimientos.setRowHeight(30);
		Font f = new Font("Time New Roman", Font.PLAIN, 12);
		tablaMovimientos.setFont(f);

		panelDesplazamiento = new JScrollPane(tablaMovimientos);
		panelDesplazamiento.setBounds(15, 16, 464, 167);
		panelDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelCentral.add(panelDesplazamiento, BorderLayout.CENTER);
		
		{
			// CONFIGURACIÓN DE PANELCOMPONENTES
			panelComponentes = new JPanel();
			panelComponentes.setPreferredSize(new Dimension(10, 150));
			panelCentral.add(panelComponentes, BorderLayout.SOUTH);
			panelComponentes.setLayout(null);
			
			paneLblCampos = new JPanel();
			paneLblCampos.setBounds(10, 32, 81, 94);
			panelComponentes.add(paneLblCampos);
			paneLblCampos.setLayout(new GridLayout(0, 1, 0, 5));
			
			paneCampos = new JPanel();
			paneCampos.setBounds(101, 32, 128, 94);
			panelComponentes.add(paneCampos);
			paneCampos.setLayout(new GridLayout(0, 1, 0, 5));
			
			paneLblFechas = new JPanel();
			paneLblFechas.setBounds(257, 32, 81, 53);
			panelComponentes.add(paneLblFechas);
			paneLblFechas.setLayout(new GridLayout(0, 1, 0, 5));
			
			paneFechas = new JPanel();
			paneFechas.setBounds(348, 32, 104, 53);
			panelComponentes.add(paneFechas);
			paneFechas.setLayout(new GridLayout(0, 1, 0, 5));
		}
		{
			// CONFIGURACIÓN DE PANELFUNCIONES
			panelFunciones = new JPanel();
			panelFunciones.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			contentPanel.add(panelFunciones, BorderLayout.SOUTH);

		}

		// LABELS
		lblFiltros = new JLabel("Filtros:");
		lblFiltros.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblFiltros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFiltros.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFiltros.setBounds(10, 11, 81, 14);
		panelComponentes.add(lblFiltros);
		
		lblCuentas = new JLabel("Cuentas:");
		lblCuentas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuentas.setHorizontalTextPosition(SwingConstants.RIGHT);
		paneLblCampos.add(lblCuentas);

		lblTipos = new JLabel("Tipos:");
		lblTipos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipos.setHorizontalTextPosition(SwingConstants.RIGHT);
		paneLblCampos.add(lblTipos);
		
		lblEtiquetas = new JLabel("Etiquetas:");
		lblEtiquetas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEtiquetas.setHorizontalTextPosition(SwingConstants.RIGHT);
		paneLblCampos.add(lblEtiquetas);

		lblFechaDesde = new JLabel("Fecha Desde:");
		lblFechaDesde.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblFechaDesde.setHorizontalAlignment(SwingConstants.RIGHT);
		paneLblFechas.add(lblFechaDesde);

		lblFechaHasta = new JLabel("Fecha Hasta:");
		lblFechaHasta.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblFechaHasta.setHorizontalAlignment(SwingConstants.RIGHT);
		paneLblFechas.add(lblFechaHasta);

		// COMBOBOXS
		cajaCuentas = new JComboBox<Cuentas>();
		for (Cuentas cuenta : listaDeCuentas) {
			cajaCuentas.addItem(cuenta);
		}
		paneCampos.add(cajaCuentas);

		cajaTipos = new JComboBox<Tipos>();
		cajaTipos.setActionCommand(ACCION_CAJA_TIPO_MOVIMIENTOS);
		for (Tipos tipo : listaDeTipos) {
			cajaTipos.addItem(tipo);
		}
		paneCampos.add(cajaTipos);

		cajaEtiquetas = new JComboBox<Etiquetas>();
		for (Etiquetas etiqueta : listaDeEtiquetasDeIngresos) {
			cajaEtiquetas.addItem(etiqueta);
		}
		paneCampos.add(cajaEtiquetas);

		// CALENDARIOS
		fechaDesde = new JDateChooser();
		paneFechas.add(fechaDesde);

		fechaHasta = new JDateChooser();
		paneFechas.add(fechaHasta);

		// BOTONES
		btnConsultar = new JButton("Consultar");
		btnConsultar.setActionCommand(BOTON_CONSULTAR_MOVIMIENTOS);
		panelFunciones.add(btnConsultar);
		

		btnRevertir = new JButton("Revertir");
		btnRevertir.setActionCommand(BOTON_REVERTIR_MOVIMIENTO);
		panelFunciones.add(btnRevertir);

		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSalir = new JButton("Salir");
				btnSalir.setActionCommand(BOTON_SALIR_MOVIMIENTOS);
				buttonPane.add(btnSalir);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorMovimientos control) {
		btnConsultar.addActionListener(control);
		btnRevertir.addActionListener(control);
		btnSalir.addActionListener(control);
		cajaTipos.addActionListener(control);
	}

	@Override
	public Movimientos obtenerMovimientoSeleccionado() {
		return mtm.obtenerObjeto(tablaMovimientos.getSelectedRow());
	}

	@Override
	public void asignarDatosTablaMovimientos(List<Movimientos> listaDeMovimientos) {
		mtm = new ModeloTablaMovimientos();
		mtm.asignarListaDeCuentas(listaDeMovimientos);
		tablaMovimientos.setModel(mtm);
	}

	@Override
	public String obtenerFiltro() {

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		String fechaInicio = formatoFecha.format(fechaDesde.getDate());
		String fechaFin = formatoFecha.format(fechaHasta.getDate());
		String sentenciaSQL = "SELECT s FROM Movimientos s where  ";
		sentenciaSQL = sentenciaSQL + "(idCuentaOrigen=" + ((Cuentas) cajaCuentas.getSelectedItem()).getIdCuenta()
				+ " OR idCuentaDestino=" + ((Cuentas) cajaCuentas.getSelectedItem()).getIdCuenta() + ")";
		sentenciaSQL = sentenciaSQL + " AND idTipo=" + ((Tipos) cajaTipos.getSelectedItem()).getIdTipo();
		sentenciaSQL = sentenciaSQL + " AND idEtiqueta="
				+ ((Etiquetas) cajaEtiquetas.getSelectedItem()).getIdEtiqueta();
		sentenciaSQL = sentenciaSQL + " AND fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";

		return sentenciaSQL;
	}

	@Override
	public void refrescarCajaEtiquetas(List<Etiquetas> lista) {
		cajaEtiquetas.removeAllItems();
		for (Etiquetas etiqueta : lista) {
			cajaEtiquetas.addItem(etiqueta);
		}
	}

	@Override
	public String itemSeleccionadoCajaTipo() {
		return this.cajaTipos.getSelectedItem().toString();
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}

	@Override
	public boolean comprovarFechas() {
		if(fechaDesde.getDate().after(fechaHasta.getDate())){
			return false;
		}
		return true;
	}

	@Override
	public boolean comprovarFechaVacia() {
		if(fechaDesde.getDate()==null || fechaHasta.getDate()==null ){
			return false;
		}
		return true;
	}
}
