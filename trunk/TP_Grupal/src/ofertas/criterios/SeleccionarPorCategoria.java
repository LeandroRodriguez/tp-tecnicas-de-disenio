package ofertas.criterios;

import modelo.Producto;

public class SeleccionarPorCategoria implements Criterio {
	
	private String categoria;
	private boolean incluyente;
	
	public SeleccionarPorCategoria(){
		
	}
	
	public SeleccionarPorCategoria(String categoria, boolean incluyente){
		this.categoria = categoria;
		this.incluyente = incluyente;
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
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
