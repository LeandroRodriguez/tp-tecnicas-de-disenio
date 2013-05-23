package ofertas;

import modelo.Producto;

public class ProductoDummy implements Producto {
	
	private String marca, categoria; 
	private double precio;
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public ProductoDummy(String marca, String categoria){
		this.marca = marca;
		this.categoria = categoria;
	}

	@Override
	public String getMarca() {
		return marca;
	}

	@Override
	public String getCategoria() {
		return categoria;
	}

}
