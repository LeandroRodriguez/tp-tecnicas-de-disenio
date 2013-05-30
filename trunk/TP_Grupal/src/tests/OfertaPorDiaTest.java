package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.ProductoVendido;
import ofertas.OfertaPorUnidad;
import modelo.Producto;
import ofertas.criterios.CriterioPorDia;

import org.junit.Test;

public class OfertaPorDiaTest extends TestCase{

	@Test
	public void testDia() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorDia("miercoles", true, "miercoles"));
		Producto producto = new Producto("Coca Cola 1.5L", "Coca","Bebidas", 50.0);
		ProductoVendido vendido = new ProductoVendido(producto);
		ArrayList<ProductoVendido> productos = new ArrayList<ProductoVendido>();
		productos.add(vendido);
		List<Descuento> descuentos = oferta.aplicarOferta(productos);
		assertEquals(descuentos.get(0).getDescuento(), 5.0f);
	}

}
