package ofertas;

import java.util.List;

import modelo.Descuento;
import modelo.Venta;

public interface OfertaDeProductos extends Oferta {
	
	public List<Descuento> aplicarOferta(Venta venta);

}
