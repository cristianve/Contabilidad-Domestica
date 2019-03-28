package com.codo.vista.interfaces.transferencias;

import com.codo.controlador.ControladorTransferencias;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazTransferencias extends InterfazComun {

	String BOTON_CANCELAR_TRANSFERENCIA = "Boton Cancelar Transferencia";
	String BOTON_ANADIR_TRANSFERENCIA = "Boton Añadir Transferencia";

	void asignarControlador(ControladorTransferencias control);

	void limpiarCampos();

	void dispose();

	boolean comprobarCampos();

	Movimientos anadirTransferencia();

}
