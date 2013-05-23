package modelo;

import java.util.HashSet;
import java.util.Set;

public class GrupoDeProductos {
	
	private Set<Producto> productos;

	public GrupoDeProductos() {
		super();
		productos = new HashSet<Producto>();
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
	
	public boolean contieneProducto(Producto producto) {
		return productos.contains(producto);
	}

}
