package ofertas;

import modelo.Descuento;
import modelo.Venta;

public class DescuentoPorVentaTotal extends Descuento {
	
	private float valor;
	private Venta venta;

	public Venta getVenta() {
		return venta;
	}
	
	@Override
	public float getDescuento() {
		return valor;
	}
	
	public DescuentoPorVentaTotal(Venta venta, float valor){
		this.venta = venta;
		this.valor = (float) (valor / 100.0 * venta.getTotalNeto());;
	}

}
