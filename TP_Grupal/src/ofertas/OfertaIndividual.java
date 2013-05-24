package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;

public class OfertaIndividual implements Oferta {
	
	private ArrayList<Oferta> ofertas;
	private float valor;
	
	public OfertaIndividual(ArrayList<Oferta> ofertas, float valor){
		this.ofertas = ofertas;
		this.valor = valor;
	}

	@Override
	public List<Descuento> aplicarOfertas(ArrayList<Producto> productos) {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		for (Producto producto : productos) {
			if (encajaEnOferta(producto)){
				descuentos.add(new DescuentoPorProducto(producto,valor));
			}
		}
		return descuentos;
	}

	@Override
	public boolean encajaEnOferta(Producto producto) {
		for (Oferta oferta : ofertas) {
			if (!oferta.encajaEnOferta(producto)) {
				return false;
			}
		}
		return true;
	}

}
