package ofertas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modelo.Descuento;
import modelo.Producto;
import modelo.ProductosVendidos;
import ofertas.criterios.Criterio;
import ofertas.criterios.ListaDeCriterios;
import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumen extends Oferta {
	
	private ListaDeCriterios criterios;
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
		this.criterios = new ListaDeCriterios();
	}
	
	public void addProducto(Producto producto, int cantidad, float bonificacion) throws ExcepcionCantidadInvalida {
		if (bonificacion > cantidad) {
			throw new ExcepcionCantidadInvalida();
		}
		cantidadesPorProducto.put(producto, cantidad);
		bonificacionesPorProducto.put(producto, bonificacion);
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

	public List<Descuento> aplicarOferta(ArrayList<ProductosVendidos> productos) {
		Map<Producto, Integer> cantidadBonificacionesPosibles = new HashMap<Producto, Integer>();
		for(ProductosVendidos productosVendidos: productos) {
			// TODO
		}
		/*ArrayList<ProductosVendidos> productosCoincidentes = new ArrayList<ProductosVendidos>();
		int contados = 0;
		int bonificados = 0;*/
		/*int bonificaciones = 0;
		
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		for(ProductosVendidos productosVendidos: productos) {
			if(encajaEnOferta(productosVendidos)) {
				bonificaciones = (int) productosVendidos.getCantidadDeProductos() / cantidad;
				float valorDescuento = (float) productosVendidos.getProducto().getPrecio() * bonificaciones * bonificacion;
				DescuentoPorProducto descuento = new DescuentoPorProducto(productosVendidos, valorDescuento);
				descuentos.add(descuento);
			}
		}*/
		/*for (ProductosVendidos producto : productos) {
			if (criterios.aplica(producto)) {
				contados++;
				if (contados == cantidad) {
					bonificados += bonificacion;
					contados = 0;
				}
				productosCoincidentes.add(producto);
			}
		}
		for (ProductosVendidos producto : productosCoincidentes) {
			// TODO VER EL TEMA DEL PRECIO. SI ES PARA TODO EL PRODUCTO VENDIDO O NO
			//producto.setPrecio(0);
			bonificados--;
			if (bonificados == 0)
				break;
		}*/
		
		//TODO guardar descuentos
		//ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		//return descuentos;
		return null;
	}

	public boolean encajaEnOferta(ProductosVendidos producto) {
		return (criterios.aplica(producto));
	}

}
