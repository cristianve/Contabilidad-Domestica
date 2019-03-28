package com.codo.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.vista.interfaces.InterfazComun;

public class VentanaSobre extends JDialog implements InterfazComun {

	private static final long serialVersionUID = 1L;
	private static final int SET_LOCATION_X = 385;
	private static final int SET_LOCATION_Y = 150;
	private static final int ANCHURA_MINIMA_VENTANA = 535;
	private static final int ALTURA_MINIMA_VENTANA = 452;
	private final JPanel contentPanel = new JPanel();

	public VentanaSobre() {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Sobre");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());

		// CONFIGURACIÓN DE CONTENTPANEL
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		{
			JLabel lblSobre = new JLabel("");
			lblSobre.setIcon(new ImageIcon("Informacion.png"));
			lblSobre.setBounds(0, 0, 532, 465);
			contentPanel.add(lblSobre);
		}
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(SET_LOCATION_X, SET_LOCATION_Y);
		setVisible(true);
	}
}
