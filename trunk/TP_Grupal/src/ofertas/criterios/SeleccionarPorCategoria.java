package ofertas.criterios;

import modelo.Producto;

public class SeleccionarPorCategoria implements Criterio {
	
	private String categoria;
	
	public SeleccionarPorCategoria(String categoria){
		this.categoria = categoria;
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
		return (producto.getCategoria().equals(categoria));
	}

}
