package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.Producto;
import ofertas.OfertaPorVolumenYMarca;
import ofertas.ProductoDummy;

import org.junit.Test;

import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumenYMarcaTest extends TestCase{

	@Test
	public void testAplicarSobreProductos() {
		OfertaPorVolumenYMarca oferta;
		try {
			oferta = new OfertaPorVolumenYMarca("coca", 2, 1);
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
		OfertaPorVolumenYMarca oferta;
		try {
			oferta = new OfertaPorVolumenYMarca("CocaCola", 2, 1);
			ArrayList<Producto> productos = new ArrayList<Producto>();
			ProductoDummy coca1 = new ProductoDummy("1882", "bebidas");
			ProductoDummy coca2 = new ProductoDummy("Sprite", "bebidas");
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

}
