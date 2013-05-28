package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import modelo.ProductoVendido;
import modelo.ProductosVendidos;
import ofertas.OfertaPorUnidad;
import ofertas.criterios.CriterioPorCategoria;
import ofertas.criterios.CriterioPorMarca;

import org.junit.Test;


public class OfertaPorUnidadTest extends TestCase{

	@Test
	public void testAplicarSobreMarca() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.agregarCriterio(new CriterioPorMarca("coca", true));
		oferta.setPorcentajeDescuento(10);
		Producto coca = new Producto("coca", "coca","bebidas", 10.0);
		ProductosVendidos vendido = new ProductoVendido(coca);
		assertTrue(oferta.encajaEnOferta(vendido));
	}

	@Test
	public void testAplicarSobreCategoria() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
		Producto coca = new Producto("coca", "coca","bebidas", 10.0);
		ProductosVendidos vendido = new ProductoVendido(coca);
		assertTrue(oferta.encajaEnOferta(vendido));
	}


	@Test
	public void testAplicarSobreMarcaYCategoria() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorMarca("CocaCola", true));
		oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
		oferta.cumplirTodosLosCriterios();
		Producto coca = new Producto("Coca", "CocaCola","bebidas", 10.0);
		Producto coca2 = new Producto("Coca", "CocaCola","bebidas dieteticas", 10.0);
		Producto coca3 = new Producto("Coca", "CocaCola Zero","bebidas", 10.0);
		ProductosVendidos vendido1 = new ProductoVendido(coca);
		ProductosVendidos vendido2 = new ProductoVendido(coca2);
		ProductosVendidos vendido3 = new ProductoVendido(coca3);
		assertTrue(oferta.encajaEnOferta(vendido1));
		assertFalse(oferta.encajaEnOferta(vendido2));
		assertFalse(oferta.encajaEnOferta(vendido3));
	}

	@Test
	public void testAplicarDescuento() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorMarca("coca", true));
		ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
		Producto coca = new Producto("Coca", "coca","bebidas", 10.0);
		coca.setPrecio(100);
		ProductosVendidos vendido = new ProductoVendido(coca);
		productos.add(vendido);
		List<Descuento> descuentos = oferta.aplicarOferta(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
		assertTrue(descuentos.get(0).getProducto().equals(vendido));
	}

	@Test
	public void testAplicarACategoriaExceptoMarca() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorCategoria("bebidas", true));
		oferta.agregarCriterio(new CriterioPorMarca("Chandon", false));
		ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
		Producto bebida1 = new Producto("Coca", "CocaCola","bebidas", 100.0);
		Producto bebida2 = new Producto("Coca", "Chandon","bebidas", 100.0);
		Producto bebida3 = new Producto("Coca", "Cordoba","bebidas", 100.0);
		Producto bebida4 = new Producto("Coca", "Pinky","bebidas", 100.0);
		Producto bebida5 = new Producto("Coca", "Frize","bebidas", 100.0);
		ProductosVendidos vendido1 = new ProductoVendido(bebida1);
		ProductosVendidos vendido2 = new ProductoVendido(bebida2);
		ProductosVendidos vendido3 = new ProductoVendido(bebida3);
		ProductosVendidos vendido4 = new ProductoVendido(bebida4);
		ProductosVendidos vendido5 = new ProductoVendido(bebida5);
		productos.add(vendido1);
		productos.add(vendido2);
		productos.add(vendido3);
		productos.add(vendido4);
		productos.add(vendido5);
		List<Descuento> descuentos = oferta.aplicarOferta(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
		assertTrue(descuentos.get(0).getProducto()==vendido1);
		assertTrue(descuentos.get(1).getDescuento()==10);
		assertTrue(descuentos.get(1).getProducto()==vendido3);
		assertTrue(descuentos.get(2).getDescuento()==10);
		assertTrue(descuentos.get(2).getProducto()==vendido4);
		assertTrue(descuentos.get(3).getDescuento()==10);
		assertTrue(descuentos.get(3).getProducto()==vendido5);
	}

	@Test
	public void testAplicarAMarcaExceptoCategoria() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.setPorcentajeDescuento(10);
		oferta.agregarCriterio(new CriterioPorCategoria("retornable", false));
		oferta.agregarCriterio(new CriterioPorMarca("CocaCola", true));
		ArrayList<ProductosVendidos> productos = new ArrayList<ProductosVendidos>();
		Producto bebida1 = new Producto("Coca", "CocaCola","bebidas", 100.0);
		Producto bebida2 = new Producto("Coca", "CocaCola","retornable", 100.0);
		Producto bebida3 = new Producto("Coca", "CocaCola","bebidas", 100.0);
		Producto bebida4 = new Producto("Coca", "CocaCola","retornable", 100.0);
		Producto bebida5 = new Producto("Coca", "CocaCola","bebidas", 100.0);
		bebida1.setPrecio(100);
		bebida2.setPrecio(100);
		bebida3.setPrecio(100);
		bebida4.setPrecio(100);
		bebida5.setPrecio(100);
		ProductosVendidos vendido1 = new ProductoVendido(bebida1);
		ProductosVendidos vendido2 = new ProductoVendido(bebida2);
		ProductosVendidos vendido3 = new ProductoVendido(bebida3);
		ProductosVendidos vendido4 = new ProductoVendido(bebida4);
		ProductosVendidos vendido5 = new ProductoVendido(bebida5);
		productos.add(vendido1);
		productos.add(vendido2);
		productos.add(vendido3);
		productos.add(vendido4);
		productos.add(vendido5);
		List<Descuento> descuentos = oferta.aplicarOferta(productos);
		assertTrue(descuentos.get(0).getDescuento()==10);
		assertTrue(descuentos.get(0).getProducto()==vendido1);
		assertTrue(descuentos.get(1).getDescuento()==10);
		assertTrue(descuentos.get(1).getProducto()==vendido3);
		assertTrue(descuentos.get(2).getDescuento()==10);
		assertTrue(descuentos.get(2).getProducto()==vendido5);
	}

}
