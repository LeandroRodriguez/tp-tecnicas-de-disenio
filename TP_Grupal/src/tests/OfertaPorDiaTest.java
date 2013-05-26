package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import ofertas.OfertaIndividual;
import ofertas.ProductoDummy;

import org.junit.Test;

public class OfertaPorDiaTest extends TestCase{

	@Test
	public void testJueves() {
		OfertaIndividual oferta = new OfertaIndividual();
		oferta.setValor(10);
		oferta.agregarDia("Domingo");
		ProductoDummy producto = new ProductoDummy("Coca","Bebidas");
		producto.setPrecio(100);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		List<Descuento> descuentos = oferta.aplicarOfertas(productos);
		assertEquals(descuentos.get(0).getDescuento(), 10.0f);
	}

}
