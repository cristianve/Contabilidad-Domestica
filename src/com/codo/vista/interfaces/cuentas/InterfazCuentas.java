package com.codo.vista.interfaces.cuentas;

import java.util.List;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazCuentas extends InterfazComun {

	String BOTON_ANADIR_CUENTA = "Boton Añadir Ventana Cuentas";
	String BOTON_BORRAR_CUENTA = "Boton Borrar Ventana Cuentas";
	String BOTON_MODIFICAR_CUENTA = "Boton Modificar Ventana Cuentas";
	String BOTON_SALIR_VENTANA_CUENTAS = "Boton Salir Ventana Cuentas";

	void asignarControlador(ControladorCuentas control);

	void asignarDatosTablaCuentas(List<Cuentas> listaDeCuentas);

	void dispose();

	Cuentas obtenerCuentaSeleccionada();

}