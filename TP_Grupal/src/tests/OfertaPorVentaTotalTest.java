package tests;

import java.util.List;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import modelo.Venta;
import ofertas.OfertaPorVentaTotal;
import ofertas.criterios.CriterioPorMedioDePago;

import org.junit.Test;


public class OfertaPorVentaTotalTest extends TestCase{

	@Test
	public void testAplicarSobreMedioDePago() {
		OfertaPorVentaTotal oferta = new OfertaPorVentaTotal();
		oferta.agregarCriterio(new CriterioPorMedioDePago("efectivo", true));
		oferta.setPorcentajeDescuento(10);
		Producto coca = new Producto("coca", "coca","bebidas", 10.0);
		Venta venta = new Venta();
		venta.setMedioDePago("efectivo");
		venta.agregarProducto(coca, 2);
		assertTrue(oferta.encajaEnOferta(venta));
	}
	
	public void testNoAplicarSobreMedioDePago() {
		OfertaPorVentaTotal oferta = new OfertaPorVentaTotal();
		oferta.agregarCriterio(new CriterioPorMedioDePago("efectivo", false));
		oferta.setPorcentajeDescuento(10);
		Producto coca = new Producto("coca", "coca","bebidas", 10.0);
		Venta venta = new Venta();
		venta.setMedioDePago("efectivo");
		venta.agregarProducto(coca, 2);
		assertFalse(oferta.encajaEnOferta(venta));
	}


	@Test
	public void testAplicarDescuento() {
		OfertaPorVentaTotal oferta = new OfertaPorVentaTotal();
		oferta.agregarCriterio(new CriterioPorMedioDePago("efectivo", true));
		oferta.setPorcentajeDescuento(5);
		Producto coca = new Producto("coca", "coca","bebidas", 10.0);
		Venta venta = new Venta();
		venta.setMedioDePago("efectivo");
		venta.agregarProducto(coca, 2);
		
		List<Descuento> descuentos = oferta.aplicarOferta(venta);
		
		assertTrue(descuentos.get(0).getDescuento()==20*0.05);
	}
}
