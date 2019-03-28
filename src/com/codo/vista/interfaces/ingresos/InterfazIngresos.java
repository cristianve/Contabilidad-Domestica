package com.codo.vista.interfaces.ingresos;

import com.codo.controlador.ControladorIngresos;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazIngresos extends InterfazComun {

	String BOTON_ANADIR_INGRESO = "Añadir Ingreso";
	String BOTON_CANCELAR_INGRESO = "Boton Cancelar Ingreso";

	void asignarControlador(ControladorIngresos control);

	void limpiarCampos();

	void dispose();

	boolean comprobarCampos();

	Movimientos anadirIngreso();
}
