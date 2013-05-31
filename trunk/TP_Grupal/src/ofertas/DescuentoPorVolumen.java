package ofertas;

import modelo.Descuento;
import modelo.ProductoVendido;

public class DescuentoPorVolumen extends Descuento {
	
	private float valor;
	private ProductoVendido productoVendido;

	public ProductoVendido getProducto() {
		return productoVendido;
	}
	
	@Override
	public float getDescuento() {
		return valor;
	}
	
	public DescuentoPorVolumen(ProductoVendido producto, float valor){
		this.productoVendido = producto;
		this.valor = valor;
		producto.agregarDescuento(this);
	}
}
