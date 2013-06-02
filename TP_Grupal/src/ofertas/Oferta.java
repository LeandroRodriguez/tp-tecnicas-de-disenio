package ofertas;

import java.util.List;

import modelo.Descuento;
import modelo.ProductoVendido;
import modelo.Venta;

public interface Oferta {

	public List<Descuento> aplicarOferta(Venta venta);

	public boolean encajaEnOferta(ProductoVendido producto);

	/** Devuelve True si el descuento es del tipo de descuento
	 * que genera esta oferta. Este metodo es utilizado cuando
	 * se quiere conocer si un tipo de oferta ya fue aplicado
	 * a una venta.
	 * @param descuento
	 * @return
	 */
	public boolean esDescuentoPosible(Descuento descuento);

}