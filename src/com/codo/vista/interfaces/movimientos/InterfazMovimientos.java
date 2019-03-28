package com.codo.vista.interfaces.movimientos;

import java.util.List;

import com.codo.controlador.ControladorMovimientos;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazMovimientos extends InterfazComun {

	String BOTON_CONSULTAR_MOVIMIENTOS = "Consultar Movimientos";
	String BOTON_REVERTIR_MOVIMIENTO = "Revertir Movimiento";
	String BOTON_SALIR_MOVIMIENTOS = "Boton Salir de Movimientos";
	String ACCION_CAJA_TIPO_MOVIMIENTOS = "selección cambiada caja tipo movimientos";

	void asignarControlador(ControladorMovimientos control);

	void asignarDatosTablaMovimientos(List<Movimientos> listaDeMovimientos);

	void refrescarCajaEtiquetas(List<Etiquetas> lista);

	void dispose();

	Movimientos obtenerMovimientoSeleccionado();

	boolean comprovarFechas();

	boolean comprovarFechaVacia();

	String obtenerFiltro();

	String itemSeleccionadoCajaTipo();

}
