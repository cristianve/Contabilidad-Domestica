package com.codo.vista.interfaces.cuentas;

import com.codo.modelo.pojos.Cuentas;

public interface InterfazVentanaAnadirCuenta extends InterfazComunCuentas {

	String BOTON_ACEPTAR_ANADIR_CUENTA = "Boton Aceptar Añadir Cuenta";
	String BOTON_CANCELAR_ANADIR_CUENTA = "Boton Cancelar Añadir Cuenta";

	Cuentas leerCamposAnadirCuenta();

	void limpiarCampos();

	boolean comprobarCampos();

}
