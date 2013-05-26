package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.Producto;
import ofertas.OfertaPorVolumen;
import ofertas.ProductoDummy;

import org.junit.Test;

import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumenTest extends TestCase{

	@Test
	public void testAplicarSobreProductos() {
		OfertaPorVolumen oferta;
		try {
			oferta = new OfertaPorVolumen(2, 1);
			oferta.agregarMarca("coca");
			ArrayList<Producto> productos = new ArrayList<Producto>();
			ProductoDummy coca1 = new ProductoDummy("coca", "bebidas");
			ProductoDummy coca2 = new ProductoDummy("coca", "bebidas");
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			productos.add(coca1);
			productos.add(coca2);
			oferta.aplicarOfertas(productos);
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
			oferta.agregarMarca("CocaCola");
			ArrayList<Producto> productos = new ArrayList<Producto>();
			ProductoDummy coca1 = new ProductoDummy("Cordoba", "bebidas");
			ProductoDummy coca2 = new ProductoDummy("InkaCola", "bebidas");
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			productos.add(coca1);
			productos.add(coca2);
			oferta.aplicarOfertas(productos);
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
			oferta.agregarCategoria("bebidas");
			ArrayList<Producto> productos = new ArrayList<Producto>();
			ProductoDummy coca1 = new ProductoDummy("Cordoba", "bebidas");
			ProductoDummy coca2 = new ProductoDummy("InkaCola", "bebidas");
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			productos.add(coca1);
			productos.add(coca2);
			oferta.aplicarOfertas(productos);
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
			oferta.agregarCategoria("bebidas");
			oferta.agregarMarca("CocaCola");
			oferta.cumplirTodosLosCriterios();
			ArrayList<Producto> productos = new ArrayList<Producto>();
			ProductoDummy coca1 = new ProductoDummy("CocaCola", "bebidas");
			ProductoDummy coca2 = new ProductoDummy("InkaCola", "bebidas");
			ProductoDummy coca3 = new ProductoDummy("CocaCola", "bebidas");
			ProductoDummy coca4 = new ProductoDummy("Cordoba", "bebidas");
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			coca3.setPrecio(100);
			coca4.setPrecio(100);
			productos.add(coca1);
			productos.add(coca2);
			productos.add(coca3);
			productos.add(coca4);
			oferta.aplicarOfertas(productos);
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
			oferta.agregarCategoria("bebidas");
			oferta.agregarCategoria("almacen");
			oferta.cumplirAlgunCriterio();
			ArrayList<Producto> productos = new ArrayList<Producto>();
			ProductoDummy coca1 = new ProductoDummy("CocaCola", "bebidas");
			ProductoDummy coca2 = new ProductoDummy("InkaCola", "bebidas");
			ProductoDummy coca3 = new ProductoDummy("CocaCola", "bebidas");
			ProductoDummy coca4 = new ProductoDummy("Cordoba", "bebidas");
			ProductoDummy almacen1 = new ProductoDummy("Arroz", "almacen");
			ProductoDummy almacen2 = new ProductoDummy("Fideos", "almacen");
			ProductoDummy almacen3 = new ProductoDummy("Azucar", "almacen");
			ProductoDummy almacen4 = new ProductoDummy("Cafe", "almacen");
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			coca3.setPrecio(100);
			coca4.setPrecio(100);
			almacen1.setPrecio(100);
			almacen2.setPrecio(100);
			almacen3.setPrecio(100);
			almacen4.setPrecio(100);
			productos.add(coca1);
			productos.add(coca2);
			productos.add(coca3);
			productos.add(coca4);
			productos.add(almacen1);
			productos.add(almacen2);
			productos.add(almacen3);
			productos.add(almacen4);
			oferta.aplicarOfertas(productos);
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
			oferta.agregarMarca("CocaCola");
			ArrayList<Producto> productos = new ArrayList<Producto>();
			ProductoDummy coca1 = new ProductoDummy("CocaCola", "bebidas");
			ProductoDummy coca2 = new ProductoDummy("CocaCola", "bebidas");
			ProductoDummy coca3 = new ProductoDummy("CocaCola", "bebidas");
			ProductoDummy coca4 = new ProductoDummy("CocaCola", "bebidas");
			coca1.setPrecio(100);
			coca2.setPrecio(100);
			coca3.setPrecio(100);
			coca4.setPrecio(100);
			productos.add(coca1);
			productos.add(coca2);
			productos.add(coca3);
			productos.add(coca4);
			oferta.aplicarOfertas(productos);
			assertTrue(coca1.getPrecio() == 0);
			assertTrue(coca2.getPrecio() == 0);
			assertTrue(coca3.getPrecio() == 100);
			assertTrue(coca4.getPrecio() == 100);
		} catch (ExcepcionCantidadInvalida e) {
			e.getMessage();
		}
	}

}
