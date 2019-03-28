package com.codo.vista.previsiones;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

import com.codo.controlador.ControladorPrevisiones;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Previsiones;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.previsiones.InterfazPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazVentanaModificarPrevision;
import com.toedter.calendar.JDateChooser;

public class VentanaModificarPrevision extends JDialog implements InterfazVentanaModificarPrevision {

	private static final long serialVersionUID = 1L;
	private static final int ANCHURA_MINIMA_VENTANA = 450;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JPanel panelComponentes;
	private JLabel lblCuentaDeOrigen;
	private JLabel lblCuentaDeDestino;
	private JLabel lblEtiqueta;
	private JLabel lblValor;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JComboBox<Tipos> cajaTipos;
	private JComboBox<Cuentas> cajaCuentaDeOrigen;
	private JComboBox<Cuentas> cajaCuentaDeDestino;
	private JComboBox<Etiquetas> cajaEtiquetas;
	private JFormattedTextField campoValor;
	private JDateChooser campoFecha;
	private JTextField campoDescripcion;

	public VentanaModificarPrevision() {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Previsiones - Modificar");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panelComponentes = new JPanel();
			panelComponentes.setMinimumSize(new Dimension(0, 0));
			panelComponentes.setPreferredSize(new Dimension(0, 0));
			contentPanel.add(panelComponentes, BorderLayout.CENTER);
			panelComponentes.setLayout(null);

			JPanel panelIzquierdo = new JPanel();
			panelIzquierdo.setBounds(61, 11, 126, 189);
			panelIzquierdo.setOpaque(false);
			panelIzquierdo.setPreferredSize(new Dimension(100, 150));
			panelComponentes.add(panelIzquierdo);
			panelIzquierdo.setLayout(new GridLayout(7, 1, 0, 5));

			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipo.setHorizontalTextPosition(SwingConstants.RIGHT);
			panelIzquierdo.add(lblTipo);
			{
				lblCuentaDeOrigen = new JLabel("Cuenta de Origen:");
				lblCuentaDeOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCuentaDeOrigen.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblCuentaDeOrigen);
			}
			{
				lblCuentaDeDestino = new JLabel("Cuenta de Destino:");
				lblCuentaDeDestino.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCuentaDeDestino.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblCuentaDeDestino);
			}
			{
				lblEtiqueta = new JLabel("Etiqueta:");
				lblEtiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
				lblEtiqueta.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblEtiqueta);
			}
			{
				lblValor = new JLabel("*Valor:");
				lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
				lblValor.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblValor);
			}
			{
				lblFecha = new JLabel("*Fecha:");
				lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFecha.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblFecha);
			}
			{
				lblDescripcion = new JLabel("Descripción:");
				lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblDescripcion);
			}

			JPanel panelDerecho = new JPanel();
			panelDerecho.setBounds(197, 11, 100, 189);
			panelDerecho.setMinimumSize(new Dimension(0, 0));
			panelDerecho.setPreferredSize(new Dimension(100, 240));
			panelComponentes.add(panelDerecho);
			panelDerecho.setLayout(new GridLayout(7, 1, 0, 5));
			{
				cajaTipos = new JComboBox<Tipos>();
				cajaTipos.setActionCommand(ACCION_CAJA_TIPO_VENTANA_MODIFICAR_PREVISION);
				panelDerecho.add(cajaTipos);
			}
			{
				cajaCuentaDeOrigen = new JComboBox<Cuentas>();
				panelDerecho.add(cajaCuentaDeOrigen);
			}
			{
				cajaCuentaDeDestino = new JComboBox<Cuentas>();
				panelDerecho.add(cajaCuentaDeDestino);
			}
			{
				cajaEtiquetas = new JComboBox<Etiquetas>();
				panelDerecho.add(cajaEtiquetas);
			}
			{
				campoValor = new JFormattedTextField();
				panelDerecho.add(campoValor);
			}
			{
				campoFecha = new JDateChooser();
				campoFecha.setDate(new Date());
				panelDerecho.add(campoFecha);
			}
			{
				campoDescripcion = new JTextField();
				panelDerecho.add(campoDescripcion);
			}
		}

		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar
						.setActionCommand(InterfazVentanaModificarPrevision.BOTON_ACEPTAR_VENTANA_MODIFICAR_PREVISION);
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar
						.setActionCommand(InterfazVentanaModificarPrevision.BOTON_CANCELAR_VENTANA_MODIFICAR_PREVISION);
				buttonPane.add(btnCancelar);
			}
		}
	}

	@Override
	public void rellenarCampos(Previsiones prevision, boolean cuentaDestino) {
		this.cajaTipos.setSelectedIndex(prevision.getTipos().getIdTipo() - 1);
		this.cajaCuentaDeOrigen.setSelectedIndex(prevision.getCuentasByIdCuentaOrigen().getIdCuenta() - 1);
		if (cuentaDestino) {
			this.cajaCuentaDeDestino.setSelectedIndex(prevision.getCuentasByIdCuentaDestino().getIdCuenta() - 1);
		}

		int comprobacion = obtenerIndiceDeEtiqueta(prevision);
		if (comprobacion != -1) {
			this.cajaEtiquetas.setSelectedIndex(comprobacion);
		}

		this.campoValor.setText(String.valueOf(prevision.getValor()));
		this.campoFecha.setDate(prevision.getFecha());
		this.campoDescripcion.setText(prevision.getDescripcion());
	}

	public int obtenerIndiceDeEtiqueta(Previsiones prevision) {

		for (int i = 0; i < cajaEtiquetas.getItemCount(); i++) {
			if (cajaEtiquetas.getItemAt(i).getNombre().equals(prevision.getEtiquetas().getNombre())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Previsiones actualizarPrevision(Previsiones prevision) {
		prevision.setTipos((Tipos) cajaTipos.getSelectedItem());
		prevision.setCuentasByIdCuentaOrigen((Cuentas) cajaCuentaDeOrigen.getSelectedItem());
		prevision.setCuentasByIdCuentaDestino((Cuentas) cajaCuentaDeDestino.getSelectedItem());
		prevision.setEtiquetas((Etiquetas) cajaEtiquetas.getSelectedItem());
		prevision.setValor(Double.valueOf(campoValor.getText().replace(",", ".")));
		prevision.setFecha(campoFecha.getDate());
		prevision.setDescripcion(campoDescripcion.getText());
		return prevision;
	}

	@Override
	public void cargarListas(List<Tipos> listaDeTipos, List<Cuentas> listaDeCuentas, List<Etiquetas> listaEtiquetas,
			boolean cuentaDestino) {

		for (Tipos tipo : listaDeTipos) {
			cajaTipos.addItem(tipo);
		}

		for (Cuentas cuenta : listaDeCuentas) {
			cajaCuentaDeOrigen.addItem(cuenta);
		}

		if (cuentaDestino) {
			for (Cuentas cuenta : listaDeCuentas) {
				cajaCuentaDeDestino.addItem(cuenta);
			}
		}

		for (Etiquetas etiqueta : listaEtiquetas) {
			cajaEtiquetas.addItem(etiqueta);
		}
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
	public void llenarCajaCuentasDeDestino(List<Cuentas> listaDeCuentas) {
		for (Cuentas cuenta : listaDeCuentas) {
			cajaCuentaDeDestino.addItem(cuenta);
		}
	}

	@Override
	public boolean comprobarCampos() {

		if (campoValor.getText().isEmpty() && campoFecha.getDate() == null) {
			JOptionPane.showMessageDialog(this, "El valor y la fecha no son correctos.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (campoValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El valor no es correcto.", "Error campos", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (campoFecha.getDate() == null) {
			JOptionPane.showMessageDialog(this, "La fecha introducida no es correcta.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (cajaTipos.getSelectedItem().toString().equals("Transferencia")) {
			if (cajaCuentaDeOrigen.getSelectedItem().toString()
					.equals(cajaCuentaDeDestino.getSelectedItem().toString())) {
				JOptionPane.showMessageDialog(this, "Cuenta de Origen debe ser diferente a Cuenta de Destino",
						"Error campos", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}

		else
			return true;
	}

	@Override
	public void asignarControlador(ControladorPrevisiones control) {
		btnAceptar.addActionListener(control);
		btnCancelar.addActionListener(control);
		cajaTipos.addActionListener(control);
	}

	@Override
	public void iniciar(InterfazPrevisiones vistaPrevision) {
		pack();
		setLocationRelativeTo((Component) vistaPrevision);
		setVisible(true);
	}

	@Override
	public JComboBox<Cuentas> getCajaCuentaDeDestino() {
		return cajaCuentaDeDestino;
	}

	@Override
	public void setCajaCuentaDeDestino(JComboBox<Cuentas> cajaCuentaDeDestino) {
		this.cajaCuentaDeDestino = cajaCuentaDeDestino;
	}
}