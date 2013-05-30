package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import modelo.Descuento;
import modelo.Producto;
import modelo.ProductoVendido;

import ofertas.OfertaPorVolumen;
import org.junit.Test;

import excepciones.ExcepcionCantidadInvalida;


public class OfertaPorVolumenTest extends TestCase{

	@Test
	public void test2x1TieneDosBonificacionesParaCuatroProductos() throws ExcepcionCantidadInvalida {
		Producto producto = new Producto("nombre", "marca", "categoria", 10);
		ProductoVendido productosVendidos = new ProductoVendido(producto, 4);
		OfertaPorVolumen oferta = new OfertaPorVolumen();
		oferta.addProducto(producto, 2, 1);
		
		int bonificaciones = oferta.getBonificacionesPosibles(productosVendidos);
		
		assertEquals(2, bonificaciones);
	}
	
	@Test
	public void test2x1TieneElValorDeDescuentoDelProducto() throws ExcepcionCantidadInvalida {
		Producto producto = new Producto("nombre", "marca", "categoria", 10);
		OfertaPorVolumen oferta = new OfertaPorVolumen();
		oferta.addProducto(producto, 2, 1);
		
		float descuento = oferta.getValorDescuento();
		
		assertEquals(10, descuento, 1e-3);
	}
	
	@Test
	public void test2x1ConDosBonificacionesDaElDobleDeDescuento() throws ExcepcionCantidadInvalida {
		Producto producto = new Producto("nombre", "marca", "categoria", 10);
		ProductoVendido productosVendidos = new ProductoVendido(producto, 4);
		OfertaPorVolumen oferta = new OfertaPorVolumen();
		oferta.addProducto(producto, 2, 1);
		ArrayList<ProductoVendido> listaDeProductos = new ArrayList<ProductoVendido>();
		listaDeProductos.add(productosVendidos);
		
		List<Descuento> descuentos = oferta.aplicarOferta(listaDeProductos);
		
		assertEquals(20, descuentos.get(0).getDescuento(), 1e-3);
	}

}
