package ofertas.criterios;

import modelo.Producto;

public class SeleccionarPorMarca implements Criterio {
	
	private String marca;
	
	public SeleccionarPorMarca(String marca){
		this.marca = marca;
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
		return (producto.getMarca().equals(marca));
	}

}
