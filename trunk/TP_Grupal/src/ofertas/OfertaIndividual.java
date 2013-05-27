package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;
import ofertas.criterios.Criterio;
import ofertas.criterios.ListaDeCriterios;
import ofertas.criterios.SeleccionarPorCategoria;
import ofertas.criterios.SeleccionarPorDia;
import ofertas.criterios.SeleccionarPorMarca;

public class OfertaIndividual{
	
	private ListaDeCriterios criterios;
	
	private float valor;

	/**
	 * Oferta que se aplica sobre un solo producto, ejemplo: 10 % de descuento en almacen.
	 */
	public OfertaIndividual(){
		this.criterios = new ListaDeCriterios();
		this.valor = 0;
	}
	
	public boolean equals(OfertaIndividual oferta){
		boolean comp = (this.valor == oferta.valor);
		if (!comp) return false;
		comp = (this.criterios.equals(oferta.criterios));
		if (!comp) return false;
		return true;
	}
	
	/** Agrega una categoria a la oferta
	 * @param categoria nombre de la categoria
	 */
	
	public void agregarCategoria(String categoria, boolean incluyente){
		criterios.agregarCriterio(new SeleccionarPorCategoria(categoria, incluyente));
	}
	
	public void agregarDia(String dia, boolean incluyente) {
		criterios.agregarCriterio(new SeleccionarPorDia(dia, incluyente));
	}
	
	/** Agrega una marca a la oferta. Pueden ser varias
	 * @param marca nombre de la marca del producto
	 */
	public void agregarMarca(String marca, boolean incluyente){
		criterios.agregarCriterio(new SeleccionarPorMarca(marca, incluyente));
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
		return (criterios.aplica(producto));
	}
	
	public ArrayList<Criterio> getCriterios() {
		return criterios.getLista();
	}

	public float getValor() {
		return valor;
	}

	public void setCriterios(ArrayList<Criterio> criterios) {
		this.criterios.setLista(criterios);
	}

	/** Establece el valor de la oferta, en porcentaje
	 * @param valor
	 */
	public void setValor(float valor){
		this.valor = valor;
	}

	public void cumplirTodosLosCriterios() {
		criterios.cumplirTodo();
	}

}
