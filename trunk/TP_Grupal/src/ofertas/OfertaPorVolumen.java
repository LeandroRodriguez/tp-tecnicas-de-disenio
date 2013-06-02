package ofertas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Descuento;
import modelo.Producto;
import modelo.ProductoVendido;
import modelo.Venta;

import com.google.gson.Gson;

import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumen implements OfertaDeProductos {
	
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
	
	public int getBonificacionesPosibles(ProductoVendido productosVendidos) {
		return productosVendidos.getCantidadDeProductos() / cantidadesPorProducto.get(this.obtenerClave( productosVendidos.getProducto() ) );
	}
	
	public float getValorDescuento() {
		float valor = 0;
		for(Producto producto: cantidadesPorProducto.keySet()) {
			Producto clave = obtenerClave(producto);
			valor += bonificacionesPorProducto.get(clave) * producto.getPrecio();
		}
		return valor;
	}
	
	public List<Descuento> aplicarOferta(Venta venta) {
		return aplicarOferta(venta.getProductosVendidos());
	}

	public List<Descuento> aplicarOferta(List<ProductoVendido> productos) {
		int bonificacionesAplicables = -1; 
		for(ProductoVendido productosVendidos: productos) {
			Producto clave = obtenerClave(productosVendidos.getProducto() );
			if(productosVendidos.getDescuentosAplicados().size() > 0)
				continue;
			if(cantidadesPorProducto.containsKey(clave)) {
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
		for(ProductoVendido productosVendidos: productos) {
			Producto clave = obtenerClave(productosVendidos.getProducto() );
			if(cantidadesPorProducto.containsKey(clave)) {
				clave = obtenerClaveBonificacion(productosVendidos.getProducto() );
				float valor = bonificacionesPorProducto.get(clave);
				descuentos.add(new DescuentoPorVolumen(productosVendidos,
						bonificacionesAplicables * valor
						* (float) productosVendidos.getProducto().getPrecio()));
			}
		}
		//descuentos.add(new DescuentoPorVolumen(getValorDescuento() * bonificacionesAplicables));
		return descuentos;
	}

	public boolean encajaEnOferta(ProductoVendido producto) {
		Producto clave = obtenerClave(producto.getProducto() );
		return cantidadesPorProducto.containsKey(clave);
	}
	
	private Producto obtenerClaveBonificacion(Producto p) {
		for(Producto clave : bonificacionesPorProducto.keySet()) {
			if ( clave.equals(p) )
				return clave;
		}
		return null;
	}
	
	
	private Producto obtenerClave(Producto p) {
		for(Producto clave : cantidadesPorProducto.keySet()) {
			if ( clave.equals(p) )
				return clave;
		}
		return null;
	}
	
	public String serializar(){
		Gson gson = new Gson();
		StringBuffer res = new StringBuffer();
		for (Producto p: cantidadesPorProducto.keySet()){
			res.append(gson.toJson(p));
			res.append("!");
			res.append(cantidadesPorProducto.get(p));
			res.append("&");
		}
		res.append(";");
		for (Producto p: bonificacionesPorProducto.keySet()){
			res.append(gson.toJson(p));
			res.append("!");
			res.append(bonificacionesPorProducto.get(p));
			res.append("&");
		}
		return res.toString();
	}

	public void cargarDeArchivo(String datos) {
		Gson gson = new Gson();
		String tokens[] = datos.split(";");
		String productos[] = tokens[0].split("&");
		for (String tokenProducto : productos){
			if (tokenProducto.length()==0) continue;
			String partes[] = tokenProducto.split("!");
			Producto p = gson.fromJson(partes[0], Producto.class);
			cantidadesPorProducto.put(p, Integer.parseInt(partes[1]));
		}
		String bonificaciones[] = tokens[1].split("&");
		for (String tokenProducto : bonificaciones){
			if (tokenProducto.length()==0) continue;
			String partes[] = tokenProducto.split("!");
			Producto p = gson.fromJson(partes[0], Producto.class);
			bonificacionesPorProducto.put(p, Float.parseFloat(partes[1]));
		}
	}

	public boolean equals(OfertaPorVolumen o){
		boolean comp;
		comp = (o.bonificacionesPorProducto.size() == this.bonificacionesPorProducto.size());
		if (!comp) return false;
		comp = (o.cantidadesPorProducto.size() == this.cantidadesPorProducto.size());
		if (!comp) return false;
		return true;
	}

}
