package com.codo.vista.componentes;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.codo.modelo.pojos.Previsiones;

public class ModeloTablaPrevisiones extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnas = { "Cuenta de Origen", "Cuenta de Destino", "Tipo", "Etiqueta", "Valor", "Fecha",
			"Descripción" };
	private List<Previsiones> listaDePrevisiones = null;

	public ModeloTablaPrevisiones() {
		this.setColumnIdentifiers(columnas);
	}

	public void asignarListaDeCuentas(List<Previsiones> listaDePrevisiones) {
		this.listaDePrevisiones = listaDePrevisiones;
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
		if (listaDePrevisiones != null) {
			return listaDePrevisiones.size();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int indiceDeFila, int indiceDeColumna) {
		if (indiceDeFila <= getRowCount()) {
			Previsiones prevision = listaDePrevisiones.get(indiceDeFila);
			if (prevision != null) {
				switch (indiceDeColumna) {
				case 0:
					return prevision.getCuentasByIdCuentaOrigen();
				case 1:
					return prevision.getCuentasByIdCuentaDestino();
				case 2:
					return prevision.getTipos();
				case 3:
					return prevision.getEtiquetas();
				case 4:
					return prevision.getValor();
				case 5:
					return prevision.getFecha();
				case 6:
					return prevision.getDescripcion();
				}
			}
		}
		return null;
	}

	public Previsiones obtenerObjeto(int indiceDeFila) {
		if (indiceDeFila != -1) {
			if (indiceDeFila <= getRowCount()) {
				Previsiones prevision = listaDePrevisiones.get(indiceDeFila);
				if (prevision != null) {
					return prevision;
				}
			}
		}
		return null;
	}
}
