package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;


public interface Oferta {
	public List<Descuento> aplicarOfertas(ArrayList<Producto> productos);
	public boolean encajaEnOferta(Producto producto);
}
