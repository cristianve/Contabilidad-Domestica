package com.codo.vista.interfaces.previsiones;

import java.util.List;

import javax.swing.JComboBox;

import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Previsiones;
import com.toedter.calendar.JDateChooser;

public interface InterfazVentanaVerPrevision extends InterfazComunPrevision {

	String BOTON_SALIR_VENTANA_VER_PREVISION = "Boton Salir Ventana Ver Previsión";
	String BOTON_VER_VENTANA_VER_PREVISION = "Boton Ver Ventana Ver Previsión";

	Previsiones obtenerPrevisionSeleccionada();

	void asignarDatosTablaVerPrevisiones(List<Previsiones> listaDePrevisiones);

	JDateChooser getCampoFecha();

	void setCampoFecha(JDateChooser campoFecha);

	JComboBox<Cuentas> getCajaCuentas();

	void setCajaCuentas(JComboBox<Cuentas> cajaCuentas);

	void calcularPrevision(List<Previsiones> previsionesFiltradas);

}
