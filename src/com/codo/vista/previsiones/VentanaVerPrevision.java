package com.codo.vista.previsiones;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrevisiones;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Previsiones;
import com.codo.vista.componentes.ModeloTablaPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazVentanaVerPrevision;
import com.toedter.calendar.JDateChooser;

public class VentanaVerPrevision extends JDialog implements InterfazVentanaVerPrevision {

	private static final long serialVersionUID = 1L;
	private static final int ANCHURA_MINIMA_VENTANA = 700;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JPanel panelFunciones;
	private ModeloTablaPrevisiones mtp;
	private JTable tablaVerPrevisiones;
	private JScrollPane panelDesplazamiento;
	private JButton btnVerPrevision;
	private JButton btnSalir;
	private JPanel panelCentral;
	private JPanel panelComponentes;
	private JPanel panelLabels;
	private JLabel lblCuenta;
	private JComboBox<Cuentas> cajaCuentas;
	private JPanel panelCampos;
	private JLabel lblFecha;
	private JDateChooser campoFecha;
	private JTextPane panelTexto;

	public VentanaVerPrevision(List<Cuentas> listaDeCuentas) {
		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Previsiones - Ver Previsión");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout());

		// CONFIGURACIÓN DE CONTENTPANEL
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		panelCentral = new JPanel();
		contentPanel.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));

		panelComponentes = new JPanel();
		FlowLayout fl_panelComponentes = (FlowLayout) panelComponentes.getLayout();
		fl_panelComponentes.setHgap(10);
		fl_panelComponentes.setAlignment(FlowLayout.LEFT);
		panelCentral.add(panelComponentes, BorderLayout.SOUTH);

		panelLabels = new JPanel();
		panelLabels.setPreferredSize(new Dimension(50, 50));
		panelComponentes.add(panelLabels);
		panelLabels.setLayout(new GridLayout(2, 2, 0, 5));

		lblCuenta = new JLabel("Cuenta:");
		panelLabels.add(lblCuenta);

		lblFecha = new JLabel("Fecha:");
		panelLabels.add(lblFecha);

		panelCampos = new JPanel();
		panelCampos.setPreferredSize(new Dimension(100, 50));
		panelComponentes.add(panelCampos);
		panelCampos.setLayout(new GridLayout(2, 2, 0, 5));

		cajaCuentas = new JComboBox<Cuentas>();
		for (Cuentas cuenta : listaDeCuentas) {
			cajaCuentas.addItem(cuenta);
		}
		panelCampos.add(cajaCuentas);
		cajaCuentas.setPreferredSize(new Dimension(80, 20));

		campoFecha = new JDateChooser();
		campoFecha.setDate(new Date());
		panelCampos.add(campoFecha);

		panelTexto = new JTextPane();
		Font fuenteTexto = new Font("Time New Roman", Font.BOLD, 15);
		panelTexto.setFont(fuenteTexto);
		panelTexto.setText("¡Es hora de sacar cuentas!");
		panelComponentes.add(panelTexto);

		// CONSTRUCCIÓN DE TABLA
		tablaVerPrevisiones = new JTable();
		tablaVerPrevisiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaVerPrevisiones.setFillsViewportHeight(false);
		tablaVerPrevisiones.setRowHeight(30);
		Font f = new Font("Time New Roman", Font.PLAIN, 12);
		tablaVerPrevisiones.setFont(f);

		panelDesplazamiento = new JScrollPane(tablaVerPrevisiones);
		panelDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelCentral.add(panelDesplazamiento, BorderLayout.CENTER);

		// CONFIGURACIÓN DE PANELCOMPONENTES
		panelFunciones = new JPanel();
		panelFunciones.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		contentPanel.add(panelFunciones, BorderLayout.SOUTH);

		// CONFIGURACIÓN DE BOTONES FUNCIONES PRINCIPALES
		{
			btnVerPrevision = new JButton("Ver Previsión");
			btnVerPrevision.setActionCommand(BOTON_VER_VENTANA_VER_PREVISION);
			panelFunciones.add(btnVerPrevision);
		}

		// CONFIGURACIÓN DE PANEL PARA BOTON SALIR
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			btnSalir = new JButton("Salir");
			btnSalir.setActionCommand(InterfazVentanaVerPrevision.BOTON_SALIR_VENTANA_VER_PREVISION);
			buttonPane.add(btnSalir);
		}
	}

	@Override
	public void calcularPrevision(List<Previsiones> previsionesFiltradas) {
		Double total = 0.0;
		for (Previsiones prevision : previsionesFiltradas) {
			if (prevision.getTipos().getNombre().equals("Ingreso")) {
				total = total + prevision.getValor();
			} else {
				total = total - prevision.getValor();
			}
		}

		Cuentas cuenta = (Cuentas) cajaCuentas.getSelectedItem();
		Double saldoActual = cuenta.getSaldo();
		panelTexto.setText("El saldo actual de tu cuenta es: " + saldoActual
				+ "\r\nPara la fecha indicada tu saldo sera: " + (saldoActual + total));
	}

	@Override
	public Previsiones obtenerPrevisionSeleccionada() {
		return mtp.obtenerObjeto(tablaVerPrevisiones.getSelectedRow());
	}

	@Override
	public void asignarDatosTablaVerPrevisiones(List<Previsiones> listaDePrevisiones) {
		mtp = new ModeloTablaPrevisiones();
		mtp.asignarListaDeCuentas(listaDePrevisiones);
		tablaVerPrevisiones.setModel(mtp);
	}

	@Override
	public void asignarControlador(ControladorPrevisiones control) {
		btnSalir.addActionListener(control);
		btnVerPrevision.addActionListener(control);
	}

	@Override
	public void iniciar(InterfazPrevisiones vistaPrevision) {
		pack();
		setLocationRelativeTo((Component) vistaPrevision);
		setVisible(true);
	}

	@Override
	public JDateChooser getCampoFecha() {
		return campoFecha;
	}

	@Override
	public void setCampoFecha(JDateChooser campoFecha) {
		this.campoFecha = campoFecha;
	}

	@Override
	public JComboBox<Cuentas> getCajaCuentas() {
		return cajaCuentas;
	}

	@Override
	public void setCajaCuentas(JComboBox<Cuentas> cajaCuentas) {
		this.cajaCuentas = cajaCuentas;
	}
}
