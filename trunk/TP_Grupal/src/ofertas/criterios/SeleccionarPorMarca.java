package ofertas.criterios;

import modelo.Producto;

public class SeleccionarPorMarca implements Criterio {
	
	private String marca;
	private boolean incluyente;
	
	public SeleccionarPorMarca(){
		incluyente = true;
	}
	
	public SeleccionarPorMarca(String marca, boolean incluyente){
		this.marca = marca;
		this.incluyente = incluyente;
	}

	@Override
	public boolean aplicaSobre(Producto producto) {
		if (incluyente)
			return (producto.getMarca().equals(marca));
		else
			return (! producto.getMarca().equals(marca));
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
