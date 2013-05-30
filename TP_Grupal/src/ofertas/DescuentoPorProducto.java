package ofertas;

import modelo.Descuento;
import modelo.ProductoVendido;

public class DescuentoPorProducto implements Descuento {
	
	private float valor;
	private ProductoVendido productoVendido;

	public ProductoVendido getProducto() {
		return productoVendido;
	}
	
	@Override
	public float getDescuento() {
		return valor;
	}
	
	public DescuentoPorProducto(ProductoVendido producto, float valor){
		this.productoVendido = producto;
		this.valor = valor;
	}

}
