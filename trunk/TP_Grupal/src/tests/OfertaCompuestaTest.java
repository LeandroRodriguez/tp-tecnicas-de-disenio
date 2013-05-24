package tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import junit.framework.TestCase;

import modelo.Producto;

import ofertas.Oferta;
import ofertas.OfertaIndividual;
import ofertas.ProductoDummy;

import org.junit.Test;


public class OfertaCompuestaTest extends TestCase{

	@Test
	public void testTodasLasOfertasAplican() {
		OfertaDummy oferta1 = new OfertaDummy(true);
		OfertaDummy oferta2 = new OfertaDummy(true);
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		ofertas.add(oferta1);
		ofertas.add(oferta2);
		OfertaIndividual ofertaCompuesta = new OfertaIndividual(ofertas,10);
		ProductoDummy producto1 = new ProductoDummy("coca","bebidas");
		assertTrue(ofertaCompuesta.encajaEnOferta(producto1));
	}

	@Test
	public void testAlgunasOfertasAplican() {
		OfertaDummy oferta1 = new OfertaDummy(true);
		OfertaDummy oferta2 = new OfertaDummy(false);
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		ofertas.add(oferta1);
		ofertas.add(oferta2);
		OfertaIndividual ofertaCompuesta = new OfertaIndividual(ofertas,10);
		ProductoDummy producto1 = new ProductoDummy("coca","bebidas");
		assertFalse(ofertaCompuesta.encajaEnOferta(producto1));
	}

}
