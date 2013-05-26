package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import ofertas.OfertaIndividual;
import ofertas.ProductoDummy;
import ofertas.criterios.Criterio;
import ofertas.criterios.SeleccionarPorMarca;

import org.junit.Test;


public class OfertaIndividualTest extends TestCase{

	@Test
	public void testAplicarSobreMarca() {
		OfertaIndividual oferta = new OfertaIndividual();
		oferta.agregarMarca("coca");
		oferta.setValor(10);
		Producto coca = new ProductoDummy("coca","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
	}

	@Test
	public void testAplicarSobreCategoria() {
		OfertaIndividual oferta = new OfertaIndividual();
		oferta.setValor(10);
		oferta.agregarCategoria("bebidas");
		Producto coca = new ProductoDummy("coca","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
	}

	@Test
	public void testAplicarDescuento() {
		ArrayList<Criterio> criterios = new ArrayList<Criterio>();
		Criterio criterio = new SeleccionarPorMarca("coca");
		criterios.add(criterio);
		OfertaIndividual oferta = new OfertaIndividual();
		oferta.setValor(10);
		oferta.agregarMarca("coca");
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ProductoDummy coca = new ProductoDummy("coca","bebidas");
		productos.add(coca);
		coca.setPrecio(100);
		List<Descuento> descuentos = oferta.aplicarOfertas(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
	}

}
