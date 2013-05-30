package ofertas.criterios;

import modelo.Venta;

public interface CriterioVentaTotal {
	
	public abstract boolean aplicaSobre(Venta venta);
	
	public void setExcluyente();
	
	public void setIncluyente();

}
