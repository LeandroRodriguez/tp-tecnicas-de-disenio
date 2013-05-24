package ofertas.criterios;

import java.util.Calendar;

import modelo.Producto;

public class SeleccionarPorDia implements Criterio {
	
	private int dia;
	
	public SeleccionarPorDia(String dia){
		if (dia.equals("domingo")) {
			this.dia = 1;
		} else if (dia.equals("lunes")) {
			this.dia = 2;
		} else if (dia.equals("martes")) {
			this.dia = 3;
		} else if (dia.equals("miercoles")) {
			this.dia = 4;
		} else if (dia.equals("jueves")) {
			this.dia = 5;
		} else if (dia.equals("viernes")) {
			this.dia = 6;
		} else {
			this.dia = 7;
		}
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		// If current day is Sunday, day=1
		if (this.dia == day){
			return true;
		} else 
			return false;
	}

}
