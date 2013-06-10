package tp_supermarket.tests;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import tp_supermarket.bonificacion.BonificacionPuntos;
import tp_supermarket.bonificacion.BonificacionPuntosSobreTotal;
import tp_supermarket.producto.Producto;
import tp_supermarket.restriccion.Restriccion;
import tp_supermarket.restriccion.RestriccionNombreProducto;


public class TestPuntos {
	
	@Test
	public void testGenerarPuntos() {
		ArrayList<Restriccion> res = new ArrayList<Restriccion>();
		res.add(new RestriccionNombreProducto("Coca Cola"));
		BonificacionPuntos bonif = new BonificacionPuntos(5,res);
		Producto coca = new Producto(1, "Coca Cola", 10.0f);
		
		ArrayList<Producto> misproducts = new ArrayList<Producto>();
		misproducts.add(coca);
		misproducts.add(coca);
		misproducts.add(coca);
		ArrayList<Producto> descuentos = bonif.bonificar(misproducts, res);
		int total = 0;
		for (Producto descuento : descuentos) {
			total += descuento.getCosto();
		}
		
		Assert.assertEquals(15, total);
	}
	
	@Test
	public void testEscenario1TvFlatEntrega100Puntos() {
		ArrayList<Restriccion> restricciones = new ArrayList<Restriccion>();
		restricciones.add(new RestriccionNombreProducto("TV FLAT"));
		BonificacionPuntos bonif = new BonificacionPuntos(100, restricciones);
		Producto tv = new Producto(1, "TV FLAT", 10.0f);
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(tv);
		ArrayList<Producto> descuentos = bonif.bonificar(productos, restricciones);
		int total = 0;
		for (Producto descuento : descuentos) {
			total += descuento.getCosto();
		}
		
		Assert.assertEquals(100, total);
	}
	
	@Test
	public void testEscenario1DiezCocasEntregan1PuntoAlComprarDoce() {
		ArrayList<Restriccion> restricciones = new ArrayList<Restriccion>();
		restricciones.add(new RestriccionNombreProducto("Coca Cola", 10));
		BonificacionPuntos bonif = new BonificacionPuntos(1, restricciones);
		Producto coca = new Producto(1, "Coca Cola", 10.0f);
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		for(int i = 0; i < 12; i++)
			productos.add(coca);
		ArrayList<Producto> descuentos = bonif.bonificar(productos, restricciones);
		int total = 0;
		for (Producto descuento : descuentos) {
			total += descuento.getCosto();
		}
		
		Assert.assertEquals(1, total);
	}
	
	@Test
	public void testEscenario3Por110PesosSeReciben2Puntos() {
		BonificacionPuntosSobreTotal bonif = new BonificacionPuntosSobreTotal(50.0f);
		Producto maceta = new Producto(1, "Maceta", 6.0f);
		Producto coca = new Producto(1, "Coca Cola", 10.0f);
		Producto chocolate = new Producto(1, "Chocolate", 20.0f);
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(chocolate);
		for(int i = 0; i < 10; i++)
			productos.add(maceta);
		for(int i = 0; i < 3; i++)
			productos.add(coca);
		ArrayList<Producto> descuentos = bonif.bonificar(productos, null);
		int total = 0;
		for (Producto descuento : descuentos) {
			total += descuento.getCosto();
		}
		
		Assert.assertEquals(2, total);
	}	
	
	@Test
	public void testEscenario2SeCanjeanLos12Puntos() {
		TarjetaDePuntos tarjeta = new TarjetaDePuntos("cliente");
		tarjeta.sumarPuntos(12);
		float monto = 16;
		
		tarjeta.canjearPuntosSobreMonto(monto);
		
		Assert.assertEquals(0, tarjeta.getPuntos());
	}
	
	@Test
	public void testEscenario2SeDescuentan12PesosDelMonto() {
		TarjetaDePuntos tarjeta = new TarjetaDePuntos("cliente");
		tarjeta.sumarPuntos(12);
		float monto = 16;
		
		float nuevoMonto = tarjeta.canjearPuntosSobreMonto(monto);
		
		Assert.assertEquals(4, nuevoMonto, 1e-6);
	}
	
}
