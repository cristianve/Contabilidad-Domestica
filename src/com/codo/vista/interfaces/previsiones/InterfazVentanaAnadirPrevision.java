package com.codo.vista.interfaces.previsiones;

import java.util.List;

import javax.swing.JComboBox;

import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Previsiones;

public interface InterfazVentanaAnadirPrevision extends InterfazComunPrevision {

	String BOTON_ACEPTAR_VENTANA_ANADIR_PREVISION = "Boton Aceptar Ventana Anadir Prevision";
	String BOTON_CANCELAR_VENTANA_ANADIR_PREVISION = "Boton Cancelar Ventana Anadir Prevision";
	String ACCION_CAJA_TIPO_VENTANA_ANADIR_PREVISION = "Selección Cambiada Caja Tipo Anadir Prevision";

	void refrescarCajaEtiquetas(List<Etiquetas> lista);

	String itemSeleccionadoCajaTipo();

	JComboBox<Cuentas> getCajaCuentaDeDestino();

	void setCajaCuentaDeDestino(JComboBox<Cuentas> cajaCuentaDeDestino);

	void llenarCajaCuentasDeDestino(List<Cuentas> listaDeCuentas);

	boolean comprobarCampos();

	Previsiones anadirPrevision();

}
