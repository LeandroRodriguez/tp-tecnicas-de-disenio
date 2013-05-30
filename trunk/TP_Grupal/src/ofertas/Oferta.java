package ofertas;

import java.util.List;

import modelo.Descuento;
import modelo.ProductoVendido;
import modelo.Venta;

public interface Oferta {

	public List<Descuento> aplicarOferta(Venta venta);

	public boolean encajaEnOferta(ProductoVendido producto);

}