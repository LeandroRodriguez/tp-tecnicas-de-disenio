package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.ProductoVendido;
import modelo.Venta;
import ofertas.criterios.Criterio;
import ofertas.criterios.ListaDeCriterios;

public class OfertaPorUnidad extends Oferta {
	
	private ListaDeCriterios criterios;
	private float porcentajeDescuento;
	
	public OfertaPorUnidad(){
		this.criterios = new ListaDeCriterios();
		this.porcentajeDescuento = 0;
	}

	public boolean equals(OfertaPorUnidad oferta){
		boolean comp = (this.porcentajeDescuento == oferta.getPorcentajeDescuento());
		if (!comp) return false;
		comp = (this.criterios.equals(oferta.getCriterios()));
		if (!comp) return false;
		return true;
	}
	
	public List<Descuento> aplicarOferta(Venta venta) {
		List<ProductoVendido> productos = venta.getProductosVendidos();
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		for (ProductoVendido producto : productos) {
			if (encajaEnOferta(producto)){
				descuentos.add(new DescuentoPorProducto(producto,porcentajeDescuento));
			}
		}
		return descuentos;
	}

	public boolean encajaEnOferta(ProductoVendido producto) {
		return criterios.aplica(producto);
	}

	public ListaDeCriterios getCriterios() {
		return criterios;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	public void agregarCriterio(Criterio criterio) {
		this.criterios.agregarCriterio(criterio);
	}

	public void setPorcentajeDescuento(float porcentajeDescuento){
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public void cumplirTodosLosCriterios() {
		// TODO Auto-generated method stub
		
	}
}
