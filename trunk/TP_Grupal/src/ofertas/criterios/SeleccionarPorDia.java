package ofertas.criterios;

import modelo.Producto;

public class SeleccionarPorDia implements Criterio {
	
	private String dia;
	private Calendario calendario;
	
	public SeleccionarPorDia(String dia){
		this.dia = dia;
		calendario = new CalendarioDia();
	}
	
	public SeleccionarPorDia(String dia, String diaDummy){
		this.dia = dia;
		calendario = new CalendarioDummy(diaDummy);
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
		return (dia.equals(calendario.getDiaCorriente()));
	}

}
