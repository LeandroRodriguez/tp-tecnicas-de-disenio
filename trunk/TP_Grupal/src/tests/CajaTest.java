package tests;

import static org.junit.Assert.*;

import java.util.Map;

import modelo.Caja;
import modelo.Producto;

import org.junit.Test;

public class CajaTest {

	@Test 
	public void testAbrirCajaOK() {
		Caja c = new Caja();
		
		boolean res = c.abrirCaja();
		
		assertTrue(res);
	}
	
	@Test
	public void testAbrirCajaYaAbierta() {
		Caja c = new Caja();
		c.abrirCaja();
		
		boolean res = c.abrirCaja();
		
		assertFalse(res);
	}

	@Test
	public void testCerrarCajaOK() {
		Caja c = new Caja();
		c.abrirCaja();
		
		boolean res = c.cerrarCaja();
		
		assertTrue(res);
	}
	
	@Test
	public void testCerrarCajaYaCerrada() {
		Caja c = new Caja();
		c.abrirCaja();
		c.cerrarCaja();
		
		boolean res = c.cerrarCaja();
		
		assertFalse(res);
	}
	
	@Test
	public void testCerrarCajaNoAbierta() {
		Caja c = new Caja();
		
		boolean res = c.cerrarCaja();
		
		assertFalse(res);
	}

	@Test
	public void testIniciarVentaOK() {
		Caja c = new Caja();
		c.abrirCaja();
		
		boolean res = c.iniciarVenta();
		
		assertTrue(res);
	}
	
	@Test
	public void testIniciarVentaYaIniciada() {
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		
		boolean res = c.iniciarVenta();
		
		assertFalse(res);
	}
	
	@Test
	public void testIniciarVentaCajaNoAbierta() {
		Caja c = new Caja();
		
		boolean res = c.iniciarVenta();
		
		assertFalse(res);
	}
	
	@Test
	public void testFinalizarVentaOK() {
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		
		boolean res = c.finalizarVenta();
		
		assertTrue(res);
	}
	
	@Test
	public void testFinalizarVentaYaFinalizada() {
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		c.finalizarVenta();
		
		boolean res = c.finalizarVenta();
		
		assertFalse(res);
	}
	
	@Test
	public void testFinalizarVentaNoIniciada() {
		Caja c = new Caja();
		c.abrirCaja();
		
		boolean res = c.finalizarVenta();
		
		assertFalse(res);
	}
	
	
	@Test
	public void testGetTotalVentaDeVentaNoIniciada() {
		Caja c = new Caja();
		c.abrirCaja();
		
		float res = c.getTotalVenta();
		
		float esperado = -1;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalVentaCajaNoAbierta() {
		Caja c = new Caja();
		
		float res = c.getTotalVenta();
		
		float esperado = -1;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalVentaSinVentas() {
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		
		float res = c.getTotalVenta();
		
		float esperado = 0;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalVentaUnProducto() {
		float precio = (float) 10;
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		Producto prod = getProductoDummy(precio);
		c.agregarProducto(prod);
		
		float res = c.getTotalVenta();
		
		float esperado = precio;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalVentaDosProductos() {
		float precio1 = (float) 1;
		float precio2 = (float) 55;
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		Producto prod1 = getProductoDummy(precio1, "Producto 1");
		c.agregarProducto(prod1);
		Producto prod2 = getProductoDummy(precio2, "Producto 2");
		c.agregarProducto(prod2);
		
		float res = c.getTotalVenta();
		
		assertEquals(1, prod1.getPrecio(), 0.001);
		assertEquals(55, prod2.getPrecio(), 0.001);
		float esperado = precio1 + precio2;
		float delta = (float) 0.001;
		assertEquals(esperado, res, delta);
	}
	
	@Test
	public void testGetTotalDescuentoVentaDeVentaNoIniciada() {
		Caja c = new Caja();
		c.abrirCaja();
		
		float res = c.getTotalDescuentosVenta();
		
		float esperado = -1;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalDescuentosVentaSinVentas() {
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		
		float res = c.getTotalDescuentosVenta();
		
		float esperado = 0;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}

	@Test
	public void testGetTotalVentasSinVentas() {
		Caja c = new Caja();
		
		float res = c.getTotalVentas();
		
		float esperado = 0;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalVentasUnaVenta() {
		float precio = (float) 10;
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		Producto prod = getProductoDummy(precio);
		c.agregarProducto(prod);
		c.finalizarVenta();
		
		float res = c.getTotalVentas();
		
		float esperado = precio;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalVentasDosVentas() {
		float precio1 = (float) 10;
		float precio2 = (float) 15;
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		Producto prod1 = getProductoDummy(precio1);
		c.agregarProducto(prod1);
		c.finalizarVenta();
		c.iniciarVenta();
		Producto prod2 = getProductoDummy(precio2);
		c.agregarProducto(prod2);
		c.finalizarVenta();
		
		float res = c.getTotalVentas();
		
		float esperado = precio1 + precio2;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalPorMedioDePagoSinVentas() {
		Caja c = new Caja();
		
		Map<String, Float> saldos = c.getTotalPorMedioDePago();
		boolean res = saldos.isEmpty();
		
		assertTrue(res);
	}
	
	@Test
	public void testGetTotalPorMedioDePagoUnaVenta() {
		String medioDePago = "Efectivo";
		float precio1 = (float) 10;
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		Producto prod1 = getProductoDummy(precio1);
		c.agregarProducto(prod1);
		c.setMedioDePago(medioDePago);
		c.finalizarVenta();
		
		Map<String, Float> saldos = c.getTotalPorMedioDePago();
		float res = saldos.get(medioDePago);
		
		float esperado = precio1;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalPorMedioDePagoDosVentas() {
		String medioDePago = "Efectivo";
		float precio1 = (float) 10;
		float precio2 = (float) 15;
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		Producto prod1 = getProductoDummy(precio1);
		c.agregarProducto(prod1);
		c.setMedioDePago(medioDePago);
		c.finalizarVenta();
		c.iniciarVenta();
		Producto prod2 = getProductoDummy(precio2);
		c.agregarProducto(prod2);
		c.setMedioDePago(medioDePago);
		c.finalizarVenta();
		
		Map<String, Float> saldos = c.getTotalPorMedioDePago();
		float res = saldos.get(medioDePago);
		
		float esperado = precio1 + precio2;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	@Test
	public void testGetTotalPorMedioDePagoDosMedios() {
		String medioDePago1 = "Efectivo";
		String medioDePago2 = "Debito";
		float precio1 = (float) 10;
		float precio2 = (float) 15;
		Caja c = new Caja();
		c.abrirCaja();
		c.iniciarVenta();
		Producto prod1 = getProductoDummy(precio1);
		c.agregarProducto(prod1);
		c.setMedioDePago(medioDePago1);
		c.finalizarVenta();
		c.iniciarVenta();
		Producto prod2 = getProductoDummy(precio2);
		c.agregarProducto(prod2);
		c.setMedioDePago(medioDePago2);
		c.finalizarVenta();
		
		Map<String, Float> saldos = c.getTotalPorMedioDePago();
		float res = saldos.get(medioDePago1);
		
		float esperado = precio1;
		float delta = (float) 0.001;
		assertEquals(res, esperado, delta);
	}
	
	public Producto getProductoDummy(double precio, String nombre) {
		return new Producto(nombre, "Marca","Categoria", precio);
	}
	
	public Producto getProductoDummy(double precio) {
		return getProductoDummy(precio, "Dummy");
	}
	
}
