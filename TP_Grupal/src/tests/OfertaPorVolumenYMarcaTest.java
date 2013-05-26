package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.Producto;
import ofertas.OfertaPorVolumen;
import ofertas.ProductoDummy;

import org.junit.Test;

import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumenYMarcaTest extends TestCase{

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
			oferta.aplicarOfertas(productos);
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
			oferta.aplicarOfertas(productos);
			assertTrue(coca2.getPrecio() == 100);
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
