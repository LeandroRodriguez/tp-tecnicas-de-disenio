package modelo;

import java.util.ArrayList;
import java.util.Map;

import ofertas.Cupon;
import ofertas.CuponFactory;
import vista.Vista;

public class Mercado {
	
	private Sucursal sucursal;
	private Vista vista;
	private boolean done;
	ArrayList<Cupon> cupones;
	
	public Mercado() {
		sucursal = new Sucursal();
		vista = new Vista(this);
		done = false;
		MediadorPregunta.setVista(vista);
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

	public float getTotalVentasNeto() {
		return sucursal.getTotalVentasNeto();
	}
	
	public void ejecutarVenta() {
		sucursal.cargarOfertas();
		sucursal.iniciarVenta();
		boolean done = false;
		while ( ! done) {
			agregarProducto();
			vista.mostrarTotalVentaActual();
			if ( ! continuarVenta() )
				done = true;
		}
		sucursal.setMedioDePago( vista.obtenerMedioDePago() );
		aplicarOfertas();
		vista.verTotalVentaAPagar();
		// Buscar cupones
		CuponFactory cuponFactory = new CuponFactory();
		this.cupones = cuponFactory.buscarCupones(sucursal.getCaja().getVenta().getProductosVendidos());
		sucursal.finalizarVenta();
	}

	public ArrayList<Cupon> getCupones() {
		return cupones;
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
	
	public float getTotalVentaActual() {
		return sucursal.getTotalVentaActual();
	}

	public Map<String, Integer> getVentasTotalesPorProductos() {
		return sucursal.getVentasTotalesPorProductos();
	}

}
