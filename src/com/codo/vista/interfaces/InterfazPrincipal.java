package com.codo.vista.interfaces;

import com.codo.controlador.ControladorPrincipal;

public interface InterfazPrincipal extends InterfazComun {

	String BOTON_CUENTAS = "abrir ventana cuentas";
	String BOTON_MOVIMIENTOS = "abrir ventana movimientos";
	String BOTON_PREVISIONES = "abrir ventana previsiones";
	String BOTON_INGRESOS = "abrir ventana ingresos";
	String BOTON_GASTOS = "abrir ventana gastos";
	String BOTON_TRANSFERENCIAS = "abrir ventana transferencias";
	String BOTON_ETIQUETAS = "abrir ventana etiquetas";
	String BOTON_SOBRE = "abrir ventana sobre";

	void asignarControlador(ControladorPrincipal control);
}
