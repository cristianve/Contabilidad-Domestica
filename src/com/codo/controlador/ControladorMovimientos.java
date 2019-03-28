package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.vista.interfaces.movimientos.InterfazMovimientos;

public class ControladorMovimientos implements ActionListener {

	private InterfazMovimientos vistaMovimientos;
	private ModeloCD modelo;

	public ControladorMovimientos(InterfazMovimientos vistaMovimientos, ModeloCD modelo) {
		this.vistaMovimientos = vistaMovimientos;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazMovimientos.BOTON_CONSULTAR_MOVIMIENTOS)) {

			if (vistaMovimientos.comprovarFechaVacia()) {

				if (vistaMovimientos.comprovarFechas()) {
					vistaMovimientos.asignarDatosTablaMovimientos(
							modelo.listaDeMovimientosFiltros(vistaMovimientos.obtenerFiltro()));
				} else {
					JOptionPane.showMessageDialog(null, "La fecha desde debe ser anterior a la fecha hasta", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (evento.getActionCommand().equals(InterfazMovimientos.BOTON_REVERTIR_MOVIMIENTO)) {
			if (vistaMovimientos.obtenerMovimientoSeleccionado() == null) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Movimiento", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int confirmado = JOptionPane.showConfirmDialog(null,
						"¿Está Completamente Seguro? Si Revierte el Movimiento NO Podrá Deshacer la Operación",
						"Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
				if (confirmado == JOptionPane.YES_OPTION) {
					modelo.borrarMovimiento(vistaMovimientos.obtenerMovimientoSeleccionado());
					vistaMovimientos.asignarDatosTablaMovimientos(modelo.listaDeMovimientos());
					JOptionPane.showMessageDialog(null, "Movimiento Revertido Exitosamente", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (evento.getActionCommand().equals(InterfazMovimientos.BOTON_SALIR_MOVIMIENTOS)) {
			vistaMovimientos.dispose();
		}

		// --------------- ACCIONES ADICIONALES --------------- //

		if (evento.getActionCommand().equals(InterfazMovimientos.ACCION_CAJA_TIPO_MOVIMIENTOS)) {
			String seleccion = vistaMovimientos.itemSeleccionadoCajaTipo();
			if (seleccion.equals("Ingreso")) {
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeIngresos();
				vistaMovimientos.refrescarCajaEtiquetas(lista);
			} else if (seleccion.equals("Gasto")) {
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeGastos();
				vistaMovimientos.refrescarCajaEtiquetas(lista);
			} else if (seleccion.equals("Transferencia")) {
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeTransferencias();
				vistaMovimientos.refrescarCajaEtiquetas(lista);
			}
		}
	}
}
