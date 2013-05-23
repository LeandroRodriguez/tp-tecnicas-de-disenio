package ofertas;

import java.util.ArrayList;
import java.util.Calendar;

import modelo.Producto;

public class OfertaPorDia implements Oferta {
	
	private int dia;
	private double descuento;

	public OfertaPorDia(String dia, double descuento){
		if (dia.equals("domingo")) {
			this.dia = 1;
		} else if (dia.equals("lunes")) {
			this.dia = 2;
		} else if (dia.equals("martes")) {
			this.dia = 3;
		} else if (dia.equals("miercoles")) {
			this.dia = 4;
		} else if (dia.equals("jueves")) {
			this.dia = 5;
		} else if (dia.equals("viernes")) {
			this.dia = 6;
		} else {
			this.dia = 7;
		}
		this.descuento = descuento;
	}

	@Override
	public void aplicarOfertas(ArrayList<Producto> productos) {
		for (Producto producto: productos){
			if (encajaEnOferta(producto)){
				producto.setPrecio(producto.getPrecio()*(100-descuento)/100);
			}
		}
	}

	@Override
	public boolean encajaEnOferta(Producto producto) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		// If current day is Sunday, day=1
		if (this.dia == day){
			return true;
		} else 
			return false;
	}

}
