package modelo;

public interface ProductosVendidos {
	
	public String getMarca();
	public String getCategoria();
	public double getPrecioTotal();
	public int getCantidadDeProductos();
	public Producto getProducto();
	public boolean equals(ProductosVendidos otro);
	public void agregarUnidades(int cantidad);
}
