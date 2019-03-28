package com.codo.vista.interfaces.previsiones;

import java.util.List;

import javax.swing.JComboBox;

import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Previsiones;
import com.codo.modelo.pojos.Tipos;

public interface InterfazVentanaModificarPrevision extends InterfazComunPrevision {

	String BOTON_ACEPTAR_VENTANA_MODIFICAR_PREVISION = "Boton Aceptar Ventana Modificar Prevision";
	String BOTON_CANCELAR_VENTANA_MODIFICAR_PREVISION = "Boton Cancelar Ventana Modificar Prevision";
	String ACCION_CAJA_TIPO_VENTANA_MODIFICAR_PREVISION = "Cambio de Tipo Caja Tipo Ventana Modificar Prevision";

	void refrescarCajaEtiquetas(List<Etiquetas> lista);

	String itemSeleccionadoCajaTipo();

	void llenarCajaCuentasDeDestino(List<Cuentas> listaDeCuentas);

	boolean comprobarCampos();

	JComboBox<Cuentas> getCajaCuentaDeDestino();

	void setCajaCuentaDeDestino(JComboBox<Cuentas> cajaCuentaDeDestino);

	void rellenarCampos(Previsiones prevision, boolean cuentaDestino);

	Previsiones actualizarPrevision(Previsiones prevision);

	void cargarListas(List<Tipos> listaDeTipos, List<Cuentas> listaDeCuentas, List<Etiquetas> listaEtiquetas,
			boolean cuentaDestino);

}
