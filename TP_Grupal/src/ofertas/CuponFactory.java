package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import modelo.ProductoVendido;
import excepciones.ExcepcionCantidadInvalida;

public class CuponFactory {
	
	public ArrayList<Cupon> buscarCupones(List<ProductoVendido> list){
		ArrayList<Cupon> cupones = new ArrayList<Cupon>();
		for (ProductoVendido productoVendido : list){
			Producto producto = productoVendido.getProducto();
			Oferta oferta = buscarOferta(producto);
			if (oferta != null){
				Cupon cupon = new Cupon(0.2,oferta);
				cupones.add(cupon);
			}
		}
		return cupones;
	}
	
	public Oferta buscarOferta(Producto producto) {
		if (producto.getMarca().equals("Coca Cola")){
			OfertaPorVolumen ofertaCoca = new OfertaPorVolumen();
			try {
				ofertaCoca.addProducto(producto, 2, 1);
			} catch (ExcepcionCantidadInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ofertaCoca;
		} else {
			return null;
		}
	}

}
