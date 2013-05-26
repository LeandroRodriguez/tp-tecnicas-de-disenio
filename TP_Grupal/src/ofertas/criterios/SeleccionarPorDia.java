package ofertas.criterios;

import modelo.Producto;

public class SeleccionarPorDia implements Criterio {
	
	private String dia;
	private Calendario calendario;
	
	public SeleccionarPorDia(String dia){
		this.dia = dia;
		calendario = new CalendarioDummy("Domingo");
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
		return (dia.equals(calendario.getDia()));
	}

}
