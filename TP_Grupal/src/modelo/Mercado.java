package modelo;

import java.util.ArrayList;

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
		vista.mostrarProductos();
		vista.mostrarMenuVenta();
	}
	
	public void pideNumero() {
		System.out.println("ingrese un numero");
		Vista v = new Vista(this);
		int i = v.pedirNumeroEntre(1, 5);
		System.out.format("El numero ingresado es: %d \n", i);
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
			if ( ! vista.continuarVenta() )
				done = true;
		}
		sucursal.setMedioDePago( vista.obtenerMedioDePago() );
		aplicarOfertas();
		vista.mostrarDescuentosAplicados();
		sucursal.finalizarVenta();
	}

	private void aplicarOfertas() {
		// TODO Auto-generated method stub
		
	}

	private void agregarProducto() {
		vista.agregarProducto();
	}

}
