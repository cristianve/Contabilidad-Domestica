package com.codo.principal;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.codo.controlador.ControladorPrincipal;
import com.codo.modelo.ModeloCD;
import com.codo.vista.VentanaPrincipal;
import com.codo.vista.interfaces.InterfazPrincipal;

public class Principal {

	public static void main(String[] args) {
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		// generamos el modelo
		ModeloCD modelo = new ModeloCD();
		// generamos la vista
		InterfazPrincipal vista = new VentanaPrincipal();
		// generamos el controlador
		ControladorPrincipal control = new ControladorPrincipal(vista, modelo);
		// configuramos la vista
		vista.asignarControlador(control);
		// iniciamos la vista
		vista.iniciar();
	}
}
