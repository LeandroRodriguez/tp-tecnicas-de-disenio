package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;
import ofertas.criterios.Criterio;
import ofertas.criterios.SeleccionarPorCategoria;
import ofertas.criterios.SeleccionarPorDia;
import ofertas.criterios.SeleccionarPorMarca;

public class OfertaIndividual {
	
	private ArrayList<Criterio> criterios;
	private float valor;
	
	public OfertaIndividual(){
		this.criterios = new ArrayList<Criterio>();
		this.valor = 0;
	}
	
	/** Agrega una marca a la oferta. Pueden ser varias
	 * @param marca nombre de la marca del producto
	 */
	public void agregarMarca(String marca){
		criterios.add(new SeleccionarPorMarca(marca));
	}
	
	/** Agrega una categoria a la oferta
	 * @param categoria nombre de la categoria
	 */
	public void agregarCategoria(String categoria){
		criterios.add(new SeleccionarPorCategoria(categoria));
	}
	
	/** Establece el valor de la oferta, en porcentaje
	 * @param valor
	 */
	public void setValor(float valor){
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

	public void agregarDia(String dia) {
		criterios.add(new SeleccionarPorDia(dia));
	}

}
