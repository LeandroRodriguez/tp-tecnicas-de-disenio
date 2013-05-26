package ofertas;

import modelo.Descuento;
import modelo.Producto;

public class DescuentoPorProducto implements Descuento {
	
	private float valor;
	private Producto producto;

	public Producto getProducto() {
		return producto;
	}
	
	@Override
	public float getDescuento() {
		return valor;
	}
	
	public DescuentoPorProducto(Producto producto, float valor){
		this.producto = producto;
		this.valor = valor;
	}

}
