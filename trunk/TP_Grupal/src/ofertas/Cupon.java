package ofertas;

import java.util.List;

import modelo.Descuento;
import modelo.Venta;

public class Cupon {
	
	private Oferta oferta;
	private double limite;
	
	public double getLimite() {
		return limite;
	}

	public Cupon(double limite, Oferta oferta){
		this.limite = limite;
		this.oferta = oferta;
	}
	
	public Descuento aplicarDescuento(Venta venta){
		List<Descuento> descuentos = oferta.aplicarOferta(venta);
		double suma = 0;
		for (Descuento descuento: descuentos){
			suma += descuento.getDescuento();
		}
		double limite = this.limite * venta.getTotalNeto(); 
		Descuento descuento = new DescuentoPorVentaTotal(venta, (float) Math.min(limite, suma));
		return descuento;
	}

	public Descuento getDescuento() {
		// TODO Auto-generated method stub
		return null;
	}

}
