package ofertas;

import java.util.ArrayList;

import productos.Producto;

public class OfertaMarca implements Oferta {

	private String marca;
	private float descuento;
	
	public OfertaMarca(String marca, float descuento){
		this.marca = marca;
		this.descuento = descuento;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public boolean encajaEnOferta(Producto producto) {
		return (producto.getMarca().equals(marca));
	}

	public void aplicarOfertas(ArrayList<Producto> productos) {
		for (Producto producto : productos)
		if (encajaEnOferta(producto)){
			producto.setPrecio(producto.getPrecio()*((double)(100-descuento)/100.0));
		}
	}
	
}
