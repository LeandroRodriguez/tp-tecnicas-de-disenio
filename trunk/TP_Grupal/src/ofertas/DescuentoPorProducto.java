package ofertas;

import modelo.Descuento;
import modelo.ProductoVendido;

public class DescuentoPorProducto extends Descuento {
	
	private float valorPorcentual;
	private ProductoVendido productoVendido;

	public ProductoVendido getProducto() {
		return productoVendido;
	}
	
	@Override
	public float getDescuento() {
		return (float) ((valorPorcentual / 100.0) * productoVendido.getPrecioTotal());
	}
	
	public DescuentoPorProducto(ProductoVendido producto, float valorPorcentual){
		this.productoVendido = producto;
		this.valorPorcentual = valorPorcentual;
		producto.agregarDescuento(this);
	}
	
}
