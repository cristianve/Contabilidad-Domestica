package com.codo.vista.interfaces.etiquetas;

import com.codo.modelo.pojos.Etiquetas;

public interface InterfazVentanaAnadirEtiqueta extends InterfazComunEtiquetas {

	String BOTON_ACEPTAR_VENTANA_ANADIR_ETIQUETA = "Boton Aceptar Ventana Anadir Etiqueta";
	String BOTON_CANCELAR_VENTANA_ANADIR_ETIQUETA = "Boton Cancelar Ventana Anadir Etiqueta";

	Etiquetas leerCamposAnadirEtiqueta();

	boolean comprobarCampos();

}
