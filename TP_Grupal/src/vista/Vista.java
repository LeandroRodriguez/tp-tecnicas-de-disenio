package vista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import modelo.Mercado;
import modelo.Producto;

public class Vista {
	
	private Mercado mercado;
	private Scanner scanner;
	
	public Vista(Mercado mercado) {
		this.mercado = mercado;
		this.scanner = new Scanner(System.in);
	}
	
	private int pedirNumeroEntre(int menor, int mayor) {
		//Scanner sc = new Scanner(System.in);
		int i = -1;
		String aux = "-1";
		boolean done = false;
		while ( ! done) {
			try {
				scanner.reset();
				aux = scanner.next();
				i = Integer.parseInt(aux);
				if (i >= menor && i <= mayor)
					done = true;
				else
					System.out.format("ERROR: Debe ingresar un valor numérico entre %d y %d\n",
							menor, mayor);
			} catch (NumberFormatException e){
				System.out.println("ERROR: Debe ingresar valores numéricos");
			} catch (NoSuchElementException e){
				System.out.println("ERROR: Debe ingresar valores numéricos");
			}
		}
		//sc.close();
		return i;
	}
	
	public boolean pedirConfirmacion(String pregunta) {	
		String aux = "";
		boolean done = false;
		while ( ! done) {
			System.out.println(pregunta + " [s/n]");
			scanner.reset();
			aux = scanner.next();
			done = ( aux.equals("s") || aux.equals("n") );
		}
		return aux.equals("s");
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
				"Visualizar ranking productos mas vendidos",
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
			mostrarRanking();
			break;
		case 6:
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
		float total = mercado.getTotalVentasNeto();
		System.out.format("Hasta el momento el total de las ventas es: $%.2f\n\n", total);
	}	
	
	public void verTotalVentaAPagar() {
		float descuento = mercado.getDescuentosAplicados();
		float total = mercado.getTotalVentaActual() - descuento;
		
		mostrarTotalVentaActual();
		mostrarDescuentosAplicados(descuento);
		System.out.format("El total a pagar es: $%.2f\n\n", total);
	}
	
	public void mostrarTotalVentaActual() {
		float total = mercado.getTotalVentaActual();
		System.out.format("Hasta el momento el subtotal de las venta actual es: $%.2f\n\n", total);
	}
	
	private void mostrarDescuentosAplicados(float total) {
		System.out.format("El total de descuentos de esta venta es: $%.2f\n\n", total);	
	}

	public String obtenerMedioDePago() {
		ArrayList<String> medios = new ArrayList<String>(Arrays.asList(
				"Efectivo",
				"Tarjeta XYZ",
				"Débito"));
		System.out.println("Ingrese el medio de pago a utilizar:");
		imprimirListado(medios);
		int indice = pedirNumeroEntre(1,medios.size()) - 1;
		return medios.get(indice);
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
		int len = mercado.getProductos().size();
		return pedirNumeroEntre(1, len );
	}
	
	private int pedirCantidadProducto() {
		System.out.println("Ingrese la cantidad a comprar:");
		int cantidadMaxima = 99; 
		return pedirNumeroEntre(1, cantidadMaxima);
	}
	
	private void mostrarRanking() {
		Map<String, Integer> productos = mercado.getVentasTotalesPorProductos();
		int len = productos.size();
		if (len == 0) {
			System.out.println("No se han efectuado ventas aun");
			return;
		}
		System.out.println("Ranking de productos más vendidos");
		for (int i = 0; i < len; i++) {
			String maximoClave = "";
			int maximo = -1;
			for (String clave : productos.keySet()) {
				if (productos.get(clave) > maximo) {
					maximo = productos.get(clave);
					maximoClave = clave;
				}
			}
			productos.remove(maximoClave);
			System.out.format("%s - %d\n", maximoClave, maximo);
		}
		System.out.println("");
	}
}
