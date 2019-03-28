package com.codo.pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		//Interfaz vista = new ClaseHijo ();
		//Control control = new Control (vista);
		//vista.iniciar();
		

		//GregorianCalendar.getInstance().roll();
		//System.out.println(loquesea);
		
		Calendar c = GregorianCalendar.getInstance();
		c.set(2017, 0, 31);
		System.out.println(c.getTime().toString());
		c.roll(Calendar.MONTH, 1);
		System.out.println(c.getTime().toString());
		c.roll(Calendar.MONTH, 1);
		System.out.println(c.getTime().toString());
	}
}
