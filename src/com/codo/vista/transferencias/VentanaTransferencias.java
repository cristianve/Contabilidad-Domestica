package com.codo.vista.transferencias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorTransferencias;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.transferencias.InterfazTransferencias;
import com.toedter.calendar.JDateChooser;

public class VentanaTransferencias extends JDialog implements InterfazTransferencias {

	private static final long serialVersionUID = 1L;
	private static final int SET_LOCATION_X = 385;
	private static final int SET_LOCATION_Y = 150;
	private static final int ANCHURA_MINIMA_VENTANA = 400;
	private static final int ALTURA_MINIMA_VENTANA = 400;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelCentral;
	private JPanel panelIzquierdo;
	private JPanel panelDerecho;
	private JPanel buttonPane;
	private JComboBox<Cuentas> comboBoxCuentaOrigen;
	private JComboBox<Cuentas> comboBoxCuentaDestino;
	private JComboBox<Etiquetas> comboBoxEtiquetas;
	private JFormattedTextField textFieldValor;
	private JTextField textFieldComentario;
	private JDateChooser dateChooser;
	private JButton btnAnadirTransferencia;
	private JButton btnCancelar;
	private List<Tipos> listaDeTipos;

	public VentanaTransferencias(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiquetaDeTransferencias,
			List<Tipos> listaDeTipos) {

		this.listaDeTipos = listaDeTipos;

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Transferencias - Añadir");
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(new BorderLayout());

		// CONFIGURACIÓN DE CONTENTPANEL

		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		panelCentral = new JPanel();
		panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		contentPanel.add(panelCentral, BorderLayout.CENTER);

		panelIzquierdo = new JPanel();
		panelIzquierdo.setPreferredSize(new Dimension(130, 220));
		panelIzquierdo.setLayout(new GridLayout(0, 1, 0, 20));
		panelCentral.add(panelIzquierdo);

		panelDerecho = new JPanel();
		panelDerecho.setPreferredSize(new Dimension(100, 220));
		panelDerecho.setLayout(new GridLayout(0, 1, 0, 20));
		panelCentral.add(panelDerecho);

		// LABELS

		JLabel lblVentanaDeTransferencias = new JLabel("Ventana de Transferencias");
		lblVentanaDeTransferencias.setPreferredSize(new Dimension(100, 50));
		lblVentanaDeTransferencias.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblVentanaDeTransferencias.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVentanaDeTransferencias.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentanaDeTransferencias.setForeground(Color.BLUE);
		lblVentanaDeTransferencias.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPanel.add(lblVentanaDeTransferencias, BorderLayout.NORTH);

		JLabel lblCuentaDeOrigen = new JLabel("Cuenta de Origen:");
		lblCuentaDeOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuentaDeOrigen.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCuentaDeOrigen.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelIzquierdo.add(lblCuentaDeOrigen);

		JLabel lblCuentaDeDestino = new JLabel("Cuenta de Destino:");
		lblCuentaDeDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuentaDeDestino.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCuentaDeDestino.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelIzquierdo.add(lblCuentaDeDestino);

		JLabel lblEtiquetas = new JLabel("Etiquetas:");
		lblEtiquetas.setHorizontalTextPosition(SwingConstants.LEFT);
		lblEtiquetas.setHorizontalAlignment(SwingConstants.LEFT);
		lblEtiquetas.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelIzquierdo.add(lblEtiquetas);

		JLabel lblValor = new JLabel("*Valor: ");
		lblValor.setHorizontalTextPosition(SwingConstants.LEFT);
		lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelIzquierdo.add(lblValor);

		JLabel lblFecha = new JLabel("*Fecha: ");
		lblFecha.setHorizontalTextPosition(SwingConstants.LEFT);
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelIzquierdo.add(lblFecha);

		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setHorizontalTextPosition(SwingConstants.LEFT);
		lblComentario.setHorizontalAlignment(SwingConstants.LEFT);
		lblComentario.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelIzquierdo.add(lblComentario);

		// COMFIGURACIÓN DE CAMPOS

		comboBoxCuentaOrigen = new JComboBox<Cuentas>();
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuentaOrigen.addItem(cuenta);
		}
		panelDerecho.add(comboBoxCuentaOrigen);

		comboBoxCuentaDestino = new JComboBox<Cuentas>();
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuentaDestino.addItem(cuenta);
		}
		panelDerecho.add(comboBoxCuentaDestino);

		comboBoxEtiquetas = new JComboBox<Etiquetas>();
		for (Etiquetas etiqueta : listaDeEtiquetaDeTransferencias) {
			comboBoxEtiquetas.addItem(etiqueta);
		}
		panelDerecho.add(comboBoxEtiquetas);

		NumberFormat formatValor = new DecimalFormat("#0.00");
		textFieldValor = new JFormattedTextField(formatValor);
		textFieldValor.setColumns(10);
		panelDerecho.add(textFieldValor);

		dateChooser = new JDateChooser();
		dateChooser.setDate(new Date());
		panelDerecho.add(dateChooser);

		textFieldComentario = new JTextField();
		textFieldComentario.setColumns(10);
		panelDerecho.add(textFieldComentario);

		// BOTONES

		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAnadirTransferencia = new JButton("Añadir Transferencia");
				btnAnadirTransferencia.setActionCommand(BOTON_ANADIR_TRANSFERENCIA);
				buttonPane.add(btnAnadirTransferencia);
				getRootPane().setDefaultButton(btnAnadirTransferencia);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand(BOTON_CANCELAR_TRANSFERENCIA);
				buttonPane.add(btnCancelar);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorTransferencias control) {
		btnAnadirTransferencia.addActionListener(control);
		btnCancelar.addActionListener(control);
	}

	@Override
	public Movimientos anadirTransferencia() {
		Cuentas cuentaOrigen = (Cuentas) comboBoxCuentaOrigen.getSelectedItem();
		Cuentas cuentaDestino = (Cuentas) comboBoxCuentaDestino.getSelectedItem();
		Etiquetas etiqueta = (Etiquetas) comboBoxEtiquetas.getSelectedItem();
		Double valor = Double.valueOf(textFieldValor.getText().replace(",", "."));
		Date fecha = dateChooser.getDate();
		String comentario = textFieldComentario.getText();
		Movimientos movimiento = new Movimientos(cuentaOrigen, cuentaDestino, etiqueta, listaDeTipos.get(2), valor,
				fecha, comentario);
		this.limpiarCampos();
		return movimiento;
	}

	@Override
	public void limpiarCampos() {
		textFieldValor.setText("");
		dateChooser.setDate(new Date());
		textFieldComentario.setText("");
		JOptionPane.showMessageDialog(null, "Transferencia realizada correctamente", "Transferencia realizada",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public boolean comprobarCampos() {
		if (textFieldValor.getText().isEmpty() && dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "El valor de la transferencia y la fecha no son correctos",
					"Error campos", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (textFieldValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El valor de la transferencia no es correcto", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "La fecha introducida no es correcta", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (comboBoxCuentaOrigen.getSelectedItem().toString()
				.equals(comboBoxCuentaDestino.getSelectedItem().toString())) {
			JOptionPane.showMessageDialog(this, "Cuenta de Origen debe ser diferente a Cuenta de Destino",
					"Error campos", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}
}
