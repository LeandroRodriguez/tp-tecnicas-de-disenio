package ofertas.criterios;

import modelo.Producto;

public class CriterioPorDia implements Criterio {
	
	private String dia;
	private Calendario calendario;
	private boolean incluyente;
	
	public CriterioPorDia(String dia, boolean incluyente){
		this.dia = dia;
		calendario = new CalendarioDia();
		this.incluyente = true;
	}
	
	public CriterioPorDia(String dia, boolean incluyente, String diaDummy){
		this.dia = dia;
		calendario = new CalendarioDummy(diaDummy);
		this.incluyente = true;
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
		if (incluyente)
			return (dia.equals(calendario.getDiaCorriente()));
		else
			return (!dia.equals(calendario.getDiaCorriente()));
	}

	@Override
	public void setExcluyente() {
		incluyente = false;
	}

	@Override
	public void setIncluyente() {
		incluyente = true;
	}

}
