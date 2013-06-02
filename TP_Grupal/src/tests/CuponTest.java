package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.Descuento;
import modelo.Producto;
import modelo.Venta;
import ofertas.Cupon;
import ofertas.CuponFactory;
import ofertas.OfertaPorUnidad;
import ofertas.criterios.CriterioPorMarca;

import org.junit.Test;

public class CuponTest extends TestCase{

	@Test
	public void testCrearUnCupon() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.agregarCriterio(new CriterioPorMarca("Coca Cola", true));
		oferta.setPorcentajeDescuento(10);
		Producto coca = new Producto("coca", "Coca Cola","bebidas", 10.0);
		Venta venta = new Venta();
		venta.setMedioDePago("efectivo");
		venta.agregarProducto(coca, 2);
		venta.aplicarOferta(oferta);
		CuponFactory cuponFactory = new CuponFactory();
		ArrayList<Cupon> cupones  = cuponFactory.buscarCupones(venta.getProductosVendidos());
		assertEquals(cupones.size(), 1);
	}

	@Test
	public void testValorDeCupon() {
		OfertaPorUnidad oferta = new OfertaPorUnidad();
		oferta.agregarCriterio(new CriterioPorMarca("Coca Cola", true));
		oferta.setPorcentajeDescuento(10);
		Producto coca = new Producto("coca", "Coca Cola","bebidas", 10.0);
		Venta venta = new Venta();
		venta.setMedioDePago("efectivo");
		venta.agregarProducto(coca, 2);
		venta.aplicarOferta(oferta);
		CuponFactory cuponFactory = new CuponFactory();
		ArrayList<Cupon> cupones  = cuponFactory.buscarCupones(venta.getProductosVendidos());
		Descuento descuento = cupones.get(0).aplicarDescuento(venta);
		assertEquals(descuento.getDescuento(), 4);
	}

}
