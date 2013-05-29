package modelo;

import java.util.ArrayList;
import java.util.Map;

public class Sucursal {
	
	private Caja caja;
	private ArrayList<Producto> productos;
	
	public Sucursal() {
		caja = new Caja();
		caja.abrirCaja();
		cargarProductos();
	}
	
	public void cargarProductos() {
		LectorProductos lector =  new LectorProductos();
		productos = lector.cargarProductos();
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	public Caja getCaja() {
		return caja;
	}

	public boolean agregarProducto(int indiceProducto, int cantidad) {
		return caja.agregarProducto( productos.get(indiceProducto), cantidad);
	}

	public float getTotalDescuentos() {
		return caja.getTotalDescuentos();
	}

	public float getTotalVentas() {
		return caja.getTotalVentas();
	}

	public void iniciarVenta() {
		cargarProductos(); // Antes de iniciar cada venta carga nuevamente los productos
		// por si hubo modificaciones
		caja.iniciarVenta();
	}

	public float getTotalVentaActual() {
		return caja.getTotalVenta();
	}

	public void finalizarVenta() {
		caja.finalizarVenta();
	}

	public void setMedioDePago(String medio) {
		caja.setMedioDePago(medio);
	}

	public void aplicarOfertas() {
		caja.aplicarOfertas();
	}

	public Map<String,Float> getTotalPorMedioDePago() {
		return caja.getTotalPorMedioDePago();
	}

	public float getDescuentosAplicados() {
		return caja.getTotalDescuentosVenta();
	}
}
