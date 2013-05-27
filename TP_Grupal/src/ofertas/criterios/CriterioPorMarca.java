package ofertas.criterios;

import modelo.ProductosVendidos;

public class CriterioPorMarca implements Criterio {
	
	private String marca;
	private boolean incluyente;
	
	public CriterioPorMarca(){
		incluyente = true;
	}
	
	public CriterioPorMarca(String marca, boolean incluyente){
		this.marca = marca;
		this.incluyente = incluyente;
	}

	@Override
	public boolean aplicaSobre(ProductosVendidos producto) {
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
