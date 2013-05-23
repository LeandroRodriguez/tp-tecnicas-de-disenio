package ofertas;

import java.util.ArrayList;

import excepciones.ExcepcionCantidadInvalida;

import modelo.Producto;

public class OfertaPorVolumenYMarca implements Oferta {
	
	private String marca;
	private int cantidad;
	private int bonificacion;
	
	/**
	 * @param marca Marca del producto
	 * @param cantidad Cuantos productos llevar para acceder al descuento
	 * @param bonificacion Cuantos de esos productos llevas gratis (< volumen)
	 * @throws ExcepcionCantidadInvalida 
	 */
	public OfertaPorVolumenYMarca(String marca, int cantidad, int bonificacion) throws ExcepcionCantidadInvalida{
		if (bonificacion >= cantidad) {
			throw new ExcepcionCantidadInvalida();
		}
		this.marca = marca;
		this.cantidad = cantidad;
		this.bonificacion = bonificacion;
	}

	@Override
	public void aplicarOfertas(ArrayList<Producto> productos) {
		ArrayList<Producto> productosDeLaMarca = new ArrayList<Producto>();
		int contados = 0;
		int bonificados = 0;
		for (Producto producto : productos){
			if (producto.getMarca().equals(marca)) {
				contados++;
				if (contados == cantidad) {
					bonificados+=bonificacion;
					contados=0;
				}
				productosDeLaMarca.add(producto);
			}
		}
		for (Producto producto : productosDeLaMarca){
			producto.setPrecio(0);
			bonificados--;
			if (bonificados==0) break;
		}
	}

	@Override
	public boolean encajaEnOferta(Producto producto) {
		return (producto.getMarca().equals(marca));
	}

}
