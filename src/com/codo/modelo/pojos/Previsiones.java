package com.codo.modelo.pojos;
// Generated 24-abr-2017 11:46:00 by Hibernate Tools 4.3.5.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Previsiones generated by hbm2java
 */
public class Previsiones implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "idPrevision", unique= true, nullable = false)
	private Integer idPrevision;
	
	@OneToMany(targetEntity=Cuentas.class)
	@Column(name="idCuenta", nullable = false)
	private Cuentas cuentasByIdCuentaOrigen;
	
	@OneToMany(targetEntity=Cuentas.class)
	@Column(name="idCuenta", nullable = true)
	private Cuentas cuentasByIdCuentaDestino;
	
	@OneToMany(targetEntity=Etiquetas.class)
	@Column(name="idEtiqueta", nullable = false)
	private Etiquetas etiquetas;
	
	@OneToMany(targetEntity=Tipos.class)
	@Column(name="idTipo", nullable = true)
	private Tipos tipos;
	
	@Column(name="valor", nullable = false)
	private double valor;
	
	@Column(name="fecha", nullable = false)
	private Date fecha;
	
	@Column(name="descripcion", nullable = true)
	private String descripcion;

	public Previsiones() {
	}

	public Previsiones(Cuentas cuentasByIdCuentaOrigen, Etiquetas etiquetas, Tipos tipos, double valor, Date fecha) {
		this.cuentasByIdCuentaOrigen = cuentasByIdCuentaOrigen;
		this.etiquetas = etiquetas;
		this.tipos = tipos;
		this.valor = valor;
		this.fecha = fecha;
	}

	public Previsiones(Cuentas cuentasByIdCuentaOrigen, Cuentas cuentasByIdCuentaDestino, Etiquetas etiquetas,
			Tipos tipos, double valor, Date fecha, String descripcion) {
		this.cuentasByIdCuentaOrigen = cuentasByIdCuentaOrigen;
		this.cuentasByIdCuentaDestino = cuentasByIdCuentaDestino;
		this.etiquetas = etiquetas;
		this.tipos = tipos;
		this.valor = valor;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public Integer getIdPrevision() {
		return this.idPrevision;
	}

	public void setIdPrevision(Integer idPrevision) {
		this.idPrevision = idPrevision;
	}

	public Cuentas getCuentasByIdCuentaOrigen() {
		return this.cuentasByIdCuentaOrigen;
	}

	public void setCuentasByIdCuentaOrigen(Cuentas cuentasByIdCuentaOrigen) {
		this.cuentasByIdCuentaOrigen = cuentasByIdCuentaOrigen;
	}

	public Cuentas getCuentasByIdCuentaDestino() {
		return this.cuentasByIdCuentaDestino;
	}

	public void setCuentasByIdCuentaDestino(Cuentas cuentasByIdCuentaDestino) {
		this.cuentasByIdCuentaDestino = cuentasByIdCuentaDestino;
	}

	public Etiquetas getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(Etiquetas etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Tipos getTipos() {
		return this.tipos;
	}

	public void setTipos(Tipos tipos) {
		this.tipos = tipos;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}