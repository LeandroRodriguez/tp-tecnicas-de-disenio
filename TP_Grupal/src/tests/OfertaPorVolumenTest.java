package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.Producto;
import modelo.ProductoVendido;
import modelo.ProductosVendidos;
import ofertas.OfertaPorVolumen;
import ofertas.criterios.*;

import org.junit.Test;

import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumenTest extends TestCase{

	@Test
	public void testAplicarSobreProductos() {
		OfertaPorVolumen oferta;
		try {
			oferta = new OfertaPorVolumen(2, 1);
			oferta.agregarCriterio(new CriterioPorMarca("coca", true));
			ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
			Producto coca1 = new Producto("Coca", "coca", "bebidas", 10.0);
			Producto coca2 = new Producto("Coca", "coca", "bebidas", 10.0);
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			ProductosVendidos vendido1 = new ProductoVendido(coca1);
			ProductosVendidos vendido2 = new ProductoVendido(coca2);
			productos.add(vendido1);
			productos.add(vendido2);
			oferta.aplicarOferta(productos);
			assertTrue(coca1.getPrecio() == 0);
			assertTrue(coca2.getPrecio() == 100);
		} catch (ExcepcionCantidadInvalida e) {
			e.getMessage();
		}
	}

	@Test
	public void testAplicarSobreProductosDeOtraMarca() {
		OfertaPorVolumen oferta;
		try {
			oferta = new OfertaPorVolumen(2, 1);
			oferta.agregarCriterio(new CriterioPorMarca("CocaCola", true));
			ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
			Producto coca1 = new Producto("Coca", "Cordoba", "bebidas", 10.0);
			Producto coca2 = new Producto("Coca", "InkaCola", "bebidas", 10.0);
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			ProductosVendidos vendido1 = new ProductoVendido(coca1);
			ProductosVendidos vendido2 = new ProductoVendido(coca2);
			productos.add(vendido1);
			productos.add(vendido2);
			oferta.aplicarOferta(productos);
			assertTrue(coca1.getPrecio() == 100);
			assertTrue(coca2.getPrecio() == 100);
		} catch (ExcepcionCantidadInvalida e) {
			e.getMessage();
		}
	}

	@Test
	public void testAplicarSobreCategoria() {
		OfertaPorVolumen oferta;
		try {
			oferta = new OfertaPorVolumen(2, 1);
			oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
			ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
			Producto coca1 = new Producto("Coca", "Cordoba", "bebidas", 10.0);
			Producto coca2 = new Producto("Coca", "InkaCola", "bebidas", 10.0);
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			ProductosVendidos vendido1 = new ProductoVendido(coca1);
			ProductosVendidos vendido2 = new ProductoVendido(coca2);
			productos.add(vendido1);
			productos.add(vendido2);
			oferta.aplicarOferta(productos);
			assertTrue(coca1.getPrecio() == 0);
			assertTrue(coca2.getPrecio() == 100);
		} catch (ExcepcionCantidadInvalida e) {
			e.getMessage();
		}
	}

	@Test
	public void testAplicarSobreMarcaYCategoria() {
		OfertaPorVolumen oferta;
		try {
			oferta = new OfertaPorVolumen(2, 1);
			oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
			oferta.agregarCriterio(new CriterioPorMarca("CocaCola", true));
			oferta.cumplirTodosLosCriterios();
			ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
			Producto coca1 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			Producto coca2 = new Producto("Coca", "InkaCola", "bebidas", 10.0);
			Producto coca3 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			Producto coca4 = new Producto("Coca", "Cordoba", "bebidas", 10.0);
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			coca3.setPrecio(100);
			coca4.setPrecio(100);
			ProductosVendidos vendido1 = new ProductoVendido(coca1);
			ProductosVendidos vendido2 = new ProductoVendido(coca2);
			ProductosVendidos vendido3 = new ProductoVendido(coca3);
			ProductosVendidos vendido4 = new ProductoVendido(coca4);
			productos.add(vendido1);
			productos.add(vendido2);
			productos.add(vendido3);
			productos.add(vendido4);
			oferta.aplicarOferta(productos);
			assertTrue(coca1.getPrecio() == 0);
			assertTrue(coca2.getPrecio() == 100);
			assertTrue(coca3.getPrecio() == 100);
			assertTrue(coca4.getPrecio() == 100);
		} catch (ExcepcionCantidadInvalida e) {
			e.getMessage();
		}
	}

	@Test
	public void testAplicarSobreDosCategorias() {
		OfertaPorVolumen oferta;
		try {
			oferta = new OfertaPorVolumen(2, 1);
			oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
			oferta.agregarCriterio(new CriterioPorCategoria("almacen", true));
			oferta.cumplirAlgunCriterio();
			ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
			Producto coca1 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			Producto coca2 = new Producto("Coca", "InkaCola", "bebidas", 10.0);
			Producto coca3 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			Producto coca4 = new Producto("Coca", "Cordoba", "bebidas", 10.0);
			Producto almacen1 = new Producto("Coca", "Arroz", "almacen", 10.0);
			Producto almacen2 = new Producto("Coca", "Fideos", "almacen", 10.0);
			Producto almacen3 = new Producto("Coca", "Azucar", "almacen", 10.0);
			Producto almacen4 = new Producto("Coca", "Cafe", "almacen", 10.0);
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			coca3.setPrecio(100);
			coca4.setPrecio(100);
			almacen1.setPrecio(100);
			almacen2.setPrecio(100);
			almacen3.setPrecio(100);
			almacen4.setPrecio(100);
			ProductosVendidos vendido1 = new ProductoVendido(coca1);
			ProductosVendidos vendido2 = new ProductoVendido(coca2);
			ProductosVendidos vendido3 = new ProductoVendido(coca3);
			ProductosVendidos vendido4 = new ProductoVendido(coca4);
			productos.add(vendido1);
			productos.add(vendido2);
			productos.add(vendido3);
			productos.add(vendido4);
			
			ProductosVendidos vendido5 = new ProductoVendido(almacen1);
			ProductosVendidos vendido6 = new ProductoVendido(almacen2);
			ProductosVendidos vendido7 = new ProductoVendido(almacen3);
			ProductosVendidos vendido8 = new ProductoVendido(almacen4);
			productos.add(vendido5);
			productos.add(vendido6);
			productos.add(vendido7);
			productos.add(vendido8);
			
			oferta.aplicarOferta(productos);
			assertTrue(coca1.getPrecio() == 0);
			assertTrue(coca2.getPrecio() == 0);
			assertTrue(coca3.getPrecio() == 0);
			assertTrue(coca4.getPrecio() == 0);
			assertTrue(almacen1.getPrecio() == 100);
			assertTrue(almacen2.getPrecio() == 100);
			assertTrue(almacen3.getPrecio() == 100);
			assertTrue(almacen4.getPrecio() == 100);
		} catch (ExcepcionCantidadInvalida e) {
			e.getMessage();
		}
	}


	@Test
	public void testAplicarSobreProductosMultiple() {
		OfertaPorVolumen oferta;
		try {
			oferta = new OfertaPorVolumen(2, 1);
			oferta.agregarCriterio(new CriterioPorMarca("CocaCola", true));
			ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
			Producto coca1 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			Producto coca2 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			Producto coca3 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			Producto coca4 = new Producto("Coca", "CocaCola", "bebidas", 10.0);
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			coca3.setPrecio(100);
			coca4.setPrecio(100);
			
			ProductosVendidos vendido1 = new ProductoVendido(coca1);
			ProductosVendidos vendido2 = new ProductoVendido(coca2);
			ProductosVendidos vendido3 = new ProductoVendido(coca3);
			ProductosVendidos vendido4 = new ProductoVendido(coca4);
			productos.add(vendido1);
			productos.add(vendido2);
			productos.add(vendido3);
			productos.add(vendido4);
			oferta.aplicarOferta(productos);
			assertTrue(coca1.getPrecio() == 0);
			assertTrue(coca2.getPrecio() == 0);
			assertTrue(coca3.getPrecio() == 100);
			assertTrue(coca4.getPrecio() == 100);
		} catch (ExcepcionCantidadInvalida e) {
			e.getMessage();
		}
	}

}
