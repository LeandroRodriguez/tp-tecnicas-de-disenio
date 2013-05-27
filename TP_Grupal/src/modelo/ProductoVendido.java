package modelo;

public class ProductoVendido implements ProductosVendidos {

	int cantidad;
	Producto producto;
	
	public ProductoVendido(Producto p) {
		producto = p;
		cantidad = 1;
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
	
	public void agregarUnidad(){
		cantidad += 1;
	}
	
	public boolean equals(ProductosVendidos otro) {
		if (otro instanceof ProductoVendido) {
			ProductoVendido o = (ProductoVendido) otro;
			if ( this.getCategoria().equals( o.getCategoria() ) &&
					this.getMarca().equals(o.getMarca()) &&
					producto.getNombre().equals( o.producto.getNombre() )) 
				return true;
	    }
		return false;
	}
}
