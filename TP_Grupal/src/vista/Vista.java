package vista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import modelo.Mercado;
import modelo.Producto;

public class Vista {
	
	private Mercado mercado;
	
	public Vista(Mercado mercado) {
		this.mercado = mercado;
	}
	
	private int pedirNumeroEntre(int menor, int mayor) {
		Scanner sc = new Scanner(System.in);
		int i = -1;
		boolean done = false;
		while ( ! done) {
			try {
				String aux = sc.next();
				i = Integer.parseInt(aux);
				if (i >= menor && i <= mayor)
					done = true;
				else
					System.out.format("ERROR: Debe ingresar un valor numérico entre %d y %d\n",
							menor, mayor);
			} catch (NumberFormatException e){
				System.out.println("ERROR: Debe ingresar valores numéricos");
			}
		}
		return i;
	}
	
	private void mostrarProductos() {
		ArrayList<Producto> productos = mercado.getProductos();
		int i = 1;
		System.out.println("Listado de productos disponibles (Nombre - Marca - Precio):");
		for (Producto producto : productos) {
			System.out.format("%d - %s - %s - $%.2f\n", i, producto.getNombre(), producto.getMarca(),
					producto.getPrecio() );
			i += 1;
		}
	}
	
	private void imprimirListado(ArrayList<String> listado) {
		int i = 1;
		for(String elem : listado) {
			System.out.format("%d - %s\n", i, elem);
			i += 1;
		}
	}
	
	private int mostrarMenuVenta() {
		ArrayList<String> menu = new ArrayList<String>(Arrays.asList(
				"Iniciar Venta",
				"Visualizar total de ventas",
				"Visualizar total de descuentos",
				"Visualizar total por medio de pago",
				"Salir"));
		imprimirListado(menu);
		return menu.size();
	}
	
	public void ejecutarVistaVenta() {
		int len = mostrarMenuVenta();
		int eleccionUsuario = pedirNumeroEntre(1, len);
		switch(eleccionUsuario) {
		case 1:
			mercado.ejecutarVenta();
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
		Map<String,Float> total = mercado.getTotalPorMedioDePago();
		if (total.size() == 0) {
			System.out.println("Aún no se ha realizado ningún pago\n");
			return;
		}
		System.out.println("Total por medio de pago:");
		for(String clave : total.keySet()) {
			System.out.format("%s: $%.2f\n", clave, total.get(clave));
		}
		System.out.println("");
	}

	private void verTotalDescuentos() {
		float total = mercado.getTotalDescuentos();
		System.out.format("Hasta el momento el total de los descuentos es: $%.2f\n\n", total);
	}

	private void verTotalVentas() {
		float total = mercado.getTotalVentas();
		System.out.format("Hasta el momento el total de las ventas es: $%.2f\n\n", total);
	}	
	
	public void mostrarDescuentosAplicados() {
		float total = mercado.getDescuentosAplicados();
		System.out.format("El total de descuentos de esta venta es: $%.2f\n\n", total);	
	}

	public String obtenerMedioDePago() {
		ArrayList<String> medios = new ArrayList<String>(Arrays.asList(
				"Efectivo",
				"Crédito",
				"Débito"));
		System.out.println("Ingrese el medio de pago a utilizar:");
		imprimirListado(medios);
		int indice = pedirNumeroEntre(1,medios.size()) - 1;
		return medios.get(indice);
	}

	public void mostrarTotalVentaActual(float total) {
		System.out.format("Hasta el momento el subtotal de las venta actual es: $%.2f\n\n", total);
	}

	public void agregarProducto() {
		mostrarProductos();
		int producto = pedirNumeroProducto() - 1; //resto porque es el indice
		int cantidad = pedirCantidadProducto();
		if (mercado.agregarProducto(producto, cantidad) )
			System.out.println("Producto agregado con éxito\n");
		else 
			System.out.println("ERROR");
	}

	public boolean continuarVenta() {
		ArrayList<String> menu = new ArrayList<String>(Arrays.asList(
				"Continuar agregando productos",
				"Finalizar venta"));
		imprimirListado(menu);
		int ingresado = pedirNumeroEntre(1,2);
		if (ingresado == 1)
			return true;
		return false;
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
