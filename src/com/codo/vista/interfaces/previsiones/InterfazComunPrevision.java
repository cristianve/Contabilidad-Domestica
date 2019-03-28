package com.codo.vista.interfaces.previsiones;

import com.codo.controlador.ControladorPrevisiones;

public interface InterfazComunPrevision {

	void asignarControlador(ControladorPrevisiones control);

	void iniciar(InterfazPrevisiones vistaPrevision);
	
	void dispose();
}
