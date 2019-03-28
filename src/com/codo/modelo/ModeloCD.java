package com.codo.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.codo.modelo.daos.CuentasDAO;
import com.codo.modelo.daos.EtiquetasDAO;
import com.codo.modelo.daos.MonedasDAO;
import com.codo.modelo.daos.MovimientosDAO;
import com.codo.modelo.daos.PrevisionesDAO;
import com.codo.modelo.daos.TiposDAO;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Monedas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Previsiones;
import com.codo.modelo.pojos.Tipos;

public class ModeloCD {

	private static final EntityManagerFactory EM_FACTORY = Persistence.createEntityManagerFactory("ProyectoORM");

	CuentasDAO cuentas = new CuentasDAO(EM_FACTORY);
	EtiquetasDAO etiquetas = new EtiquetasDAO(EM_FACTORY);
	MonedasDAO monedas = new MonedasDAO(EM_FACTORY);
	MovimientosDAO movimientos = new MovimientosDAO(EM_FACTORY);
	PrevisionesDAO previsiones = new PrevisionesDAO(EM_FACTORY);
	TiposDAO tipos = new TiposDAO(EM_FACTORY);

	// --------- CUENTAS --------- //

	public void crearCuenta(Cuentas cuenta) {
		cuentas.crear(cuenta);
	}

	public void actualizarCuenta(Cuentas cuenta) {
		cuentas.actualizar(cuenta);
	}

	public void borrarCuenta(Cuentas cuenta) {
		cuentas.borrar(cuenta);
	}

	public List<Cuentas> listaDeCuentas() {
		return cuentas.leerCuentas();
	}

	// --------- ETIQUETAS --------- //

	public void crearEtiqueta(Etiquetas etiqueta) {
		etiquetas.crear(etiqueta);
	}

	public void actualizarEtiqueta(Etiquetas etiqueta) {
		etiquetas.actualizar(etiqueta);
	}

	public void borrarEtiqueta(Etiquetas etiqueta) {
		etiquetas.borrar(etiqueta);
	}

	public List<Etiquetas> listaDeEtiquetas() {
		return etiquetas.leerEtiquetas();
	}

	public List<Etiquetas> listaDeEtiquetasDeIngresos() {
		String sentenciaSQL = "SELECT s FROM Etiquetas s where idTipo=1 OR idTipo=null";
		return etiquetas.leerEtiquetasFiltro(sentenciaSQL);
	}

	public List<Etiquetas> listaDeEtiquetasDeGastos() {
		String sentenciaSQL = "SELECT s FROM Etiquetas s where idTipo=2 OR idTipo=null";
		return etiquetas.leerEtiquetasFiltro(sentenciaSQL);
	}

	public List<Etiquetas> listaDeEtiquetasDeTransferencias() {
		String sentenciaSQL = "SELECT s FROM Etiquetas s where idTipo=3 OR idTipo=null";
		return etiquetas.leerEtiquetasFiltro(sentenciaSQL);
	}

	// --------- MONEDAS --------- //

	public void crearMoneda(Monedas moneda) {
		monedas.crear(moneda);
	}

	public void actualizarMoneda(Monedas moneda) {
		monedas.actualizar(moneda);
	}

	public void borrarMoneda(Monedas moneda) {
		monedas.borrar(moneda);
	}

	public List<Monedas> listaDeMonedas() {
		return monedas.leerMonedas();
	}

	// --------- MOVIMIENTOS --------- //

	public void crearMovimiento(Movimientos movimiento) {
		movimientos.crear(movimiento);
	}

	public void actualizarMovimiento(Movimientos movimiento) {
		movimientos.actualizar(movimiento);
	}

	public void borrarMovimiento(Movimientos movimiento) {
		movimientos.borrar(movimiento);
	}

	public List<Movimientos> listaDeMovimientos() {
		return movimientos.leerMovimientos();
	}

	public List<Movimientos> listaDeMovimientosFiltros(String sentenciaSQL) {
		return movimientos.leerMovimientosFiltro(sentenciaSQL);
	}

	// --------- PREVISIONES --------- //

	public void crearPrevision(Previsiones prevision) {
		previsiones.crear(prevision);
	}

	public void actualizarPrevision(Previsiones prevision) {
		previsiones.actualizar(prevision);
	}

	public void borrarPrevision(Previsiones prevision) {
		previsiones.borrar(prevision);
	}

	public List<Previsiones> listaDePrevisiones() {
		return previsiones.leerPrevisiones();
	}
	
	public List<Previsiones> listaDePrevisionesFiltro(Cuentas cuenta, Date fechaDePrevision) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		String fechaActual = formatoFecha.format(new Date());
		String fechaFutura = formatoFecha.format(fechaDePrevision);
		String sentenciaSQL = "SELECT s FROM Previsiones s where  ";
		sentenciaSQL = sentenciaSQL + "(idCuentaOrigen=" + cuenta.getIdCuenta() +")";
		sentenciaSQL = sentenciaSQL + " AND fecha BETWEEN '" + fechaActual + "' AND '" + fechaFutura+ "'";
		return previsiones.leerPrevisionesFiltro(sentenciaSQL);
	}

	// --------- TIPOS --------- //

	public void crearTipo(Tipos tipo) {
		tipos.crear(tipo);
	}

	public void actualizarTipo(Tipos tipo) {
		tipos.actualizar(tipo);
	}

	public void borrarTipo(Tipos tipo) {
		tipos.borrar(tipo);
	}

	public List<Tipos> listaDeTipos() {
		return tipos.leerTipos();
	}

}