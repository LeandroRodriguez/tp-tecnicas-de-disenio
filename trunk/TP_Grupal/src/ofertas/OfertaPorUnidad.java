package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.ProductosVendidos;
import ofertas.criterios.Criterio;

public class OfertaPorUnidad extends Oferta {
	
	private ArrayList<Criterio> criterios;
	private float porcentajeDescuento;
	
	public OfertaPorUnidad(){
		this.criterios = new ArrayList<Criterio>();
		this.porcentajeDescuento = 0;
	}

	public boolean equals(OfertaPorUnidad oferta){
		boolean comp = (this.porcentajeDescuento == oferta.getPorcentajeDescuento());
		if (!comp) return false;
		comp = (this.criterios.size() == oferta.getCriterios().size());
		if (!comp) return false;
		return true;
	}
	
	public List<Descuento> aplicarOferta(ArrayList<ProductosVendidos> productos) {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		for (ProductosVendidos producto : productos) {
			if (encajaEnOferta(producto)){
				descuentos.add(new DescuentoPorProducto(producto,porcentajeDescuento));
			}
		}
		return descuentos;
	}

	public boolean encajaEnOferta(ProductosVendidos producto) {
		for (Criterio criterio : criterios) {
			if ( ! criterio.aplicaSobre(producto)) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Criterio> getCriterios() {
		return criterios;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	public void agregarCriterio(Criterio criterio) {
		this.criterios.add(criterio);
	}

	public void setPorcentajeDescuento(float porcentajeDescuento){
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public void cumplirTodosLosCriterios() {
		// TODO Auto-generated method stub
		
	}
}
