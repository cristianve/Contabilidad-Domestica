package com.codo.modelo.pojos;
// Generated 24-abr-2017 11:46:00 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Monedas generated by hbm2java
 */
public class Monedas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idMoneda", unique = true, nullable = false)
	private Integer idMoneda;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@SuppressWarnings("rawtypes")
	private Set cuentases = new HashSet(0);

	public Monedas() {
	}

	public Monedas(String nombre) {
		this.nombre = nombre;
	}

	@SuppressWarnings("rawtypes")
	public Monedas(String nombre, Set cuentases) {
		this.nombre = nombre;
		this.cuentases = cuentases;
	}

	public Integer getIdMoneda() {
		return this.idMoneda;
	}

	public void setIdMoneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@SuppressWarnings("rawtypes")
	public Set getCuentases() {
		return this.cuentases;
	}

	@SuppressWarnings("rawtypes")
	public void setCuentases(Set cuentases) {
		this.cuentases = cuentases;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}