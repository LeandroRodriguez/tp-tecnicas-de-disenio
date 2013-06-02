package modelo;

import java.util.ArrayList;
import java.util.List;

import ofertas.Oferta;

public class ProductoVendido {

	int cantidad;
	Producto producto;
	List<Descuento> descuentosAplicados;
	
	public List<Descuento> getDescuentosAplicados() {
		return descuentosAplicados;
	}

	public ProductoVendido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		descuentosAplicados = new ArrayList<Descuento>();
	}
	
	public ProductoVendido(Producto producto) {
		this(producto, 1);
	}

	public int getCantidadDeProductos() {
		return cantidad;
	}

	public String getCategoria() {
		return producto.getCategoria();
	}

	public String getMarca() {
		return producto.getMarca();
	}

	public double getPrecioTotalBruto() {
		return producto.getPrecio() * cantidad;
	}

	public double getDescuentos() {
		double total = 0;
		for (Descuento descuento : this.descuentosAplicados) {
			total += descuento.getDescuento();
		}
		return total;
	}
	
	public double getPrecioTotal() {
		return getPrecioTotalBruto() - getDescuentos();
	}
	
	public Producto getProducto() {
		return producto;
	}
	/*
	public double getPrecioNeto() {
		double bruto = getPrecioTotal();
		double totalDescuentos = 0;
		for( Descuento descuento : this.descuentosAplicados) 
			totalDescuentos += descuento.getDescuento();
		return bruto - totalDescuentos;
	}
	*/
	public boolean equals(ProductoVendido otro) {
		// El método se define para poder ser comparado con elementos de cualquier otra clase
		if (otro instanceof ProductoVendido) { 
			if ( this.getCategoria().equals( otro.getCategoria() ) &&
					this.getMarca().equals(otro.getMarca()) &&
					producto.getNombre().equals( otro.getProducto().getNombre() )) 
				return true;
		}
		return false;
	}

	public void agregarUnidades(int cantidad) {
		this.cantidad += cantidad;
	}
	
	public void agregarDescuento(Descuento descuento) {
		this.descuentosAplicados.add(descuento);
	}
	
	/** Devuelve True si el producto vendido ya tuvo una oferta del mismo tipo.
	 * @param oferta
	 * @return
	 */
	public boolean seAplicoOfertaSimilar(Oferta oferta){
		for (Descuento descuento: descuentosAplicados){
			if (oferta.esDescuentoPosible(descuento)){
				return true;
			}
		}
		return false;
	}
}
