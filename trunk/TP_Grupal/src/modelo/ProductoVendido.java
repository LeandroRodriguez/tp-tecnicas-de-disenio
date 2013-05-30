package modelo;

import java.util.ArrayList;
import java.util.List;

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

	public double getPrecioTotal() {
		return producto.getPrecio() * cantidad;
	}

	public Producto getProducto() {
		return producto;
	}
	
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
}