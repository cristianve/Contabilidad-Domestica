package com.codo.vista.interfaces.cuentas;

import com.codo.modelo.pojos.Cuentas;

public interface InterfazVentanaModificarCuenta extends InterfazComunCuentas {

	String BOTON_ACEPTAR_MODIFICAR_CUENTA = "Boton Aceptar Modificar Cuenta";
	String BOTON_CANCELAR_MODIFICAR_CUENTA = "Boton Cancelar Modificar Cuenta";

	void rellenarCampos(Cuentas objetoSeleccionado);

	public Cuentas actualizarCuentas(Cuentas cuenta);

	boolean comprobarCampos();

}
