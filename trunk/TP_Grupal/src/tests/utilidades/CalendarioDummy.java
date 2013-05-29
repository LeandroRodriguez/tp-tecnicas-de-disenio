package tests.utilidades;

import ofertas.criterios.Calendario;

public class CalendarioDummy implements Calendario {
	
	private String dia;
	
	public CalendarioDummy(String dia){
		this.dia = dia;
	}

	@Override
	public String getDiaCorriente() {
		return dia;
	}
	

}
