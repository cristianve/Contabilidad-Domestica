package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codo.modelo.ModeloCD;
import com.codo.vista.interfaces.ingresos.InterfazIngresos;

public class ControladorIngresos implements ActionListener {

	private InterfazIngresos vistaIngresos;
	private ModeloCD modelo;

	public ControladorIngresos(InterfazIngresos vistaIngresos, ModeloCD modelo) {
		this.vistaIngresos = vistaIngresos;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazIngresos.BOTON_ANADIR_INGRESO)) {
			if (vistaIngresos.comprobarCampos()) {
				modelo.crearMovimiento(vistaIngresos.anadirIngreso());
			}
		}

		if (evento.getActionCommand().equals(InterfazIngresos.BOTON_CANCELAR_INGRESO)) {
			vistaIngresos.dispose();
		}
	}
}
