package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import ofertas.OfertaMarca;
import ofertas.ProductoDummy;

import org.junit.Test;

import productos.Producto;

public class OfertaMarcaTest extends TestCase{

	@Test
	public void testAplicarSobreProducto() {
		OfertaMarca oferta = new OfertaMarca("coca",10);
		Producto coca = new ProductoDummy("coca","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
	}

	@Test
	public void testAplicarSobreMarca() {
		OfertaMarca oferta = new OfertaMarca("coca",10);
		Producto coca = new ProductoDummy("coca","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
	}

	@Test
	public void testAplicarDescuento() {
		OfertaMarca oferta = new OfertaMarca("coca",10);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ProductoDummy coca = new ProductoDummy("coca","bebidas");
		productos.add(coca);
		coca.setPrecio(100);
		oferta.aplicarOfertas(productos);
		assertTrue(coca.getPrecio()==90);
		oferta.aplicarOfertas(productos);
		assertTrue(coca.getPrecio()==81);
	}

}
