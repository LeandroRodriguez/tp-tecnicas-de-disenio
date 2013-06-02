package tests;

import static org.junit.Assert.assertTrue;
import modelo.Producto;
import modelo.Venta;
import ofertas.OfertaPorVentaTotal;
import ofertas.criterios.CriterioPorDia;
import ofertas.criterios.CriterioPorPregunta;

import org.junit.Test;

import tests.utilidades.VistaDummy;

public class OfertaJubiladosTest {

	@Test
	public void testOfertaJubilados() {
		OfertaPorVentaTotal oferta = new OfertaPorVentaTotal();
		oferta.agregarCriterio(new CriterioPorDia("martes", true, "martes"));
		oferta.agregarCriterio(new CriterioPorPregunta("Es jubilado?", new VistaDummy(true)));
		oferta.setPorcentajeDescuento(10);
		Producto maceta = new Producto("Maceta", "Macetin", "ferreteria", 10.0);
		Producto lamparita = new Producto("Lampara", "Lamparin", "iluminacion", 15.0);
		Venta venta = new Venta();
		venta.setMedioDePago("efectivo");
		venta.agregarProducto(maceta, 1);
		venta.agregarProducto(lamparita, 2);
		venta.aplicarOferta(oferta);
		double neto = venta.getTotalNeto();
		assertTrue(neto == 40*0.9);
	}

	@Test
	public void testNoAplicaOfertaJubilados() {
		OfertaPorVentaTotal oferta = new OfertaPorVentaTotal();
		oferta.agregarCriterio(new CriterioPorDia("martes", true, "martes"));
		oferta.agregarCriterio(new CriterioPorPregunta("Es jubilado?", new VistaDummy(false)));
		oferta.setPorcentajeDescuento(10);
		Producto maceta = new Producto("Maceta", "Macetin", "ferreteria", 10.0);
		Producto lamparita = new Producto("Lampara", "Lamparin", "iluminacion", 15.0);
		Venta venta = new Venta();
		venta.setMedioDePago("efectivo");
		venta.agregarProducto(maceta, 1);
		venta.agregarProducto(lamparita, 2);
		venta.aplicarOferta(oferta);
		double neto = venta.getTotalNeto();
		assertTrue(neto == 40);
	}

}
