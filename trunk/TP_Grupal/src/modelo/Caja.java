package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import ofertas.OfertaPorUnidad;

public class Caja {

	private boolean abierta = false;
	private ArrayList<Venta> ventas;
	private LinkedList<OfertaPorUnidad> ofertas;
	private Venta ventaActual = null;
	
	public Caja() {
		ventas = new ArrayList<Venta>();
		ofertas = new LinkedList<OfertaPorUnidad>();
	}
	
	/* En caso de que la caja ya esté abierta, devuelve false. */
	public boolean abrirCaja() {
		if (abierta) {
			return false;
		}
		abierta = true;
		return true;
	}
	
	/* En caso de que la caja ya esté cerrada, devuelve false. */
	public boolean cerrarCaja() {
		if ( ! abierta) {
			return false;
		}
		abierta = false;
		return true;
	}
	
	public void setOfertas(List<OfertaPorUnidad> ofertasNuevas) {
		for(OfertaPorUnidad nueva : ofertasNuevas) {
			this.ofertas.add(nueva);
		}
	}
	
	public void removerOferta(OfertaPorUnidad of) {
		ofertas.remove(of);
	}
	
	/* En caso de que ya exista una venta iniciada o la caja no esté abierta, devuelve false. */
	public boolean iniciarVenta() {
		if (! abierta || ventaActual != null) {
			return false;
		}
		ventaActual = new Venta();
		return true;
	}
	
	public void aplicarOfertas() {
		for (OfertaPorUnidad oferta : this.ofertas)
			ventaActual.aplicarOferta(oferta);
	}
	
	/* En caso de que no exista una venta iniciada o la caja no esté abierta, devuelve false. */
	public boolean finalizarVenta() {
		if (! abierta || ventaActual == null) {
			return false;
		}
		ventaActual.finalizarVenta();
		ventas.add(ventaActual);
		ventaActual = null;
		return true;
	}
	
	/* En caso de que no exista una venta iniciada o la caja no esté abierta, devuelve false. */
	public boolean agregarProducto(Producto prod, int cantidad) {
		if (! abierta || ventaActual == null) {
			return false;
		}
		ventaActual.agregarProducto(prod, cantidad);
		return true;
	}
	
	public boolean agregarProducto(Producto prod) {
		return agregarProducto(prod, 1);
	}
	
	/* En caso de que no exista una venta iniciada o la caja no esté abierta, devuelve false. */
	public boolean setMedioDePago(String medio) {
		if (! abierta || ventaActual == null) {
			return false;
		}
		ventaActual.setMedioDePago(medio);
		return true;
	}
	
	/* En caso de que no exista una venta iniciada o la caja no esté abierta, devuelve -1. */
	public float getTotalVenta() {
		if (! abierta || ventaActual == null) {
			return -1;
		}
		return ventaActual.getTotal();
	}
	
	/* En caso de que no exista una venta iniciada o la caja no esté abierta, devuelve -1. */
	public float getTotalDescuentosVenta() {
		if (! abierta || ventaActual == null) {
			return -1;
		}
		return ventaActual.getTotalDescuentos();
	}
	
	public float getTotalVentas(){
		float total = 0;
		for (Venta ven : this.ventas) {
			total += ven.getTotal();
		}
		return total;
	}
	
	public float getTotalDescuentos(){
		float total = 0;
		for (Venta ven : this.ventas) {
			total += ven.getTotalDescuentos();
		}
		return total;
	}
	
	public Map<String, Float> getTotalPorMedioDePago() {
		HashMap<String, Float> res = new HashMap<String, Float>();
		for (Venta ven : this.ventas) {
			if ( res.containsKey(ven.getMedioDePago() ) ) {
				float actual = res.get(ven.getMedioDePago());
				res.put(ven.getMedioDePago(), actual + ven.getTotal() );
			} else {
				res.put(ven.getMedioDePago(), ven.getTotal() );
			}
		}
		return res;
	}
}
