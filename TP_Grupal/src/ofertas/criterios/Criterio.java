package ofertas.criterios;

import modelo.ProductoVendido;

public interface Criterio {
	
	public abstract boolean aplicaSobre(ProductoVendido producto);
	
	public void setExcluyente();
	
	public void setIncluyente();

}
