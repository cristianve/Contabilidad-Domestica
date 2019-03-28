package com.codo.vista.previsiones;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrevisiones;
import com.codo.modelo.pojos.Previsiones;
import com.codo.vista.componentes.ModeloTablaPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazPrevisiones;

public class VentanaPrevisiones extends JDialog implements InterfazPrevisiones {

	private static final long serialVersionUID = 1L;
	private static final int SET_LOCATION_X = 380;
	private static final int SET_LOCATION_Y = 150;
	private static final int ANCHURA_MINIMA_VENTANA = 700;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelComponentes;
	private JPanel buttonPane;
	private ModeloTablaPrevisiones mtp;
	private JTable tablaPrevisiones;
	private JScrollPane panelDesplazamiento;
	private JButton btnAnadir;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnVerPrevision;
	private JButton btnSalir;

	public VentanaPrevisiones() {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Previsiones");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout());

		// CONFIGURACIÓN DE CONTENTPANEL
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// CONSTRUCCIÓN DE TABLA
		tablaPrevisiones = new JTable();
		tablaPrevisiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaPrevisiones.setFillsViewportHeight(false);
		tablaPrevisiones.setRowHeight(30);
		Font f = new Font("Time New Roman", Font.PLAIN, 12);
		tablaPrevisiones.setFont(f);

		panelDesplazamiento = new JScrollPane(tablaPrevisiones);
		panelDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPanel.add(panelDesplazamiento, BorderLayout.CENTER);

		// CONFIGURACIÓN DE PANELCOMPONENTES
		panelComponentes = new JPanel();
		panelComponentes.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		contentPanel.add(panelComponentes, BorderLayout.SOUTH);

		// CONFIGURACIÓN DE BOTONES FUNCIONES PRINCIPALES
		{
			btnAnadir = new JButton("Añadir");
			btnAnadir.setActionCommand(BOTON_ANADIR_VENTANA_PREVISIONES);
			panelComponentes.add(btnAnadir);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.setActionCommand(BOTON_BORRAR_VENTANA_PREVISIONES);
			panelComponentes.add(btnBorrar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setActionCommand(BOTON_MODIFICAR_VENTANA_PREVISIONES);
			panelComponentes.add(btnModificar);
		}
		{
			btnVerPrevision = new JButton("Ver Previsión");
			btnVerPrevision.setActionCommand(BOTON_VER_PREVISION_VENTANA_PREVISIONES);
			panelComponentes.add(btnVerPrevision);
		}

		// CONFIGURACIÓN DE PANEL PARA BOTON SALIR
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		{
			// CONFIGURACIÓN DEL BOTON SALIR
			btnSalir = new JButton("Salir");
			btnSalir.setActionCommand(BOTON_SALIR_VENTANA_PREVISIONES);
			buttonPane.add(btnSalir);
		}
	}

	@Override
	public void asignarControlador(ControladorPrevisiones control) {
		btnAnadir.addActionListener(control);
		btnBorrar.addActionListener(control);
		btnModificar.addActionListener(control);
		btnVerPrevision.addActionListener(control);
		btnSalir.addActionListener(control);
	}

	@Override
	public Previsiones obtenerPrevisionSeleccionada() {
		return mtp.obtenerObjeto(tablaPrevisiones.getSelectedRow());
	}

	@Override
	public void asignarDatosTablaPrevisiones(List<Previsiones> listaDePrevisiones) {
		mtp = new ModeloTablaPrevisiones();
		mtp.asignarListaDeCuentas(listaDePrevisiones);
		tablaPrevisiones.setModel(mtp);
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}
}
