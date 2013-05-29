package modelo;

import java.util.ArrayList;
import java.util.Map;

import vista.Vista;

public class Mercado {
	
	private Sucursal sucursal;
	private Vista vista;
	private boolean done;
	
	public Mercado() {
		sucursal = new Sucursal();
		vista = new Vista(this);
		done = false;
	}
	
	public void correr() {
		while ( ! this.done) {
			vista.ejecutarVistaVenta();
		}
	}
	
	public ArrayList<Producto> getProductos() {
		return sucursal.getProductos();
	}

	public boolean agregarProducto(int producto, int cantidad) {
		return sucursal.agregarProducto(producto, cantidad);
	}

	public void salir() {
		done = true;
	}

	public float getTotalDescuentos() {
		return sucursal.getTotalDescuentos();
	}

	public float getTotalVentas() {
		return sucursal.getTotalVentas();
	}
	
	public void ejecutarVenta() {
		sucursal.iniciarVenta();
		boolean done = false;
		while ( ! done) {
			agregarProducto();
			vista.mostrarTotalVentaActual(sucursal.getTotalVentaActual());
			if ( ! continuarVenta() )
				done = true;
		}
		sucursal.setMedioDePago( vista.obtenerMedioDePago() );
		aplicarOfertas();
		vista.mostrarDescuentosAplicados();
		sucursal.finalizarVenta();
	}

	private void aplicarOfertas() {
		sucursal.aplicarOfertas();
	}

	private void agregarProducto() {
		vista.agregarProducto();
	}
	
	private boolean continuarVenta() {
		return vista.continuarVenta();
	}

	public Map<String,Float> getTotalPorMedioDePago() {
		return sucursal.getTotalPorMedioDePago();
	}

	public float getDescuentosAplicados() {
		return sucursal.getDescuentosAplicados();
	}

}
