package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;

public abstract class Oferta {

	public abstract List<Descuento> aplicarOfertas(ArrayList<Producto> productos);

	public abstract boolean encajaEnOferta(Producto producto);

}