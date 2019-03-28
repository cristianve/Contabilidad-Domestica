package com.codo.vista.cuentas;

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

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.vista.componentes.ModeloTablaCuentas;
import com.codo.vista.interfaces.cuentas.InterfazCuentas;

public class VentanaCuentas extends JDialog implements InterfazCuentas {

	private static final long serialVersionUID = 1L;
	private static final int SET_LOCATION_X = 380;
	private static final int SET_LOCATION_Y = 150;
	private static final int ANCHURA_MINIMA_VENTANA = 550;
	private static final int ALTURA_MINIMA_VENTANA = 400;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTable tablaCuentas;
	private JScrollPane panelDesplazamiento;
	private JButton btnAnadir;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnSalir;
	private ModeloTablaCuentas mtc;
	private JPanel panelFunciones;

	public VentanaCuentas() {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Cuentas");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout());

		// CONFIGURACIÓN DE CONTENTPANEL
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// CONSTRUCCION DE TABLA
		tablaCuentas = new JTable();
		tablaCuentas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaCuentas.setFillsViewportHeight(false);
		tablaCuentas.setRowHeight(30);
		Font f = new Font("Time New Roman", Font.PLAIN, 12);
		tablaCuentas.setFont(f);

		panelDesplazamiento = new JScrollPane(tablaCuentas);
		panelDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPanel.add(panelDesplazamiento, BorderLayout.CENTER);

		// CONFIGURACIÓN PANEL FUNCIONES
		panelFunciones = new JPanel();
		panelFunciones.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		contentPanel.add(panelFunciones, BorderLayout.SOUTH);

		// BOTONES

		btnAnadir = new JButton("Añadir");
		btnAnadir.setActionCommand(BOTON_ANADIR_CUENTA);
		panelFunciones.add(btnAnadir);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setActionCommand(BOTON_BORRAR_CUENTA);
		panelFunciones.add(btnBorrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setActionCommand(BOTON_MODIFICAR_CUENTA);
		panelFunciones.add(btnModificar);

		// CONFIGURACIÓN DE PANEL PARA BOTON SALIR
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		{
			// CONFIGURACIÓN DEL BOTON SALIR
			btnSalir = new JButton("Salir");
			btnSalir.setActionCommand(BOTON_SALIR_VENTANA_CUENTAS);
			buttonPane.add(btnSalir);
		}
	}

	@Override
	public void asignarControlador(ControladorCuentas control) {
		btnAnadir.addActionListener(control);
		btnBorrar.addActionListener(control);
		btnModificar.addActionListener(control);
		btnSalir.addActionListener(control);
	}

	@Override
	public void asignarDatosTablaCuentas(List<Cuentas> listaDeCuentas) {
		mtc = new ModeloTablaCuentas();
		mtc.asignarListaDeCuentas(listaDeCuentas);
		tablaCuentas.setModel(mtc);
	}

	@Override
	public Cuentas obtenerCuentaSeleccionada() {
		return mtc.obtenerObjeto(tablaCuentas.getSelectedRow());
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}
}