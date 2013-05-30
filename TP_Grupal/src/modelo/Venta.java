package modelo;

import java.util.ArrayList;
import java.util.List;

import ofertas.Oferta;

public class Venta {

	private String medioDePago;
	private ArrayList<ProductoVendido> productos;
	private List<Descuento> beneficios;
	
	public Venta() {
		medioDePago = "";
		productos = new ArrayList<ProductoVendido>();
		beneficios = new ArrayList<Descuento>();
	}
	
	/* Si ya lo tiene, modifica la cantidad. Caso contrario lo agrega. */
	public void agregarProducto(Producto prod, int cantidad) {
		ProductoVendido nuevo = new ProductoVendido(prod, cantidad);
		for (ProductoVendido vendido : this.productos){
			if ( vendido.equals(nuevo) ) {
				vendido.agregarUnidades(cantidad);
				return;
			}
		}
		productos.add(nuevo);
	}
	
	public List<ProductoVendido> getProductosVendidos() {
		return productos;
	}

	public void setMedioDePago(String medio) {
		medioDePago = medio;
	}
	
	public String getMedioDePago() {
		return medioDePago;
	}

	public float getTotal() {
		float total = 0;
		for (ProductoVendido prod : this.productos) {
			total += prod.getPrecioTotal();
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
	
	public double getTotalNeto() {
		return getTotal() - getTotalDescuentos();
	}

	public void aplicarOferta(Oferta oferta) {
		// Algo tiene que devolver estas ofertas para poder calcular 
		// los descuentos posteriormente
		agregarDescuentos( oferta.aplicarOferta(this) );
	}
	
	private void agregarDescuentos(List<Descuento> descuentosNuevos) {
		for(Descuento nuevo : descuentosNuevos)
			this.beneficios.add(nuevo);
	}

}
