package com.codo.vista.interfaces.gastos;

import com.codo.controlador.ControladorGastos;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazGastos extends InterfazComun {

	String BOTON_ANADIR_GASTO = "Añadir Gasto";
	String BOTON_CANCELAR_GASTO = "Boton Cancelar Gasto";

	void asignarControlador(ControladorGastos control);

	void limpiarCampos();

	void dispose();

	boolean comprobarCampos();

	Movimientos anadirGasto();

}
