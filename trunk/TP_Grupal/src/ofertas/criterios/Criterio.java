package ofertas.criterios;

import modelo.ProductosVendidos;

public interface Criterio {
	
	public abstract boolean aplicaSobre(ProductosVendidos producto);
	
	public void setExcluyente();
	
	public void setIncluyente();

}
