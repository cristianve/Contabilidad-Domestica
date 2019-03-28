package com.codo.vista.interfaces.previsiones;

import java.util.List;

import com.codo.controlador.ControladorPrevisiones;
import com.codo.modelo.pojos.Previsiones;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazPrevisiones extends InterfazComun {

	String BOTON_ANADIR_VENTANA_PREVISIONES = "Boton Añadir Ventana Previsiones";
	String BOTON_BORRAR_VENTANA_PREVISIONES = "Boton Borrar Ventana Previsiones";
	String BOTON_MODIFICAR_VENTANA_PREVISIONES = "Boton Modificar Ventana Previsiones";
	String BOTON_VER_PREVISION_VENTANA_PREVISIONES = "Boton Ver Previsión Ventana Previsiones";
	String BOTON_SALIR_VENTANA_PREVISIONES = "Boton Salir Ventana Previsiones";

	void asignarControlador(ControladorPrevisiones control);

	void asignarDatosTablaPrevisiones(List<Previsiones> listaDePrevisiones);

	void dispose();

	Previsiones obtenerPrevisionSeleccionada();

}
