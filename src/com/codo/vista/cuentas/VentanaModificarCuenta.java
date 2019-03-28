package com.codo.vista.cuentas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Monedas;
import com.codo.vista.interfaces.cuentas.InterfazCuentas;
import com.codo.vista.interfaces.cuentas.InterfazVentanaModificarCuenta;

public class VentanaModificarCuenta extends JDialog implements InterfazVentanaModificarCuenta {

	private static final long serialVersionUID = 1L;
	private static final int ANCHURA_MINIMA_VENTANA = 450;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JFormattedTextField campoNombre;
	private JFormattedTextField campoSaldo;
	private JFormattedTextField campoDescripcion;
	private JComboBox<Monedas> cajaMoneda;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JPanel panelLabels;
	private JPanel panelCampos;
	private JLabel lblNombre;
	private JLabel lblSaldo;
	private JLabel lblMoneda;
	private JLabel lblDescripcion;

	public VentanaModificarCuenta(List<Monedas> listaDeMonedas) {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Cuentas - Modificar");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout());

		// CONFIGURACIÓN DE CONTENTPANEL

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panelLabels = new JPanel();
			panelLabels.setPreferredSize(new Dimension(100, 150));
			panelLabels.setLayout(new GridLayout(0, 1, 0, 20));
			contentPanel.add(panelLabels);

		}
		{
			panelCampos = new JPanel();
			panelCampos.setPreferredSize(new Dimension(100, 150));
			panelCampos.setLayout(new GridLayout(0, 1, 0, 20));
			contentPanel.add(panelCampos);
		}

		// LABELS

		lblNombre = new JLabel("Nombre:");
		panelLabels.add(lblNombre);

		lblSaldo = new JLabel("Saldo:");
		panelLabels.add(lblSaldo);

		lblMoneda = new JLabel("Moneda:");
		panelLabels.add(lblMoneda);

		lblDescripcion = new JLabel("Descripción:");
		panelLabels.add(lblDescripcion);

		// CAMPOS PARA AÑADIR

		campoNombre = new JFormattedTextField();
		panelCampos.add(campoNombre);

		NumberFormat formatValor = new DecimalFormat("#0.00");
		campoSaldo = new JFormattedTextField(formatValor);
		panelCampos.add(campoSaldo);

		cajaMoneda = new JComboBox<Monedas>();
		for (Monedas moneda : listaDeMonedas) {
			cajaMoneda.addItem(moneda);
		}
		panelCampos.add(cajaMoneda);

		campoDescripcion = new JFormattedTextField();
		panelCampos.add(campoDescripcion);

		// BOTONES

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setActionCommand(BOTON_ACEPTAR_MODIFICAR_CUENTA);
			buttonPane.add(btnAceptar);
			getRootPane().setDefaultButton(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setActionCommand(BOTON_CANCELAR_MODIFICAR_CUENTA);
			buttonPane.add(btnCancelar);
		}
	}

	@Override
	public void asignarControlador(ControladorCuentas control) {
		btnAceptar.addActionListener(control);
		btnCancelar.addActionListener(control);
	}

	@Override
	public void rellenarCampos(Cuentas cuenta) {
		this.campoNombre.setText(cuenta.getNombre());
		this.campoSaldo.setText(String.valueOf(cuenta.getSaldo()));
		this.cajaMoneda.setSelectedIndex((cuenta.getMonedas().getIdMoneda()-1));
		this.campoDescripcion.setText(cuenta.getDescripcion());
	}

	public Cuentas actualizarCuentas(Cuentas cuenta) {
		cuenta.setNombre(campoNombre.getText());
		cuenta.setSaldo(Double.valueOf(campoSaldo.getText().replace(",", ".")));
		cuenta.setMonedas((Monedas) cajaMoneda.getSelectedItem());
		cuenta.setDescripcion(campoDescripcion.getText());
		return cuenta;
	}
	
	public boolean comprobarCampos() {

		if (campoNombre.getText().isEmpty() && campoSaldo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El valor del nombre y el saldo no son correctos.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (campoNombre.getText().isEmpty()) {
			System.out.println(campoNombre.getText());
			JOptionPane.showMessageDialog(this, "El valor del nombre no es correcto.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (campoSaldo.getText().isEmpty()) {
			System.out.println(campoSaldo.getText());
			JOptionPane.showMessageDialog(this, "El valor del saldo no es correcto.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else
			return true;
	}

	@Override
	public void iniciar(InterfazCuentas vistaCuentas) {
		pack();
		setLocationRelativeTo((Component) vistaCuentas);
		setVisible(true);
	}
}
