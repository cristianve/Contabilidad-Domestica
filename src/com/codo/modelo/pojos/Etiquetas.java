package com.codo.modelo.pojos;
// Generated 24-abr-2017 11:46:00 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Etiquetas generated by hbm2java
 */
public class Etiquetas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idEtiqueta", unique = true, nullable = false)
	private Integer idEtiqueta;

	@OneToMany(targetEntity = Tipos.class)
	@Column(name = "idTipo", nullable = true)
	private Tipos tipos;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@SuppressWarnings("rawtypes")
	private Set previsioneses = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set movimientoses = new HashSet(0);

	public Etiquetas() {
	}

	public Etiquetas(Tipos tipo, String nombre) {
		this.tipos = tipo;
		this.nombre = nombre;
	}

	@SuppressWarnings("rawtypes")
	public Etiquetas(Tipos tipos, String nombre, Set previsioneses, Set movimientoses) {
		this.tipos = tipos;
		this.nombre = nombre;
		this.previsioneses = previsioneses;
		this.movimientoses = movimientoses;
	}

	public Integer getIdEtiqueta() {
		return this.idEtiqueta;
	}

	public void setIdEtiqueta(Integer idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public Tipos getTipos() {
		return this.tipos;
	}

	public void setTipos(Tipos tipos) {
		this.tipos = tipos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@SuppressWarnings("rawtypes")
	public Set getPrevisioneses() {
		return this.previsioneses;
	}

	@SuppressWarnings("rawtypes")
	public void setPrevisioneses(Set previsioneses) {
		this.previsioneses = previsioneses;
	}

	@SuppressWarnings("rawtypes")
	public Set getMovimientoses() {
		return this.movimientoses;
	}

	@SuppressWarnings("rawtypes")
	public void setMovimientoses(Set movimientoses) {
		this.movimientoses = movimientoses;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}