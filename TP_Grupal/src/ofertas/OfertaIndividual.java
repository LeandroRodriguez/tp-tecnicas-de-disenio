package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;
import ofertas.criterios.Criterio;

public class OfertaIndividual {
	
	private ArrayList<Criterio> criterios;
	private float valor;
	
	public OfertaIndividual(Criterio criterio, float valor){
		this.criterios = new ArrayList<Criterio>();
		criterios.add( criterio);
		this.valor = valor;
	}
	
	public OfertaIndividual(ArrayList<Criterio> criterios, float valor){
		this.criterios = criterios;
		this.valor = valor;
	}

	public List<Descuento> aplicarOfertas(ArrayList<Producto> productos) {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		for (Producto producto : productos) {
			if (encajaEnOferta(producto)){
				descuentos.add(new DescuentoPorProducto(producto,valor));
			}
		}
		return descuentos;
	}

	public boolean encajaEnOferta(Producto producto) {
		for (Criterio criterio : criterios) {
			if (!criterio.aplicaSobre(producto)) {
				return false;
			}
		}
		return true;
	}

}
