package ofertas.criterios;


import modelo.ProductoVendido;

public class CriterioPorCategoria implements Criterio {
	
	private String categoria;
	private boolean incluyente;
	
	public CriterioPorCategoria(){
		
	}
	
	public CriterioPorCategoria(String categoria, boolean incluyente){
		this.categoria = categoria;
		this.incluyente = incluyente;
	}

	@Override
	public boolean aplicaSobre(ProductoVendido producto) {
		if (incluyente)
			return (producto.getCategoria().equals(categoria));
		else
			return (!producto.getCategoria().equals(categoria));
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
