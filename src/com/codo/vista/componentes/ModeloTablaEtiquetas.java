package com.codo.vista.componentes;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.codo.modelo.pojos.Etiquetas;

public class ModeloTablaEtiquetas extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnas = { "Tipo", "Etiqueta" };
	private List<Etiquetas> listaDeEtiquetas = null;

	public ModeloTablaEtiquetas() {
		this.setColumnIdentifiers(columnas);
	}

	public void asignarListaDeCuentas(List<Etiquetas> listaDeEtiquetas) {
		this.listaDeEtiquetas = listaDeEtiquetas;
	}

	public String[] getColumnNames() {
		return columnas;
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		if (listaDeEtiquetas != null) {
			return listaDeEtiquetas.size();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int indiceDeFila, int indiceDeColumna) {
		if (indiceDeFila <= getRowCount()) {
			Etiquetas etiqueta = listaDeEtiquetas.get(indiceDeFila);
			if (etiqueta != null) {
				switch (indiceDeColumna) {
				case 0:
					return etiqueta.getTipos();
				case 1:
					return etiqueta.getNombre();
				}
			}
		}
		return null;
	}

	public Etiquetas obtenerObjeto(int indiceDeFila) {
		if (indiceDeFila != -1) {
			if (indiceDeFila <= getRowCount()) {
				Etiquetas etiqueta = listaDeEtiquetas.get(indiceDeFila);
				if (etiqueta != null) {
					return etiqueta;
				}
			}
		}
		return null;
	}
}
