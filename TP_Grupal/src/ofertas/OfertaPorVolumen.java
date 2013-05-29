package ofertas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Descuento;
import modelo.Producto;
import modelo.ProductosVendidos;
import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumen extends Oferta {
	
	Map<Producto, Integer> cantidadesPorProducto;
	Map<Producto, Float> bonificacionesPorProducto;
	
	/**
	 * @param cantidad El total de productos que es necesario comprar
	 * @param bonificacion Cuantos productos seran gratis
	 * @throws ExcepcionCantidadInvalida
	 */
	public OfertaPorVolumen() {
		
		this.cantidadesPorProducto = new HashMap<Producto, Integer>();
		this.bonificacionesPorProducto = new HashMap<Producto, Float>();
	}
	
	public void addProducto(Producto producto, int cantidad, float bonificacion) throws ExcepcionCantidadInvalida {
		if (bonificacion > cantidad) {
			throw new ExcepcionCantidadInvalida();
		}
		cantidadesPorProducto.put(producto, cantidad);
		bonificacionesPorProducto.put(producto, bonificacion);
	}
	
	public int getBonificacionesPosibles(ProductosVendidos productosVendidos) {
		return productosVendidos.getCantidadDeProductos() / cantidadesPorProducto.get(productosVendidos.getProducto());
	}
	
	public float getValorDescuento() {
		float valor = 0;
		for(Producto producto: cantidadesPorProducto.keySet()) {
			valor += bonificacionesPorProducto.get(producto) * producto.getPrecio();
		}
		return valor;
	}

	public List<Descuento> aplicarOferta(ArrayList<ProductosVendidos> productos) {
		int bonificacionesAplicables = -1; 
		for(ProductosVendidos productosVendidos: productos) {
			if(cantidadesPorProducto.containsKey(productosVendidos.getProducto())) {
				int bonificacionesPosibles = getBonificacionesPosibles(productosVendidos);
				if(bonificacionesAplicables == -1)
					bonificacionesAplicables = bonificacionesPosibles;
				else
					bonificacionesAplicables = Math.min(bonificacionesAplicables, bonificacionesPosibles);
			}
		}
		List<Descuento> descuentos = new ArrayList<Descuento>();
		if(bonificacionesAplicables <= 0)
			return descuentos;
		descuentos.add(new DescuentoPorVolumen(getValorDescuento() * bonificacionesAplicables));
		return descuentos;
	}

	public boolean encajaEnOferta(ProductosVendidos producto) {
		return cantidadesPorProducto.containsKey(producto.getProducto());
	}

}
