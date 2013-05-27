package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.ProductosVendidos;

public abstract class Oferta {

	public abstract List<Descuento> aplicarOferta(ArrayList<ProductosVendidos> productos);

	public abstract boolean encajaEnOferta(ProductosVendidos producto);

}