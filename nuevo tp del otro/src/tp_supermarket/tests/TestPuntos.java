package tp_supermarket.tests;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import tp_supermarket.bonificacion.BonificacionPuntos;
import tp_supermarket.producto.Producto;
import tp_supermarket.restriccion.Restriccion;
import tp_supermarket.restriccion.RestriccionNombreProducto;

import static org.junit.Assert.*;


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
		System.out.format("%d\n", descuentos.size());
		for (Producto descuento : descuentos) {
			total += descuento.getCosto();
		}
		
		Assert.assertEquals(15, total);
	}
	
	
}
