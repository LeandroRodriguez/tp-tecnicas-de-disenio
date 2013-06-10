package tp_supermarket.bonificacion;

import java.util.ArrayList;

import tp_supermarket.producto.Producto;
import tp_supermarket.restriccion.Restriccion;



public class BonificacionPuntosSobreTotal extends Bonificacion {
	
	private float valorPorPunto;
	
	public BonificacionPuntosSobreTotal(float valorPorPunto) {
		this.valorPorPunto = valorPorPunto;
	}
	
	@Override
	public ArrayList<Producto> bonificar(ArrayList<Producto> misproducts,
			ArrayList<Restriccion> excepciones) {
		
		ArrayList<Producto> descuentos= new ArrayList<Producto>();
		float valorTotal = 0;
		for (Producto prod : misproducts) {
			valorTotal += prod.getCosto();
		}
		int puntos = (int) (valorTotal / valorPorPunto);
		Producto nuevoDescuento = new Producto(0,"Bonificacion de puntos", puntos);
		descuentos.add(nuevoDescuento);
		
		return descuentos;
	}

}
