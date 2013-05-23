package ofertas;

import java.util.ArrayList;

import modelo.Producto;


public interface Oferta {
	public void aplicarOfertas(ArrayList<Producto> productos);
	public boolean encajaEnOferta(Producto producto);
}
