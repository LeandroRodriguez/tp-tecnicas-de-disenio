package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.ProductoVendido;
import modelo.ProductosVendidos;
import ofertas.OfertaPorUnidad;
import ofertas.ProductoDummy;
import ofertas.criterios.CriterioPorDia;

import org.junit.Test;

public class OfertaPorDiaTest extends TestCase{

	@Test
	public void testDia() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorDia("domingo", true, "domingo"));
		ProductoDummy producto = new ProductoDummy("Coca","Bebidas");
		producto.setPrecio(100);
		ProductosVendidos vendido = new ProductoVendido(producto);
		ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
		productos.add(vendido);
		List<Descuento> descuentos = oferta.aplicarOferta(productos);
		assertEquals(descuentos.get(0).getDescuento(), 10.0f);
	}

}
