package ofertas;

import java.util.List;

import modelo.Descuento;
import modelo.ProductoVendido;
import modelo.Venta;

public abstract class Oferta {

	public abstract List<Descuento> aplicarOferta(Venta venta);

	public abstract boolean encajaEnOferta(ProductoVendido producto);

}