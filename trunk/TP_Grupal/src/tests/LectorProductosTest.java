package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelo.LectorProductos;
import modelo.Producto;

import org.junit.Test;

public class LectorProductosTest {

	@Test
	public void testCargarUnProductoNombre() {
		LectorProductos lector = new LectorProductos();
		lector.setArchivo("productosPruebaUnico.csv");
		
		ArrayList<Producto> producto = lector.cargarProductos();
		
		String esperado = "Cafe 180 gramos";
		String nombre = producto.get(0).getNombre();
		assertEquals(esperado, nombre);
	}
	
	@Test
	public void testCargarUnProductoCategoria() {
		LectorProductos lector = new LectorProductos();
		lector.setArchivo("productosPruebaUnico.csv");
		
		ArrayList<Producto> producto = lector.cargarProductos();
		
		String esperado = "Almacen";
		String categoria = producto.get(0).getCategoria();
		assertEquals(esperado, categoria);
	}
	
	@Test
	public void testCargarUnProductoMarca() {
		LectorProductos lector = new LectorProductos();
		lector.setArchivo("productosPruebaUnico.csv");
		
		ArrayList<Producto> producto = lector.cargarProductos();
		
		String esperado = "Cafelombia";
		String marca = producto.get(0).getMarca();
		assertEquals(esperado, marca);
	}
	
	@Test
	public void testCargarUnProductoPrecio() {
		LectorProductos lector = new LectorProductos();
		lector.setArchivo("productosPruebaUnico.csv");
		
		ArrayList<Producto> producto = lector.cargarProductos();
		
		double esperado = 15.0;
		double precio = producto.get(0).getPrecio();
		double delta = 0.001;
		assertEquals(esperado, precio, delta);
	}
	
	@Test
	public void testCargarDosProductos() {
		LectorProductos lector = new LectorProductos();
		lector.setArchivo("productosPruebaDosProductos.csv");
		
		ArrayList<Producto> producto = lector.cargarProductos();
		
		int esperado = 2;
		int size = producto.size();
		assertEquals(esperado, size);
	}
	
	@Test
	public void testCargarDosProductosMarca() {
		LectorProductos lector = new LectorProductos();
		lector.setArchivo("productosPruebaDosProductos.csv");
		
		ArrayList<Producto> producto = lector.cargarProductos();
			
		String esperado = "H2O";
		String marca = producto.get(1).getMarca();
		assertEquals(esperado, marca);
	}
}
