package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.ProductoVendido;

public abstract class Oferta {

	public abstract List<Descuento> aplicarOferta(ArrayList<ProductoVendido> productos);

	public abstract boolean encajaEnOferta(ProductoVendido producto);

}