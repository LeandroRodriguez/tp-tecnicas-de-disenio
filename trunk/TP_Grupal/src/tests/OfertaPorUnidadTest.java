package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import ofertas.OfertaPorUnidad;
import ofertas.ProductoDummy;
import ofertas.criterios.CriterioPorCategoria;
import ofertas.criterios.CriterioPorMarca;

import org.junit.Test;


public class OfertaPorUnidadTest extends TestCase{

	@Test
	public void testAplicarSobreMarca() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.agregarCriterio(new CriterioPorMarca("coca", true));
		oferta.setPorcentajeDescuento(10);
		Producto coca = new ProductoDummy("coca","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
	}

	@Test
	public void testAplicarSobreCategoria() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
		Producto coca = new ProductoDummy("coca","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
	}


	@Test
	public void testAplicarSobreMarcaYCategoria() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorMarca("CocaCola", true));
		oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
		oferta.cumplirTodosLosCriterios();
		Producto coca = new ProductoDummy("CocaCola","bebidas");
		Producto coca2 = new ProductoDummy("CocaCola","bebidas dieteticas");
		Producto coca3 = new ProductoDummy("CocaCola Zero","bebidas");
		assertTrue(oferta.encajaEnOferta(coca));
		assertFalse(oferta.encajaEnOferta(coca2));
		assertFalse(oferta.encajaEnOferta(coca3));
	}

	@Test
	public void testAplicarDescuento() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorMarca("coca", true));
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ProductoDummy coca = new ProductoDummy("coca","bebidas");
		coca.setPrecio(100);
		productos.add(coca);
		List<Descuento> descuentos = oferta.aplicarOfertas(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
		assertTrue(descuentos.get(0).getProducto().equals(coca));
	}

	@Test
	public void testAplicarACategoriaExceptoMarca() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
		oferta.agregarCriterio(new CriterioPorMarca("Chandon", false));
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ProductoDummy bebida1 = new ProductoDummy("CocaCola","bebidas");
		ProductoDummy bebida2 = new ProductoDummy("Chandon","bebidas");
		ProductoDummy bebida3 = new ProductoDummy("Cordoba","bebidas");
		ProductoDummy bebida4 = new ProductoDummy("Pinky","bebidas");
		ProductoDummy bebida5 = new ProductoDummy("Frize","bebidas");
		bebida1.setPrecio(100);
		bebida2.setPrecio(100);
		bebida3.setPrecio(100);
		bebida4.setPrecio(100);
		bebida5.setPrecio(100);
		productos.add(bebida1);
		productos.add(bebida2);
		productos.add(bebida3);
		productos.add(bebida4);
		productos.add(bebida5);
		List<Descuento> descuentos = oferta.aplicarOfertas(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
		assertTrue(descuentos.get(0).getProducto()==bebida1);
		assertTrue(descuentos.get(1).getDescuento()==10);
		assertTrue(descuentos.get(1).getProducto()==bebida3);
		assertTrue(descuentos.get(2).getDescuento()==10);
		assertTrue(descuentos.get(2).getProducto()==bebida4);
		assertTrue(descuentos.get(3).getDescuento()==10);
		assertTrue(descuentos.get(3).getProducto()==bebida5);
	}

	@Test
	public void testAplicarAMarcaExceptoCategoria() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorCategoria("retornable", false));
		oferta.agregarCriterio(new CriterioPorMarca("CocaCola", true));
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ProductoDummy bebida1 = new ProductoDummy("CocaCola","bebidas");
		ProductoDummy bebida2 = new ProductoDummy("CocaCola","retornable");
		ProductoDummy bebida3 = new ProductoDummy("CocaCola","bebidas");
		ProductoDummy bebida4 = new ProductoDummy("CocaCola","retornable");
		ProductoDummy bebida5 = new ProductoDummy("CocaCola","bebidas");
		bebida1.setPrecio(100);
		bebida2.setPrecio(100);
		bebida3.setPrecio(100);
		bebida4.setPrecio(100);
		bebida5.setPrecio(100);
		productos.add(bebida1);
		productos.add(bebida2);
		productos.add(bebida3);
		productos.add(bebida4);
		productos.add(bebida5);
		List<Descuento> descuentos = oferta.aplicarOfertas(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
		assertTrue(descuentos.get(0).getProducto()==bebida1);
		assertTrue(descuentos.get(1).getDescuento()==10);
		assertTrue(descuentos.get(1).getProducto()==bebida3);
		assertTrue(descuentos.get(2).getDescuento()==10);
		assertTrue(descuentos.get(2).getProducto()==bebida5);
	}

}
