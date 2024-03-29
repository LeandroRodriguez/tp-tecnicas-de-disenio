package tp_supermarket.bonificacion;

import java.util.ArrayList;
import tp_supermarket.producto.*;
import tp_supermarket.restriccion.*;

public class BonificacionDescuentoCategoria extends Bonificacion {

	private final String categoria;
	private final float porcentaje;
	private boolean aplicada;
	private RestriccionCantidad cant;
	
	public BonificacionDescuentoCategoria(String cat, float p) {
		this.categoria = cat;
		this.porcentaje = p;
		this.aplicada = false;
		this.cant = new RestriccionCantidad(10000000);
	}

	public BonificacionDescuentoCategoria(String cat, float p, int cant) {
		this.categoria = cat;
		this.porcentaje = p;
		this.aplicada = false;
		this.cant = new RestriccionCantidad(cant);
	}

	@Override
	public ArrayList<Producto> bonificar(ArrayList<Producto> misproducts,
			ArrayList<Restriccion> excepciones) {
		ArrayList<Producto> descuentos = new ArrayList<Producto>();
		float result = 0;
		if (!aplicada) {
			for (int i = 0, j = 0; i < misproducts.size() && j < this.cant.getCantidad(); i++) {
				if (misproducts.get(i).getCategoria().equals(categoria)
						&& !isInExcepciones(excepciones, misproducts.get(i))) {
					result = misproducts.get(i).getCosto();
					float costo = result;
					float descuento = ((costo * porcentaje) / 100) * -1;
					Producto nuevoDescuento = new Producto(0, porcentaje
							+ " % en " + categoria + " prod: "
							+ misproducts.get(i).getNombre(), descuento);
					descuentos.add(nuevoDescuento);
					j++;
				}
			}
			aplicada = true;
		}
		return descuentos;
	}

}
