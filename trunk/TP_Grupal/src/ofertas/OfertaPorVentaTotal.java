package ofertas;

import java.util.ArrayList;
import java.util.List;

import modelo.Descuento;
import modelo.ProductoVendido;
import modelo.Venta;
import ofertas.criterios.CriterioPorMedioDePago;
import ofertas.criterios.CriterioVentaTotal;
import ofertas.criterios.ListaDeCriteriosVentaTotal;

import com.google.gson.Gson;

public class OfertaPorVentaTotal implements OfertaDeProductos {
	
	private ListaDeCriteriosVentaTotal criterios;
	private float porcentajeDescuento;
	
	public OfertaPorVentaTotal(){
		this.criterios = new ListaDeCriteriosVentaTotal();
		this.porcentajeDescuento = 0;
	}

	public boolean equals(OfertaPorVentaTotal oferta){
		boolean comp = (this.porcentajeDescuento == oferta.getPorcentajeDescuento());
		if (!comp) return false;
		comp = (this.criterios.equals(oferta.getCriterios()));
		if (!comp) return false;
		return true;
	}
	
	public List<Descuento> aplicarOferta(Venta venta) {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		if (encajaEnOferta(venta)){
			descuentos.add(new DescuentoPorVentaTotal(venta,porcentajeDescuento));
		}
		return descuentos;
	}

	public boolean encajaEnOferta(Venta venta) {
		return criterios.aplica(venta);
	}

	public ListaDeCriteriosVentaTotal getCriterios() {
		return criterios;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	public void agregarCriterio(CriterioVentaTotal criterio) {
		this.criterios.agregarCriterio(criterio);
	}

	public void setPorcentajeDescuento(float porcentajeDescuento){
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public void cumplirTodosLosCriterios() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean encajaEnOferta(ProductoVendido producto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void cargarDeArchivo(String datos){
		Gson gson = new Gson();
		criterios = new ListaDeCriteriosVentaTotal();
		String criteriosYPorcentaje[] = datos.split("/");
		String criterios[] = criteriosYPorcentaje[0].split("&");
		for (String criterio : criterios){
			if (criterio.length() == 0) continue;
			CriterioPorMedioDePago c = gson.fromJson(criterio, CriterioPorMedioDePago.class);
			this.criterios.agregarCriterio(c);
		}
		this.porcentajeDescuento = Float.parseFloat(criteriosYPorcentaje[1]);
	}
	
}
