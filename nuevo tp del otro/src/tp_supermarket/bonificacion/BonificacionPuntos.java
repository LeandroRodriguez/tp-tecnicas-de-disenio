package tp_supermarket.bonificacion;

import java.util.ArrayList;

import tp_supermarket.producto.Producto;
import tp_supermarket.restriccion.Restriccion;

public class BonificacionPuntos extends Bonificacion {

	private int puntos;
	private ArrayList<Restriccion> restricciones;
	
	public BonificacionPuntos(int puntos, ArrayList<Restriccion> restricciones) {
		this.puntos = puntos;
		this.restricciones = restricciones;
	}
	
	@Override
	public ArrayList<Producto> bonificar(ArrayList<Producto> misproducts,
			ArrayList<Restriccion> excepciones) {
		
		ArrayList<Producto> descuentos= new ArrayList<Producto>();
		for (Producto prod : misproducts) {
			//System.out.format("Pasa por el for\n");
			boolean cumple = true;
			for (Restriccion res : restricciones ) {
				if(res.isActiva())
					res.reset();
				if ( ! res.cumpleRestriccion(prod)) {
					cumple = false;
					break;
					//System.out.format("estoy en el if\n");
				}
			}
			if (cumple) {
				Producto nuevoDescuento = new Producto(0,"Bonificacion de puntos", puntos);
				descuentos.add(nuevoDescuento);
			}
		}
		return descuentos;
	}

}
