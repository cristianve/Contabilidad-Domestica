package com.codo.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrincipal;
import com.codo.vista.interfaces.InterfazPrincipal;

public class VentanaPrincipal extends JFrame implements InterfazPrincipal {

	private static final long serialVersionUID = 1L;
	private static final int SET_LOCATION_X = 150;
	private static final int SET_LOCATION_Y = 150;
	private static final int ANCHURA_MINIMA_VENTANA = 220;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelBotones;
	private JButton btnCuentas;
	private JButton btnMovimientos;
	private JButton btnPrevisiones;
	private JButton btnIngresos;
	private JButton btnGastos;
	private JButton btnTransferencias;
	private JMenuBar barraMenu;
	private JMenu menuArchivo;
	private JMenu menuAnadir;
	private JMenuItem menuSobre;
	private JMenuItem menuEtiquetas;

	public VentanaPrincipal() {

		super("Codo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanel);

		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		menuArchivo = new JMenu("Archivo");
		barraMenu.add(menuArchivo);

		menuSobre = new JMenuItem("Sobre");
		menuSobre.setActionCommand(BOTON_SOBRE);
		menuArchivo.add(menuSobre);

		menuAnadir = new JMenu("Añadir");
		barraMenu.add(menuAnadir);

		menuEtiquetas = new JMenuItem("Etiquetas");
		menuEtiquetas.setActionCommand(BOTON_ETIQUETAS);
		menuAnadir.add(menuEtiquetas);

		panelBotones = new JPanel();
		contentPanel.add(panelBotones, BorderLayout.CENTER);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[] { 220, 1 };
		gbl_panelBotones.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 6 };
		gbl_panelBotones.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelBotones.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelBotones.setLayout(gbl_panelBotones);

		btnCuentas = new JButton("Cuentas");
		GridBagConstraints gbc_btnCuentas = new GridBagConstraints();
		gbc_btnCuentas.fill = GridBagConstraints.BOTH;
		gbc_btnCuentas.insets = new Insets(0, 0, 5, 0);
		gbc_btnCuentas.gridx = 0;
		gbc_btnCuentas.gridy = 0;
		panelBotones.add(btnCuentas, gbc_btnCuentas);
		btnCuentas.setActionCommand(BOTON_CUENTAS);

		btnIngresos = new JButton("Ingresos");
		GridBagConstraints gbc_btnIngresos = new GridBagConstraints();
		gbc_btnIngresos.fill = GridBagConstraints.BOTH;
		gbc_btnIngresos.insets = new Insets(0, 0, 5, 0);
		gbc_btnIngresos.gridx = 0;
		gbc_btnIngresos.gridy = 1;
		panelBotones.add(btnIngresos, gbc_btnIngresos);
		btnIngresos.setActionCommand(BOTON_INGRESOS);

		btnGastos = new JButton("Gastos");
		GridBagConstraints gbc_btnGastos = new GridBagConstraints();
		gbc_btnGastos.fill = GridBagConstraints.BOTH;
		gbc_btnGastos.insets = new Insets(0, 0, 5, 0);
		gbc_btnGastos.gridx = 0;
		gbc_btnGastos.gridy = 2;
		panelBotones.add(btnGastos, gbc_btnGastos);
		btnGastos.setActionCommand(BOTON_GASTOS);

		btnTransferencias = new JButton("Transferencias");
		GridBagConstraints gbc_btnTransferencias = new GridBagConstraints();
		gbc_btnTransferencias.fill = GridBagConstraints.BOTH;
		gbc_btnTransferencias.insets = new Insets(0, 0, 5, 0);
		gbc_btnTransferencias.gridx = 0;
		gbc_btnTransferencias.gridy = 3;
		panelBotones.add(btnTransferencias, gbc_btnTransferencias);
		btnTransferencias.setActionCommand(BOTON_TRANSFERENCIAS);

		btnMovimientos = new JButton("Movimientos");
		GridBagConstraints gbc_btnMovimientos = new GridBagConstraints();
		gbc_btnMovimientos.fill = GridBagConstraints.BOTH;
		gbc_btnMovimientos.insets = new Insets(0, 0, 5, 0);
		gbc_btnMovimientos.gridx = 0;
		gbc_btnMovimientos.gridy = 4;
		panelBotones.add(btnMovimientos, gbc_btnMovimientos);
		btnMovimientos.setActionCommand(BOTON_MOVIMIENTOS);

		btnPrevisiones = new JButton("Previsiones");
		GridBagConstraints gbc_btnPrevisiones = new GridBagConstraints();
		gbc_btnPrevisiones.fill = GridBagConstraints.BOTH;
		gbc_btnPrevisiones.gridx = 0;
		gbc_btnPrevisiones.gridy = 5;
		panelBotones.add(btnPrevisiones, gbc_btnPrevisiones);
		btnPrevisiones.setActionCommand(BOTON_PREVISIONES);

	}

	@Override
	public void asignarControlador(ControladorPrincipal control) {
		btnCuentas.addActionListener(control);
		btnMovimientos.addActionListener(control);
		btnPrevisiones.addActionListener(control);
		btnIngresos.addActionListener(control);
		btnGastos.addActionListener(control);
		btnTransferencias.addActionListener(control);
		menuEtiquetas.addActionListener(control);
		menuSobre.addActionListener(control);
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}
}
