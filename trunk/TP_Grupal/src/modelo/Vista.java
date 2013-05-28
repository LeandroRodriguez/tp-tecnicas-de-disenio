package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Vista {
	
	private Mercado mercado;
	
	public Vista(Mercado mercado) {
		this.mercado = mercado;
	}
	
	public int pedirNumeroEntre(int menor, int mayor) {
		Scanner sc = new Scanner(System.in);
		int i = -1;
		boolean done = false;
		while ( ! done) {
			try {
				String aux = sc.next();
				i = Integer.parseInt(aux);
				if (i >= menor && i <= mayor)
					done = true;
			} catch (NumberFormatException e){
				continue;
			}
		}
		return i;
	}
	
	public void mostrarProductos() {
		ArrayList<Producto> productos = mercado.getProductos();
		System.out.println("Listado de productos disponibles (Nombre - Marca - Precio):");
		for (Producto producto : productos) {
			System.out.format("%s - %s - $%.2f\n", producto.getNombre(), producto.getMarca(),
					producto.getPrecio() );
		}
	}
	
	private void imprimirListado(ArrayList<String> listado) {
		int i = 1;
		for(String elem : listado) {
			System.out.format("%d - %s\n", i, elem);
			i += 1;
		}
	}
	
	public int mostrarMenuVenta() {
		ArrayList<String> menu = new ArrayList<String>(Arrays.asList(
				"Iniciar Venta",
				"Visualizar total de ventas",
				"Visualizar total de descuentos",
				"Visualizar total por medio de pago",
				"Salir"));
		imprimirListado(menu);
		return menu.size();
	}
	
	public void vistaVenta() {
		int len = mostrarMenuVenta();
		int eleccionUsuario = pedirNumeroEntre(1, len);
		switch(eleccionUsuario) {
		case 1:
			ejecutarVenta();
			break;
		case 2:
			verTotalVentas();
			break;
		case 3:
			verTotalDescuentos();
			break;
		case 4:
			verTotalPorMedioDePago();
			break;
		case 5:
			mercado.salir();
			break;	
		}
		
	}
	
	private void verTotalPorMedioDePago() {
		// TODO Auto-generated method stub

	}

	private void verTotalDescuentos() {
		float total = mercado.getTotalDescuentos();
		System.out.format("Hasta el momento el total de los descuentos es: $%.2f", total);
	}

	private void verTotalVentas() {
		float total = mercado.getTotalVentas();
		System.out.format("Hasta el momento el total de las ventas es: $%.2f", total);
	}

	public void ejecutarVenta() {
		mostrarProductos();
		int producto = pedirNumeroProducto() - 1; //resto porque es el indice
		int cantidad = pedirCantidadProducto();
		mercado.agregarProducto(producto, cantidad);
	}
	
	private int pedirNumeroProducto() {
		System.out.println("Ingrese el número del producto a comprar:");
		return pedirNumeroEntre(1,mercado.getProductos().size() );
	}
	
	private int pedirCantidadProducto() {
		System.out.println("Ingrese la cantidad a comprar:");
		int cantidadMaxima = 99; 
		return pedirNumeroEntre(1, cantidadMaxima);
	}
}
