package ofertas;

import modelo.Descuento;
import modelo.ProductoVendido;

public class DescuentoPorVolumen extends Descuento {
	
	private float valorPorcentual;
	private ProductoVendido productoVendido;

	public ProductoVendido getProducto() {
		return productoVendido;
	}
	
	@Override
	public float getDescuento() {
		return valorPorcentual;
	}
	
	public DescuentoPorVolumen(ProductoVendido producto, float valorPorcentual){
		this.productoVendido = producto;
		this.valorPorcentual = valorPorcentual;
		producto.agregarDescuento(this);
	}
}
