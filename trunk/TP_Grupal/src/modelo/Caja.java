package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import ofertas.Oferta;

public class Caja {

	private boolean abierta = false;
	private ArrayList<Venta> ventas;
	private LinkedList<Oferta> ofertas;
	private Venta ventaActual = null;
	
	public Caja() {
		ventas = new ArrayList<Venta>();
		ofertas = new LinkedList<Oferta>();
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
	
	public void setOfertas(List<Oferta> ofertasNuevas) {
		for(Oferta nueva : ofertasNuevas) {
			this.ofertas.add(nueva);
		}
	}
	
	public void removerOferta(Oferta of) {
		ofertas.remove(of);
	}
	
	/* En caso de que ya exista una venta iniciada, devuelve false. */
	public boolean iniciarVenta() {
		if (ventaActual != null) {
			return false;
		}
		ventaActual = new Venta();
		return true;
	}
	
	public void aplicarOfertas() {
		for (Oferta oferta : this.ofertas)
			ventaActual.aplicarOferta(oferta);
	}
	
	/* En caso de que no exista una venta iniciada, devuelve false. */
	public boolean finalizarVenta() {
		if (ventaActual == null) {
			return false;
		}
		ventaActual.finalizarVenta();
		ventas.add(ventaActual);
		ventaActual = null;
		return true;
	}
	
	/* En caso de que no exista una venta iniciada, devuelve false. */
	public boolean agregarProducto(Producto prod) {
		if (ventaActual == null) {
			return false;
		}
		ventaActual.agregarProducto(prod);
		return true;
	}
	
	/* En caso de que no exista una venta iniciada, devuelve false. */
	public boolean setMedioDePago(String medio) {
		if (ventaActual == null) {
			return false;
		}
		ventaActual.setMedioDePago(medio);
		return true;
	}
	
	/* En caso de que no exista una venta iniciada, devuelve -1. */
	public float getTotalVenta() {
		if (ventaActual == null) {
			return -1;
		}
		return ventaActual.getTotal();
	}
	
	/* En caso de que no exista una venta iniciada, devuelve -1. */
	public float getTotalDescuentosVenta() {
		if (ventaActual == null) {
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
			res.put(ven.getMedioDePago(), ven.getTotal() );
		}
		return res;
	}
}
