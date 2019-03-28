package com.codo.pruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
	
	private Interfaz vista;
	
	public Control (Interfaz vista){
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Interfaz.prueba)){
			
		}
	}

}
