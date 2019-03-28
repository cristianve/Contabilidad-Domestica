package com.codo.vista.componentes;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.codo.modelo.pojos.Movimientos;

public class ModeloTablaMovimientos extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnas = { "Cuenta de Origen", "Cuenta de Destino", "Tipo", "Etiqueta", "Valor", "Fecha",
			"Descripción" };
	private List<Movimientos> listaDeMovimientos = null;

	public ModeloTablaMovimientos() {
		this.setColumnIdentifiers(columnas);
	}

	public void asignarListaDeCuentas(List<Movimientos> listaDeMovimientos) {
		this.listaDeMovimientos = listaDeMovimientos;
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
		if (listaDeMovimientos != null) {
			return listaDeMovimientos.size();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int indiceDeFila, int indiceDeColumna) {
		if (indiceDeFila <= getRowCount()) {
			Movimientos movimiento = listaDeMovimientos.get(indiceDeFila);
			if (movimiento != null) {
				switch (indiceDeColumna) {
				case 0:
					return movimiento.getCuentasByIdCuentaOrigen();
				case 1:
					return movimiento.getCuentasByIdCuentaDestino();
				case 2:
					return movimiento.getTipos();
				case 3:
					return movimiento.getEtiquetas();
				case 4:
					return movimiento.getValor() + " "
							+ movimiento.getCuentasByIdCuentaOrigen().getMonedas().getNombre();
				case 5:
					return movimiento.getFecha();
				case 6:
					return movimiento.getDescripcion();
				}
			}
		}
		return null;
	}

	public Movimientos obtenerObjeto(int indiceDeFila) {
		if (indiceDeFila != -1) {
			if (indiceDeFila <= getRowCount()) {
				Movimientos movimiento = listaDeMovimientos.get(indiceDeFila);
				if (movimiento != null) {
					return movimiento;
				}
			}
		}
		return null;
	}
}
