package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ofertas.Oferta;

public class Caja {

	private boolean abierta = false;
	private ArrayList<Venta> ventas;
	private ArrayList<Oferta> ofertasPorUnidad;
	private ArrayList<Oferta> ofertasPorVolumen;
	private ArrayList<Oferta> ofertasPorVentaTotal;
	private Venta ventaActual = null;
	
	public Caja() {
		ventas = new ArrayList<Venta>();
		ofertasPorUnidad = new ArrayList<Oferta>();
		ofertasPorVolumen = new ArrayList<Oferta>();
		ofertasPorVentaTotal = new ArrayList<Oferta>();
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
		
	/* En caso de que ya exista una venta iniciada o la caja no esté abierta, devuelve false. */
	public boolean iniciarVenta() {
		if (! abierta || ventaActual != null) {
			return false;
		}
		ventaActual = new Venta();
		return true;
	}
	
	public void aplicarOfertas() {
		if (! abierta || ventaActual == null)
			return;
		for (Oferta oferta : this.ofertasPorVolumen)
			ventaActual.aplicarOferta(oferta);
		for (Oferta oferta : this.ofertasPorUnidad)
			ventaActual.aplicarOferta(oferta);
		for (Oferta oferta : this.ofertasPorVentaTotal)
			ventaActual.aplicarOferta(oferta);
	}
	
	/* En caso de que no exista una venta iniciada o la caja no esté abierta, devuelve false. */
	public boolean finalizarVenta() {
		if (! abierta || ventaActual == null) {
			return false;
		}
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
	
	public float getTotalVentasNeto() {
		float total = 0;
		for (Venta ven : this.ventas) {
			total += ven.getTotalNeto();
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
				res.put(ven.getMedioDePago(), (float) (actual + ven.getTotalNeto()) );
			} else {
				res.put(ven.getMedioDePago(), (float) ven.getTotalNeto() );
			}
		}
		return res;
	}

	public void cargarOfertasUnidad(ArrayList<Oferta> ofertasNuevas) {
		ofertasPorUnidad = ofertasNuevas;
	}

	public void cargarOfertasVolumen(ArrayList<Oferta> ofertasNuevas) {
		ofertasPorVolumen = ofertasNuevas;
	}
	
	public void cargarOfertasVentaTotal(ArrayList<Oferta> ofertasNuevas) {
		ofertasPorVentaTotal = ofertasNuevas;
	}
	
	
	public Map<String, Integer> getVentasTotalesPorProductos() {
		Map<String, Integer> productos = new HashMap<String, Integer>();
		for (Venta venta : this.ventas) {
			for (ProductoVendido productoVendido : venta.getProductosVendidos()) {
				String nombre = productoVendido.getProducto().getNombre();
				if (productos.containsKey(nombre ) ) {
					int cantidad = productos.get(nombre) + productoVendido.getCantidadDeProductos(); 
					productos.put(nombre, cantidad);
				} else {
					productos.put(nombre, productoVendido.getCantidadDeProductos() );
				}
			}
		}
		return productos;
	}
}
