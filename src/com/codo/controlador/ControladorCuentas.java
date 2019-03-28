package com.codo.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Monedas;
import com.codo.vista.cuentas.VentanaAnadirCuenta;
import com.codo.vista.cuentas.VentanaModificarCuenta;
import com.codo.vista.interfaces.cuentas.InterfazCuentas;
import com.codo.vista.interfaces.cuentas.InterfazVentanaAnadirCuenta;
import com.codo.vista.interfaces.cuentas.InterfazVentanaModificarCuenta;

public class ControladorCuentas implements ActionListener {

	private InterfazCuentas vistaCuentas;
	private ModeloCD modelo;

	// VENTANAS
	private InterfazVentanaAnadirCuenta vistaAnadirCuenta;
	private InterfazVentanaModificarCuenta vistaModificarCuenta;

	public ControladorCuentas(InterfazCuentas vistaCuentas, ModeloCD modelo) {
		this.vistaCuentas = vistaCuentas;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		// ---------------- ACCIONES VENTANA CUENTAS ---------------- //
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_ANADIR_CUENTA)) {
			List<Monedas> listaDeMonedas = modelo.listaDeMonedas();
			vistaAnadirCuenta = new VentanaAnadirCuenta(listaDeMonedas);
			vistaAnadirCuenta.asignarControlador(this);
			vistaAnadirCuenta.iniciar(vistaCuentas);
		}

		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_BORRAR_CUENTA)) {
			if (vistaCuentas.obtenerCuentaSeleccionada() == null) {
				JOptionPane.showMessageDialog((Component) vistaCuentas, "Debe Seleccionar una Cuenta", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int confirmado = JOptionPane.showConfirmDialog((Component) vistaCuentas,
						"¿Está Completamente Seguro? Si Borra una Cuenta se Perderan TODOS los Datos Asociados",
						"Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
				if (confirmado == JOptionPane.YES_OPTION) {
					modelo.borrarCuenta((vistaCuentas.obtenerCuentaSeleccionada()));
					vistaCuentas.asignarDatosTablaCuentas(modelo.listaDeCuentas());
					JOptionPane.showMessageDialog((Component) vistaCuentas, "Cuenta Borrada Exitosamente", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_MODIFICAR_CUENTA)) {
			List<Monedas> listaDeMonedas = modelo.listaDeMonedas();
			vistaModificarCuenta = new VentanaModificarCuenta(listaDeMonedas);
			vistaModificarCuenta.asignarControlador(this);
			if (vistaCuentas.obtenerCuentaSeleccionada() != null) {
				vistaModificarCuenta.rellenarCampos(vistaCuentas.obtenerCuentaSeleccionada());
				vistaModificarCuenta.iniciar(vistaCuentas);
			} else {
				JOptionPane.showMessageDialog((Component) vistaCuentas, "Debe Seleccionar una Cuenta", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_SALIR_VENTANA_CUENTAS)) {
			vistaCuentas.dispose();
		}

		// ---------------- VENTANA AÑADIR CUENTA ---------------- //

		if (evento.getActionCommand().equals(InterfazVentanaAnadirCuenta.BOTON_ACEPTAR_ANADIR_CUENTA)) {
			if (vistaAnadirCuenta.comprobarCampos()) {
				Cuentas cuenta = vistaAnadirCuenta.leerCamposAnadirCuenta();
				modelo.crearCuenta(cuenta);
				List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
				vistaCuentas.asignarDatosTablaCuentas(listaDeCuentas);
				JOptionPane.showMessageDialog((Component) vistaAnadirCuenta, "Cuenta Añadida Exitosamente", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				vistaAnadirCuenta.dispose();
			}
		}

		if (evento.getActionCommand().equals(InterfazVentanaAnadirCuenta.BOTON_CANCELAR_ANADIR_CUENTA)) {
			vistaAnadirCuenta.dispose();
		}

		// ---------------- VENTANA MODIFICAR CUENTA ---------------- //
		if (evento.getActionCommand().equals(InterfazVentanaModificarCuenta.BOTON_ACEPTAR_MODIFICAR_CUENTA)) {
			if (vistaModificarCuenta.comprobarCampos()) {
			modelo.actualizarCuenta(vistaModificarCuenta.actualizarCuentas(vistaCuentas.obtenerCuentaSeleccionada()));
			vistaCuentas.asignarDatosTablaCuentas(modelo.listaDeCuentas());
			JOptionPane.showMessageDialog((Component) vistaModificarCuenta, "Modificación Realizada Exitosamente", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			vistaModificarCuenta.dispose();
			}
		}

		if (evento.getActionCommand().equals(InterfazVentanaModificarCuenta.BOTON_CANCELAR_MODIFICAR_CUENTA)) {
			vistaModificarCuenta.dispose();
		}
	}
}
