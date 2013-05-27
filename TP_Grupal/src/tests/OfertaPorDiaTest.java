package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import ofertas.OfertaPorUnidad;
import ofertas.ProductoDummy;
import ofertas.criterios.SeleccionarPorDia;

import org.junit.Test;

public class OfertaPorDiaTest extends TestCase{

	@Test
	public void testDia() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new SeleccionarPorDia("domingo", true));
		ProductoDummy producto = new ProductoDummy("Coca","Bebidas");
		producto.setPrecio(100);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(producto);
		List<Descuento> descuentos = oferta.aplicarOfertas(productos);
		assertEquals(descuentos.get(0).getDescuento(), 10.0f);
	}

}
