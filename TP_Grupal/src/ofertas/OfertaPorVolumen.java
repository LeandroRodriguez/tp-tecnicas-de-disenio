package ofertas;

import java.util.ArrayList;

import modelo.Producto;
import ofertas.criterios.Criterio;
import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumen {
	
	private ArrayList<Criterio> criterios;
	private int cantidad;
	private int bonificacion;
	
	public OfertaPorVolumen(ArrayList<Criterio> criterios, int cantidad, int bonificacion) throws ExcepcionCantidadInvalida{
		if (bonificacion >= cantidad) {
			throw new ExcepcionCantidadInvalida();
		}
		this.criterios = criterios;
		this.cantidad = cantidad;
		this.bonificacion = bonificacion;
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
