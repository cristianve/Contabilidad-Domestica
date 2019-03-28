package com.codo.vista.ingresos;

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

import com.codo.controlador.ControladorIngresos;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.ingresos.InterfazIngresos;
import com.toedter.calendar.JDateChooser;

public class VentanaIngresos extends JDialog implements InterfazIngresos {

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
	private JComboBox<Cuentas> comboBoxCuenta;
	private JComboBox<Etiquetas> comboBoxEtiquetas;
	private JFormattedTextField textFieldValor;
	private JTextField textFieldComentario;
	private JDateChooser dateChooser;
	private JButton btnAnadirIngreso;
	private JButton btnCancelar;
	private List<Tipos> listaDeTipos;

	public VentanaIngresos(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiquetaDeIngresos,
			List<Tipos> listaDeTipos) {

		this.listaDeTipos = listaDeTipos;

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Ingresos - Añadir");
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
		panelIzquierdo.setPreferredSize(new Dimension(100, 200));
		panelIzquierdo.setLayout(new GridLayout(0, 1, 0, 20));
		panelCentral.add(panelIzquierdo);

		panelDerecho = new JPanel();
		panelDerecho.setPreferredSize(new Dimension(100, 200));
		panelDerecho.setLayout(new GridLayout(0, 1, 0, 20));
		panelCentral.add(panelDerecho);

		// LABELS

		JLabel lblVentanaDeIngresos = new JLabel("Ventana de Ingresos");
		lblVentanaDeIngresos.setPreferredSize(new Dimension(100, 50));
		lblVentanaDeIngresos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblVentanaDeIngresos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVentanaDeIngresos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentanaDeIngresos.setForeground(Color.BLUE);
		lblVentanaDeIngresos.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPanel.add(lblVentanaDeIngresos, BorderLayout.NORTH);

		JLabel lblCuenta = new JLabel("Cuenta:");
		lblCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuenta.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelIzquierdo.add(lblCuenta);

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

		comboBoxCuenta = new JComboBox<Cuentas>();
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuenta.addItem(cuenta);
		}
		panelDerecho.add(comboBoxCuenta);

		comboBoxEtiquetas = new JComboBox<Etiquetas>();
		for (Etiquetas etiqueta : listaDeEtiquetaDeIngresos) {
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
				btnAnadirIngreso = new JButton("Añadir Ingreso");
				btnAnadirIngreso.setActionCommand(BOTON_ANADIR_INGRESO);
				buttonPane.add(btnAnadirIngreso);
				getRootPane().setDefaultButton(btnAnadirIngreso);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand(BOTON_CANCELAR_INGRESO);
				buttonPane.add(btnCancelar);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorIngresos control) {
		btnAnadirIngreso.addActionListener(control);
		btnCancelar.addActionListener(control);
	}

	@Override
	public Movimientos anadirIngreso() {
		Cuentas cuenta = (Cuentas) comboBoxCuenta.getSelectedItem();
		Etiquetas etiqueta = (Etiquetas) comboBoxEtiquetas.getSelectedItem();
		Double valor = Double.valueOf(textFieldValor.getText().replace(",", "."));
		Date fecha = dateChooser.getDate();
		String comentario = textFieldComentario.getText();
		Movimientos movimiento = new Movimientos(cuenta, etiqueta, listaDeTipos.get(0), valor, fecha, comentario);
		this.limpiarCampos();
		return movimiento;
	}

	@Override
	public void limpiarCampos() {
		textFieldValor.setText("");
		dateChooser.setDate(new Date());
		textFieldComentario.setText("");
		JOptionPane.showMessageDialog(null, "Ingreso realizado correctamente", "Ingreso realizado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean comprobarCampos() {

		if (textFieldValor.getText().isEmpty() && dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "El valor del ingreso y la fecha no son correctos.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (textFieldValor.getText().isEmpty()) {
			System.out.println(textFieldValor.getText());
			JOptionPane.showMessageDialog(null, "El valor del ingreso no es correcto.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "La fecha introducida no es correcta.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else
			return true;
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}
}