package com.codo.vista.interfaces.cuentas;

import com.codo.controlador.ControladorCuentas;

public interface InterfazComunCuentas {

	void asignarControlador(ControladorCuentas control);

	void iniciar(InterfazCuentas vistaCuentas);

	void dispose();

}
