package com.codo.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Previsiones;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.previsiones.InterfazPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazVentanaAnadirPrevision;
import com.codo.vista.interfaces.previsiones.InterfazVentanaModificarPrevision;
import com.codo.vista.interfaces.previsiones.InterfazVentanaVerPrevision;
import com.codo.vista.previsiones.VentanaAnadirPrevision;
import com.codo.vista.previsiones.VentanaModificarPrevision;
import com.codo.vista.previsiones.VentanaVerPrevision;

public class ControladorPrevisiones implements ActionListener {

	private InterfazPrevisiones vistaPrevisiones;
	private ModeloCD modelo;

	// VENTANAS ADICIONALES PREVISIONES
	private InterfazVentanaAnadirPrevision vistaAnadirPrevision;
	private InterfazVentanaModificarPrevision vistaModificarPrevision;
	private InterfazVentanaVerPrevision vistaVerPrevision;

	public ControladorPrevisiones(InterfazPrevisiones vistaPrevisiones, ModeloCD modelo) {
		this.vistaPrevisiones = vistaPrevisiones;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		// --------------- ACCIONES VENTANA PREVISIONES --------------- //

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_ANADIR_VENTANA_PREVISIONES)) {
			List<Tipos> listaDeTipos = modelo.listaDeTipos();
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			List<Etiquetas> listaDeEtiquetasDeIngresos = modelo.listaDeEtiquetasDeIngresos();
			vistaAnadirPrevision = new VentanaAnadirPrevision(listaDeTipos, listaDeCuentas, listaDeEtiquetasDeIngresos);
			vistaAnadirPrevision.asignarControlador(this);
			vistaAnadirPrevision.iniciar(vistaPrevisiones);
		}

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_BORRAR_VENTANA_PREVISIONES)) {
			if (vistaPrevisiones.obtenerPrevisionSeleccionada() == null) {
				JOptionPane.showMessageDialog((Component) vistaPrevisiones, "Debe Seleccionar una Previsión", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int confirmado = JOptionPane.showConfirmDialog((Component) vistaPrevisiones,
						"¿Está Completamente Seguro? Si Borra una Previsión no podra recuperarla", "Advertencia",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (confirmado == JOptionPane.YES_OPTION) {
					modelo.borrarPrevision(vistaPrevisiones.obtenerPrevisionSeleccionada());
					vistaPrevisiones.asignarDatosTablaPrevisiones(modelo.listaDePrevisiones());
					JOptionPane.showMessageDialog((Component) vistaPrevisiones, "Previsión Borrada Exitosamente",
							"Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_MODIFICAR_VENTANA_PREVISIONES)) {
			vistaModificarPrevision = new VentanaModificarPrevision();
			vistaModificarPrevision.asignarControlador(this);

			// CONFIGURAR CAMPOS SEGÚN EL TIPO DE PREVISIÓN SELECCIONADA

			if (vistaPrevisiones.obtenerPrevisionSeleccionada() != null) {
				String seleccion = vistaPrevisiones.obtenerPrevisionSeleccionada().getTipos().getNombre();
				if (seleccion.equals("Ingreso")) {
					List<Tipos> listaDeTipos = modelo.listaDeTipos();
					List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
					List<Etiquetas> listaEtiquetas = modelo.listaDeEtiquetasDeIngresos();
					vistaModificarPrevision.getCajaCuentaDeDestino().setEnabled(false);
					Previsiones prevision = vistaPrevisiones.obtenerPrevisionSeleccionada();
					vistaModificarPrevision.cargarListas(listaDeTipos, listaDeCuentas, listaEtiquetas, false);
					vistaModificarPrevision.rellenarCampos(prevision, false);
					vistaModificarPrevision.iniciar(vistaPrevisiones);

				} else if (seleccion.equals("Gasto")) {
					List<Tipos> listaDeTipos = modelo.listaDeTipos();
					List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
					List<Etiquetas> listaEtiquetas = modelo.listaDeEtiquetasDeGastos();
					vistaModificarPrevision.getCajaCuentaDeDestino().setEnabled(false);
					Previsiones prevision = vistaPrevisiones.obtenerPrevisionSeleccionada();
					vistaModificarPrevision.cargarListas(listaDeTipos, listaDeCuentas, listaEtiquetas, false);
					vistaModificarPrevision.rellenarCampos(prevision, false);
					vistaModificarPrevision.iniciar(vistaPrevisiones);

				} else if (seleccion.equals("Transferencia")) {
					List<Tipos> listaDeTipos = modelo.listaDeTipos();
					List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
					List<Etiquetas> listaEtiquetas = modelo.listaDeEtiquetasDeTransferencias();
					vistaModificarPrevision.getCajaCuentaDeDestino().setEnabled(true);
					Previsiones prevision = vistaPrevisiones.obtenerPrevisionSeleccionada();
					vistaModificarPrevision.cargarListas(listaDeTipos, listaDeCuentas, listaEtiquetas, true);
					vistaModificarPrevision.rellenarCampos(prevision, true);
					vistaModificarPrevision.iniciar(vistaPrevisiones);
				}

			} else {
				JOptionPane.showMessageDialog((Component) vistaPrevisiones, "Debe Seleccionar una Previsión", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_VER_PREVISION_VENTANA_PREVISIONES)) {
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			vistaVerPrevision = new VentanaVerPrevision(listaDeCuentas);
			vistaVerPrevision.asignarControlador(this);
			vistaVerPrevision.iniciar(vistaPrevisiones);
		}

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_SALIR_VENTANA_PREVISIONES)) {
			vistaPrevisiones.dispose();
		}

		// ------------ ACCIONES VENTANA AÑADIR PREVISIONES ------------ //

		if (evento.getActionCommand().equals(InterfazVentanaAnadirPrevision.BOTON_ACEPTAR_VENTANA_ANADIR_PREVISION)) {
			if (vistaAnadirPrevision.comprobarCampos()) {
				modelo.crearPrevision(vistaAnadirPrevision.anadirPrevision());
				vistaPrevisiones.asignarDatosTablaPrevisiones(modelo.listaDePrevisiones());
				JOptionPane.showMessageDialog((Component) vistaAnadirPrevision, "Previsión registrada correctamente",
						"Previsión Registrada", JOptionPane.INFORMATION_MESSAGE);
				vistaAnadirPrevision.dispose();
			}
		}

		if (evento.getActionCommand().equals(InterfazVentanaAnadirPrevision.BOTON_CANCELAR_VENTANA_ANADIR_PREVISION)) {
			vistaAnadirPrevision.dispose();
		}

		if (evento.getActionCommand()
				.equals(InterfazVentanaAnadirPrevision.ACCION_CAJA_TIPO_VENTANA_ANADIR_PREVISION)) {
			String seleccion = vistaAnadirPrevision.itemSeleccionadoCajaTipo();
			if (seleccion.equals("Ingreso")) {
				vistaAnadirPrevision.getCajaCuentaDeDestino().removeAllItems();
				vistaAnadirPrevision.getCajaCuentaDeDestino().setEnabled(false);
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeIngresos();
				vistaAnadirPrevision.refrescarCajaEtiquetas(lista);
			} else if (seleccion.equals("Gasto")) {
				vistaAnadirPrevision.getCajaCuentaDeDestino().removeAllItems();
				vistaAnadirPrevision.getCajaCuentaDeDestino().setEnabled(false);
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeGastos();
				vistaAnadirPrevision.refrescarCajaEtiquetas(lista);
			} else if (seleccion.equals("Transferencia")) {
				vistaAnadirPrevision.getCajaCuentaDeDestino().setEnabled(true);
				vistaAnadirPrevision.llenarCajaCuentasDeDestino(modelo.listaDeCuentas());
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeTransferencias();
				vistaAnadirPrevision.refrescarCajaEtiquetas(lista);
			}
		}

		// ------------ ACCIONES VENTANA MODIFICAR PREVISIONES ------------ //

		if (evento.getActionCommand()
				.equals(InterfazVentanaModificarPrevision.BOTON_ACEPTAR_VENTANA_MODIFICAR_PREVISION)) {
			if (vistaModificarPrevision.comprobarCampos()) {
				modelo.actualizarPrevision(
						vistaModificarPrevision.actualizarPrevision(vistaPrevisiones.obtenerPrevisionSeleccionada()));
				vistaPrevisiones.asignarDatosTablaPrevisiones(modelo.listaDePrevisiones());
				JOptionPane.showMessageDialog((Component) vistaModificarPrevision, "Previsión modificada correctamente",
						"Previsión Modificada", JOptionPane.INFORMATION_MESSAGE);
				vistaModificarPrevision.dispose();
			}
		}

		if (evento.getActionCommand()
				.equals(InterfazVentanaModificarPrevision.BOTON_CANCELAR_VENTANA_MODIFICAR_PREVISION)) {
			vistaModificarPrevision.dispose();
		}

		if (evento.getActionCommand()
				.equals(InterfazVentanaModificarPrevision.ACCION_CAJA_TIPO_VENTANA_MODIFICAR_PREVISION)) {
			String seleccion = vistaModificarPrevision.itemSeleccionadoCajaTipo();
			if (seleccion.equals("Ingreso")) {
				vistaModificarPrevision.getCajaCuentaDeDestino().removeAllItems();
				vistaModificarPrevision.getCajaCuentaDeDestino().setEnabled(false);
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeIngresos();
				vistaModificarPrevision.refrescarCajaEtiquetas(lista);
			} else if (seleccion.equals("Gasto")) {
				vistaModificarPrevision.getCajaCuentaDeDestino().removeAllItems();
				vistaModificarPrevision.getCajaCuentaDeDestino().setEnabled(false);
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeGastos();
				vistaModificarPrevision.refrescarCajaEtiquetas(lista);
			} else if (seleccion.equals("Transferencia")) {
				vistaModificarPrevision.getCajaCuentaDeDestino().setEnabled(true);
				vistaModificarPrevision.llenarCajaCuentasDeDestino(modelo.listaDeCuentas());
				List<Etiquetas> lista = modelo.listaDeEtiquetasDeTransferencias();
				vistaModificarPrevision.refrescarCajaEtiquetas(lista);
			}
		}

		// ------------ ACCIONES VENTANA VER PREVISIONES ------------ //

		if (evento.getActionCommand().equals(InterfazVentanaVerPrevision.BOTON_VER_VENTANA_VER_PREVISION)) {
			List<Previsiones> previsionesFiltradas = modelo.listaDePrevisionesFiltro(
					(Cuentas) vistaVerPrevision.getCajaCuentas().getSelectedItem(),
					vistaVerPrevision.getCampoFecha().getDate());
			vistaVerPrevision.asignarDatosTablaVerPrevisiones(previsionesFiltradas);
			vistaVerPrevision.calcularPrevision(previsionesFiltradas);
			
		}

		if (evento.getActionCommand().equals(InterfazVentanaVerPrevision.BOTON_SALIR_VENTANA_VER_PREVISION)) {
			vistaVerPrevision.dispose();
		}

	}
}
