package tests;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;
import ofertas.Oferta;

public class OfertaDummy implements Oferta {
	
	private boolean valor;
	
	public OfertaDummy(boolean valor){
		this.valor = valor;
	}

	@Override
	public List<Descuento> aplicarOfertas(ArrayList<Producto> productos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean encajaEnOferta(Producto producto) {
		return valor;
	}

}
