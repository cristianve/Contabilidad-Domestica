package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Previsiones;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.VentanaSobre;
import com.codo.vista.cuentas.VentanaCuentas;
import com.codo.vista.etiquetas.VentanaEtiquetas;
import com.codo.vista.gastos.VentanaGastos;
import com.codo.vista.ingresos.VentanaIngresos;
import com.codo.vista.interfaces.InterfazPrincipal;
import com.codo.vista.interfaces.cuentas.InterfazCuentas;
import com.codo.vista.interfaces.etiquetas.InterfazEtiquetas;
import com.codo.vista.interfaces.gastos.InterfazGastos;
import com.codo.vista.interfaces.ingresos.InterfazIngresos;
import com.codo.vista.interfaces.movimientos.InterfazMovimientos;
import com.codo.vista.interfaces.previsiones.InterfazPrevisiones;
import com.codo.vista.interfaces.transferencias.InterfazTransferencias;
import com.codo.vista.movimientos.VentanaMovimientos;
import com.codo.vista.previsiones.VentanaPrevisiones;
import com.codo.vista.transferencias.VentanaTransferencias;

public class ControladorPrincipal implements ActionListener {

	@SuppressWarnings("unused")
	private InterfazPrincipal vista;
	private ModeloCD modelo;

	public ControladorPrincipal(InterfazPrincipal vista, ModeloCD modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		// ------- ACCIONES DE LA BARRA DE MENU DE VENTANA PRINCIPAL ------- //

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_SOBRE)) {
			// GENERAMOS LA VISTA DE SOBRE
			VentanaSobre vistaSobre = new VentanaSobre();
			// INICIAMOS LA VISTA DE SOBRE
			vistaSobre.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_ETIQUETAS)) {
			// GENERAMOS LAS LISTAS NECESARIAS
			List<Etiquetas> listaDeEtiquetas = modelo.listaDeEtiquetas();
			// GENERAMOS LA VISTA DE ETIQUETAS
			InterfazEtiquetas vistaEtiquetas = new VentanaEtiquetas();
			// GENERAMOS EL CONTROLADOR DE ETIQUETAS
			ControladorEtiquetas controladorEtiquetas = new ControladorEtiquetas(vistaEtiquetas, modelo);
			// CONFIGURAMOS LA VISTA DE ETIQUETAS
			vistaEtiquetas.asignarControlador(controladorEtiquetas);
			vistaEtiquetas.asignarDatosTablaEtiquetas(listaDeEtiquetas);
			// INICIAMOS LA VISTA DE ETIQUETAS
			vistaEtiquetas.iniciar();
		}

		// ------------------ BOTONES DE VENTANA PRINCIPAL ------------------ //

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_CUENTAS)) {
			// GENERAMOS LAS LISTAS NECESARIAS
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			// GENERAMOS LA VISTA DE CUENTAS
			InterfazCuentas vistaCuentas = new VentanaCuentas();
			// GENERAMOS EL CONTROLADOR DE CUENTAS
			ControladorCuentas controladorCuentas = new ControladorCuentas(vistaCuentas, modelo);
			// CONFIGURAMOS LA VISTA DE CUENTAS
			vistaCuentas.asignarControlador(controladorCuentas);
			vistaCuentas.asignarDatosTablaCuentas(listaDeCuentas);
			// INICIAMOS LA VISTA DE CUENTAS
			vistaCuentas.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_INGRESOS)) {
			// GENERAMOS LAS LISTAS NECESARIAS
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			List<Etiquetas> listaDeEtiquetasDeIngresos = modelo.listaDeEtiquetasDeIngresos();
			List<Tipos> listaDeTipos = modelo.listaDeTipos();
			// GENERAMOS LA VISTA DE INGRESOS
			InterfazIngresos vistaIngresos = new VentanaIngresos(listaDeCuentas, listaDeEtiquetasDeIngresos,
					listaDeTipos);
			// GENERAMOS EL CONTROLADOR DE INGRESOS
			ControladorIngresos controladorIngresos = new ControladorIngresos(vistaIngresos, modelo);
			// CONFIGURAMOS LA VISTA DE INGRESOS
			vistaIngresos.asignarControlador(controladorIngresos);
			// INICIAMOS LA VISTA DE INGRESOS
			vistaIngresos.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_GASTOS)) {
			// GENERAMOS LAS LISTAS NECESARIAS
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			List<Etiquetas> listaDeEtiquetasDeGastos = modelo.listaDeEtiquetasDeGastos();
			List<Tipos> listaDeTipos = modelo.listaDeTipos();
			// GENERAMOS LA VISTA DE GASTOS
			InterfazGastos vistaGastos = new VentanaGastos(listaDeCuentas, listaDeEtiquetasDeGastos, listaDeTipos);
			// GENERAMOS EL CONTROLADOR DE GASTOS
			ControladorGastos controladorGastos = new ControladorGastos(vistaGastos, modelo);
			// CONFIGURAMOS LA VISTA DE GASTOS
			vistaGastos.asignarControlador(controladorGastos);
			// INICIAMOS LA VISTA DE GASTOS
			vistaGastos.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_TRANSFERENCIAS)) {
			// GENERAMOS LAS LISTAS NECESARIAS
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			List<Etiquetas> listaDeEtiquetasDeTransferencias = modelo.listaDeEtiquetasDeTransferencias();
			List<Tipos> listaDeTipos = modelo.listaDeTipos();
			// GENERAMOS LA VISTA DE TRANSFERENCIAS
			InterfazTransferencias vistaTransferencias = new VentanaTransferencias(listaDeCuentas,
					listaDeEtiquetasDeTransferencias, listaDeTipos);
			// GENERAMOS EL CONTROLADOR DE TRANSFERENCIAS
			ControladorTransferencias controladorTransferencias = new ControladorTransferencias(vistaTransferencias,
					modelo);
			// CONFIGURAMOS LA VISTA DE TRANSFERENCIAS
			vistaTransferencias.asignarControlador(controladorTransferencias);
			// INICIAMOS LA VISTA DE TRANSFERENCIAS
			vistaTransferencias.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_MOVIMIENTOS)) {
			// GENERAMOS LAS LISTAS NECESARIAS
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			List<Movimientos> listaDeMovimientos = modelo.listaDeMovimientos();
			List<Etiquetas> listaDeEtiquetasDeIngresos = modelo.listaDeEtiquetasDeIngresos();
			List<Tipos> listaDeTipos = modelo.listaDeTipos();
			// GENERAMOS LA VISTA DE MOVIMIENTOS
			InterfazMovimientos vistaMovimientos = new VentanaMovimientos(listaDeCuentas, listaDeEtiquetasDeIngresos,
					listaDeTipos);
			// GENERAMOS EL CONTROLADOR DE MOVIMIENTOS
			ControladorMovimientos controladorMovimientos = new ControladorMovimientos(vistaMovimientos, modelo);
			// CONFIGURAMOS LA VISTA DE MOVIMIENTOS
			vistaMovimientos.asignarControlador(controladorMovimientos);
			vistaMovimientos.asignarDatosTablaMovimientos(listaDeMovimientos);
			// INICIAMOS LA VISTA DE MOVIMIENTOS
			vistaMovimientos.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_PREVISIONES)) {
			// GENERAMOS LAS LISTAS NECESARIAS
			List<Previsiones> listaDePrevisiones = modelo.listaDePrevisiones();
			// GENERAMOS LA VISTA DE PREVISIONES
			InterfazPrevisiones vistaPrevisiones = new VentanaPrevisiones();
			// GENERAMOS EL CONTROLADOR DE PREVISIONES
			ControladorPrevisiones controladorPrevisiones = new ControladorPrevisiones(vistaPrevisiones, modelo);
			// CONFIGURAMOS LA VISTA DE PREVISIONES
			vistaPrevisiones.asignarControlador(controladorPrevisiones);
			vistaPrevisiones.asignarDatosTablaPrevisiones(listaDePrevisiones);
			// INICIAMOS LA VISTA DE PREVISIONES
			vistaPrevisiones.iniciar();
		}
	}
}
