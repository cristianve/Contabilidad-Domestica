package com.codo.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.vista.etiquetas.VentanaAnadirEtiqueta;
import com.codo.vista.interfaces.etiquetas.InterfazEtiquetas;
import com.codo.vista.interfaces.etiquetas.InterfazVentanaAnadirEtiqueta;

public class ControladorEtiquetas implements ActionListener {

	private InterfazEtiquetas vistaEtiquetas;
	private ModeloCD modelo;

	// VENTANAS ADICIONALES ETIQUETAS
	InterfazVentanaAnadirEtiqueta vistaAnadirEtiqueta;

	public ControladorEtiquetas(InterfazEtiquetas vistaEtiquetas, ModeloCD modelo) {
		this.vistaEtiquetas = vistaEtiquetas;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		// --------------- ACCIONES VENTANA ETIQUETAS --------------- //

		if (evento.getActionCommand().equals(InterfazEtiquetas.BOTON_ANADIR_VENTANA_ETIQUETAS)) {
			vistaAnadirEtiqueta = new VentanaAnadirEtiqueta(modelo.listaDeTipos());
			vistaAnadirEtiqueta.asignarControlador(this);
			vistaAnadirEtiqueta.iniciar(vistaEtiquetas);
		}

		if (evento.getActionCommand().equals(InterfazEtiquetas.BOTON_BORRAR_VENTANA_ETIQUETAS)) {
			if (vistaEtiquetas.obtenerEtiquetaSeleccionada() == null) {
				JOptionPane.showMessageDialog((Component) vistaEtiquetas, "Debe Seleccionar una Etiqueta", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int confirmado = JOptionPane.showConfirmDialog((Component) vistaEtiquetas,
						"¿Está Completamente Seguro? Si Borra una Etiqueta se Perderan TODOS los Datos Asociados",
						"Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
				if (confirmado == JOptionPane.YES_OPTION) {
					modelo.borrarEtiqueta(vistaEtiquetas.obtenerEtiquetaSeleccionada());
					vistaEtiquetas.asignarDatosTablaEtiquetas(modelo.listaDeEtiquetas());
					JOptionPane.showMessageDialog((Component) vistaEtiquetas, "Etiqueta Borrada Exitosamente", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (evento.getActionCommand().equals(InterfazEtiquetas.BOTON_SALIR_VENTANA_ETIQUETAS)) {
			vistaEtiquetas.dispose();
		}

		// --------------- ACCIONES VENTANA AÑADIR ETIQUETAS --------------- //

		if (evento.getActionCommand().equals(InterfazVentanaAnadirEtiqueta.BOTON_ACEPTAR_VENTANA_ANADIR_ETIQUETA)) {
			if (vistaAnadirEtiqueta.comprobarCampos()) {
				Etiquetas etiqueta = vistaAnadirEtiqueta.leerCamposAnadirEtiqueta();
				modelo.crearEtiqueta(etiqueta);
				List<Etiquetas> listaDeEtiquetas = modelo.listaDeEtiquetas();
				vistaEtiquetas.asignarDatosTablaEtiquetas(listaDeEtiquetas);
				JOptionPane.showMessageDialog((Component) vistaAnadirEtiqueta, "Etiqueta Añadida Exitosamente", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				vistaAnadirEtiqueta.dispose();
			}
		}

		if (evento.getActionCommand().equals(InterfazVentanaAnadirEtiqueta.BOTON_CANCELAR_VENTANA_ANADIR_ETIQUETA)) {
			vistaAnadirEtiqueta.dispose();
		}
	}
}
