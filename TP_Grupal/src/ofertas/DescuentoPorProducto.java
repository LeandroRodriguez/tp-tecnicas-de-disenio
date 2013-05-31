package ofertas;

import modelo.Descuento;
import modelo.ProductoVendido;

public class DescuentoPorProducto extends Descuento {
	
	private float valor;
	private ProductoVendido productoVendido;

	public ProductoVendido getProducto() {
		return productoVendido;
	}
	
	@Override
	public float getDescuento() {
		return valor;
	}
	
	public DescuentoPorProducto(ProductoVendido producto, float valorPorcentual){
		this.productoVendido = producto;
		this.valor = (float) ((valorPorcentual / 100.0) * productoVendido.getPrecioTotal());
		producto.agregarDescuento(this);
	}
	
}
