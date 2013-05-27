package ofertas.criterios;

import modelo.Producto;

public interface Criterio {
	
	public boolean aplicaSobre(Producto producto);
	
	public void setExcluyente();
	
	public void setIncluyente();

}
