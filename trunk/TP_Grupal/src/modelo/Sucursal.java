package modelo;

import java.util.ArrayList;

public class Sucursal {
	
	private Caja caja;
	private ArrayList<Producto> productos;
	
	public Sucursal() {
		caja = new Caja();
		cargarProductos();
	}
	
	public void cargarProductos() {
		LectorProductos lector =  new LectorProductos();
		productos = lector.cargarProductos();
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	public Caja getCaja() {
		return caja;
	}

	public void agregarProducto(int indiceProducto, int cantidad) {
		caja.agregarProducto( productos.get(indiceProducto), cantidad);
	}

	public float getTotalDescuentos() {
		return caja.getTotalDescuentos();
	}

	public float getTotalVentas() {
		return caja.getTotalVentas();
	}
}
