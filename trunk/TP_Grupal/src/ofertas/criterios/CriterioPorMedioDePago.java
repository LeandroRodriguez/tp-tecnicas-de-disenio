package ofertas.criterios;

import modelo.Venta;

public class CriterioPorMedioDePago implements CriterioVentaTotal {
	
	private String medioDePago;
	private boolean incluyente;
	
	public CriterioPorMedioDePago(){
		incluyente = true;
	}
	
	public CriterioPorMedioDePago(String medioDePago, boolean incluyente){
		this.medioDePago = medioDePago;
		this.incluyente = incluyente;
	}

	@Override
	public boolean aplicaSobre(Venta venta) {
		if (incluyente)
			return (venta.getMedioDePago().equals(medioDePago));
		else
			return (! venta.getMedioDePago().equals(medioDePago));
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
