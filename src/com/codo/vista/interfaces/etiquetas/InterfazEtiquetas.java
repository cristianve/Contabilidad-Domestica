package com.codo.vista.interfaces.etiquetas;

import java.util.List;

import com.codo.controlador.ControladorEtiquetas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazEtiquetas extends InterfazComun {

	String BOTON_ANADIR_VENTANA_ETIQUETAS = "Boton Anadir Ventana Etiquetas";
	String BOTON_BORRAR_VENTANA_ETIQUETAS = "Boton Borrar Ventana Etiquetas";
	String BOTON_SALIR_VENTANA_ETIQUETAS = "Boton Salir Ventana Etiquetas";

	void asignarControlador(ControladorEtiquetas control);

	void dispose();

	void asignarDatosTablaEtiquetas(List<Etiquetas> listaDeEtiquetas);

	Etiquetas obtenerEtiquetaSeleccionada();

}
