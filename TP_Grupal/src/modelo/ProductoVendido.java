package modelo;

public class ProductoVendido implements ProductosVendidos {

	int cantidad;
	Producto producto;
	
	public ProductoVendido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
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
	
	public void agregarUnidad(){
		cantidad += 1;
	}
	
	public boolean equals(ProductosVendidos otro) {
		
		if ( this.getCategoria().equals( otro.getCategoria() ) &&
				this.getMarca().equals(otro.getMarca()) &&
				producto.getNombre().equals( otro.getProducto().getNombre() )) 
			return true;
	    return false;
	}
}