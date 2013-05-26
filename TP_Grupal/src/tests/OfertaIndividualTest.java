package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import ofertas.OfertaIndividual;
import ofertas.ProductoDummy;

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
	public void testAplicarSobreMarcaYCategoria() {
		OfertaIndividual oferta = new OfertaIndividual();
		oferta.setValor(10);
		oferta.agregarMarca("CocaCola");
		oferta.agregarCategoria("bebidas");
		Producto coca = new ProductoDummy("CocaCola","bebidas");
		Producto coca2 = new ProductoDummy("CocaCola","bebidas dieteticas");
		Producto coca3 = new ProductoDummy("CocaCola Zero","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
		assertFalse(oferta.encajaEnOferta(coca2));
		assertFalse(oferta.encajaEnOferta(coca3));
	}

	@Test
	public void testAplicarDescuento() {
		OfertaIndividual oferta = new OfertaIndividual();
		oferta.setValor(10);
		oferta.agregarMarca("coca");
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ProductoDummy coca = new ProductoDummy("coca","bebidas");
		coca.setPrecio(100);
		productos.add(coca);
		List<Descuento> descuentos = oferta.aplicarOfertas(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
		assertTrue(descuentos.get(0).getProducto().equals(coca));
	}

}
