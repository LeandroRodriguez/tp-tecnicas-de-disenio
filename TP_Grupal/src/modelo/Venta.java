package modelo;

import java.util.ArrayList;

import ofertas.OfertaPorUnidad;

public class Venta {

	private String medioDePago;
	private ArrayList<Producto> productos;
	private ArrayList<Descuento> beneficios;
	
	public Venta() {
		medioDePago = "";
		productos = new ArrayList<Producto>();
		beneficios = new ArrayList<Descuento>();
	}
	
	public void agregarProducto(Producto prod) {
		productos.add(prod);
	}

	public void setMedioDePago(String medio) {
		medioDePago = medio;
	}
	
	public String getMedioDePago() {
		return medioDePago;
	}

	// En algún momento este método tenía sentido y ahora no recuerdo por qué
	public void finalizarVenta() {
	}

	public float getTotal() {
		float total = 0;
		for (Producto prod : this.productos) {
			total += prod.getPrecio();
		}
		return total;
	}

	public float getTotalDescuentos() {
		float total = 0;
		for (Descuento bene : this.beneficios) {
			total += bene.getDescuento();
		}
		return total;
	}

	public void aplicarOferta(OfertaPorUnidad oferta) {
		// Algo tiene que devolver estas ofertas para poder calcular 
		// los descuentos posteriormente
		oferta.aplicarOfertas(this.productos);
	}

}
