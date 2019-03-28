package com.codo.vista.etiquetas;

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

import com.codo.controlador.ControladorEtiquetas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.vista.componentes.ModeloTablaEtiquetas;
import com.codo.vista.interfaces.etiquetas.InterfazEtiquetas;

public class VentanaEtiquetas extends JDialog implements InterfazEtiquetas {

	private static final long serialVersionUID = 1L;
	private static final int SET_LOCATION_X = 380;
	private static final int SET_LOCATION_Y = 150;
	private static final int ANCHURA_MINIMA_VENTANA = 500;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelComponentes;
	private JPanel buttonPane;
	private ModeloTablaEtiquetas mte;
	private JTable tablaEtiquetas;
	private JScrollPane panelDesplazamiento;
	private JButton btnAnadir;
	private JButton btnBorrar;
	private JButton btnSalir;

	public VentanaEtiquetas() {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Etiquetas");
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
		tablaEtiquetas = new JTable();
		tablaEtiquetas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaEtiquetas.setFillsViewportHeight(false);
		tablaEtiquetas.setRowHeight(30);
		Font f = new Font("Time New Roman", Font.PLAIN, 12);
		tablaEtiquetas.setFont(f);

		panelDesplazamiento = new JScrollPane(tablaEtiquetas);
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
			btnAnadir.setActionCommand(BOTON_ANADIR_VENTANA_ETIQUETAS);
			panelComponentes.add(btnAnadir);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.setActionCommand(BOTON_BORRAR_VENTANA_ETIQUETAS);
			panelComponentes.add(btnBorrar);
		}

		// CONFIGURACIÓN DE PANEL PARA BOTON SALIR
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		{
			// CONFIGURACIÓN DEL BOTON SALIR
			btnSalir = new JButton("Salir");
			btnSalir.setActionCommand(BOTON_SALIR_VENTANA_ETIQUETAS);
			buttonPane.add(btnSalir);
		}
	}

	@Override
	public void asignarControlador(ControladorEtiquetas control) {
		btnAnadir.addActionListener(control);
		btnBorrar.addActionListener(control);
		btnSalir.addActionListener(control);
	}

	@Override
	public Etiquetas obtenerEtiquetaSeleccionada() {
		return mte.obtenerObjeto(tablaEtiquetas.getSelectedRow());
	}

	@Override
	public void asignarDatosTablaEtiquetas(List<Etiquetas> listaDeEtiquetas) {
		mte = new ModeloTablaEtiquetas();
		mte.asignarListaDeCuentas(listaDeEtiquetas);
		tablaEtiquetas.setModel(mte);
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}
}
