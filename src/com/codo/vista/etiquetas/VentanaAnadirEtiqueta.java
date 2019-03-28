package com.codo.vista.etiquetas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorEtiquetas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.etiquetas.InterfazEtiquetas;
import com.codo.vista.interfaces.etiquetas.InterfazVentanaAnadirEtiqueta;

public class VentanaAnadirEtiqueta extends JDialog implements InterfazVentanaAnadirEtiqueta {

	private static final long serialVersionUID = 1L;
	private static final int ANCHURA_MINIMA_VENTANA = 450;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JFormattedTextField campoNombre;
	private JComboBox<Tipos> cajaTipos;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JPanel panelLabels;
	private JPanel panelCampos;
	private JLabel lblTipo;
	private JLabel lblNombre;

	public VentanaAnadirEtiqueta(List<Tipos> listaDeTipos) {
		
		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Etiquetas - Añadir");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout());

		// CONFIGURACIÓN DE CONTENTPANEL

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 70));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panelLabels = new JPanel();
			panelLabels.setPreferredSize(new Dimension(100, 60));
			panelLabels.setLayout(new GridLayout(0, 1, 0, 10));
			contentPanel.add(panelLabels);

		}
		{
			panelCampos = new JPanel();
			panelCampos.setPreferredSize(new Dimension(100, 60));
			panelCampos.setLayout(new GridLayout(0, 1, 0, 10));
			contentPanel.add(panelCampos);
		}

		// LABELS

		lblTipo = new JLabel("Tipo:");
		panelLabels.add(lblTipo);

		lblNombre = new JLabel("Nombre:");
		panelLabels.add(lblNombre);

		// CAMPOS PARA AÑADIR

		cajaTipos = new JComboBox<Tipos>();
		for (Tipos tipo : listaDeTipos) {
			cajaTipos.addItem(tipo);
		}
		panelCampos.add(cajaTipos);

		campoNombre = new JFormattedTextField();
		panelCampos.add(campoNombre);

		// BOTONES

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setActionCommand(BOTON_ACEPTAR_VENTANA_ANADIR_ETIQUETA);
			buttonPane.add(btnAceptar);
			getRootPane().setDefaultButton(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setActionCommand(BOTON_CANCELAR_VENTANA_ANADIR_ETIQUETA);
			buttonPane.add(btnCancelar);
		}
	}

	@Override
	public void asignarControlador(ControladorEtiquetas control) {
		btnAceptar.addActionListener(control);
		btnCancelar.addActionListener(control);
	}
	
	@Override
	public Etiquetas leerCamposAnadirEtiqueta(){
		Tipos tipo=(Tipos) cajaTipos.getSelectedItem();
		String nombre = campoNombre.getText();
		Etiquetas etiqueta = new Etiquetas (tipo,nombre);
		return etiqueta;
	}
	
	@Override
	public boolean comprobarCampos() {

		if (campoNombre.getText().isEmpty()) {
			System.out.println(campoNombre.getText());
			JOptionPane.showMessageDialog(this, "El valor del nombre no es correcto.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else
			return true;
	}

	@Override
	public void iniciar(InterfazEtiquetas vistaEtiquetas) {
		pack();
		setLocationRelativeTo((Component) vistaEtiquetas);
		setVisible(true);
	}
}
