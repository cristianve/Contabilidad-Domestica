package com.codo.vista.interfaces.etiquetas;

import com.codo.controlador.ControladorEtiquetas;

public interface InterfazComunEtiquetas {

	void asignarControlador(ControladorEtiquetas control);

	void iniciar(InterfazEtiquetas vistaEtiquetas);

	void dispose();

}
