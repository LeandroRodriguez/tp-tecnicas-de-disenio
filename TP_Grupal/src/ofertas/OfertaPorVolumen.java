package ofertas;

import java.util.ArrayList;

import modelo.Producto;
import ofertas.criterios.Criterio;
import ofertas.criterios.SeleccionarPorCategoria;
import ofertas.criterios.SeleccionarPorDia;
import ofertas.criterios.SeleccionarPorMarca;
import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumen {
	
	private ArrayList<Criterio> criterios;
	private int cantidad;
	private int bonificacion;
	
	public OfertaPorVolumen(int cantidad, int bonificacion) throws ExcepcionCantidadInvalida{
		if (bonificacion >= cantidad) {
			throw new ExcepcionCantidadInvalida();
		}
		this.criterios = new ArrayList<Criterio>();
		this.cantidad = cantidad;
		this.bonificacion = bonificacion;
	}
	
	public void agregarMarca(String marca){
		criterios.add(new SeleccionarPorMarca(marca));
	}
	
	public void agregarCategoria(String categoria){
		criterios.add(new SeleccionarPorCategoria(categoria));
	}
	
	public void agregarDia(String dia){
		criterios.add(new SeleccionarPorDia(dia));
	}

	public void aplicarOfertas(ArrayList<Producto> productos) {
		ArrayList<Producto> productosDeLaMarca = new ArrayList<Producto>();
		int contados = 0;
		int bonificados = 0;
		for (Producto producto : productos) {
			for (Criterio criterio : criterios) {
				if (!criterio.aplicaSobre(producto)) {
					break;
				}
				// Todos los criterios aplican
				contados++;
				if (contados == cantidad) {
					bonificados += bonificacion;
					contados = 0;
				}
				productosDeLaMarca.add(producto);
			}
		}
		for (Producto producto : productosDeLaMarca) {
			producto.setPrecio(0);
			bonificados--;
			if (bonificados == 0)
				break;
		}
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
