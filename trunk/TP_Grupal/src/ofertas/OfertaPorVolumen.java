package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.Producto;
import ofertas.criterios.Criterio;
import ofertas.criterios.ListaDeCriterios;
import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumen extends Oferta {
	
	private ListaDeCriterios criterios;
	private int cantidad;
	private int bonificacion;
	
	/**
	 * @param cantidad El total de productos que es necesario comprar
	 * @param bonificacion Cuantos productos seran gratis
	 * @throws ExcepcionCantidadInvalida
	 */
	public OfertaPorVolumen(int cantidad, int bonificacion) throws ExcepcionCantidadInvalida{
		if (bonificacion >= cantidad) {
			throw new ExcepcionCantidadInvalida();
		}
		this.criterios = new ListaDeCriterios();
		this.cantidad = cantidad;
		this.bonificacion = bonificacion;
	}
	
	public void cumplirTodosLosCriterios(){
		criterios.cumplirTodo();
	}
	
	public void cumplirAlgunCriterio(){
		criterios.cumplirAlguno();
	}
	
	public void agregarCriterio(Criterio criterio) {
		this.criterios.agregarCriterio(criterio);
	}

	public List<Descuento> aplicarOfertas(ArrayList<Producto> productos) {
		ArrayList<Producto> productosCoincidentes = new ArrayList<Producto>();
		int contados = 0;
		int bonificados = 0;
		for (Producto producto : productos) {
			if (criterios.aplica(producto)) {
				contados++;
				if (contados == cantidad) {
					bonificados += bonificacion;
					contados = 0;
				}
				productosCoincidentes.add(producto);
			}
		}
		for (Producto producto : productosCoincidentes) {
			producto.setPrecio(0);
			bonificados--;
			if (bonificados == 0)
				break;
		}
		
		//TODO guardar descuentos
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		return descuentos;
	}

	public boolean encajaEnOferta(Producto producto) {
		return (criterios.aplica(producto));
	}

}
