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

	public void agregarProducto(int producto, int cantidad) {
		sucursal.agregarProducto(producto, cantidad);
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

}
