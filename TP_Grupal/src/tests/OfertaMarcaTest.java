package tests;

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
		assertTrue(oferta.esAplicable(coca));
	}

	@Test
	public void testAplicarDescuento() {
		OfertaMarca oferta = new OfertaMarca("coca",10);
		ProductoDummy coca = new ProductoDummy("coca","bebidas");
		coca.setPrecio(100);
		oferta.aplicarSobre(coca);
		assertTrue(coca.getPrecio()==90);
	}

}
