package ofertas;

import modelo.Descuento;
import modelo.ProductosVendidos;

public class DescuentoPorProducto implements Descuento {
	
	private float valor;
	private ProductosVendidos productoVendido;

	public ProductosVendidos getProducto() {
		return productoVendido;
	}
	
	@Override
	public float getDescuento() {
		return valor;
	}
	
	public DescuentoPorProducto(ProductosVendidos producto, float valor){
		this.productoVendido = producto;
		this.valor = valor;
	}

}
