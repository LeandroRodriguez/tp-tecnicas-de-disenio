package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.Producto;
import ofertas.OfertaPorDia;
import ofertas.ProductoDummy;

import org.junit.Test;

public class OfertaPorDiaTest extends TestCase{

	@Test
	public void testJueves() {
		OfertaPorDia oferta = new OfertaPorDia("jueves", 10);
		ProductoDummy producto = new ProductoDummy("Coca","Bebidas");
		producto.setPrecio(100);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		oferta.aplicarOfertas(productos);
		assertEquals(producto.getPrecio(), 90.0d);
	}

}
