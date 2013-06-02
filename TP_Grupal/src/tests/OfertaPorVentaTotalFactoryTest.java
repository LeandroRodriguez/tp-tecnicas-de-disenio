package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import ofertas.Oferta;
import ofertas.OfertaPorVentaTotal;
import ofertas.OfertaPorVentaTotalFactory;
import ofertas.criterios.CriterioPorMedioDePago;

import org.junit.Test;

import persistencia.SerializarOfertas;

public class OfertaPorVentaTotalFactoryTest extends TestCase{

	@Test
	public void testPersistir() {
		OfertaPorVentaTotal ofertaInd1 = new OfertaPorVentaTotal();
		ofertaInd1.setPorcentajeDescuento(15);
		ofertaInd1.agregarCriterio(new CriterioPorMedioDePago("Tarjeta X",true));
		ofertaInd1.setPorcentajeDescuento(5);

		OfertaPorVentaTotal ofertaInd2 = new OfertaPorVentaTotal();
		ofertaInd2.agregarCriterio(new CriterioPorMedioDePago("Tarjeta Y",true));
		ofertaInd2.setPorcentajeDescuento(10);

		OfertaPorVentaTotal ofertaInd3 = new OfertaPorVentaTotal();
		ofertaInd3.agregarCriterio(new CriterioPorMedioDePago("Tarjeta Z",true));
		ofertaInd3.setPorcentajeDescuento(8);
		
		ArrayList<OfertaPorVentaTotal> ofertas = new ArrayList<OfertaPorVentaTotal>();
		ofertas.add(ofertaInd1);
		ofertas.add(ofertaInd2);
		ofertas.add(ofertaInd3);
		
		// Grabacion en disco
		SerializarOfertas serializador = new SerializarOfertas("ofertas_venta_total_test.csv");
		serializador.serializarOfertasPorVentaTotal(ofertas, false);
		
		OfertaPorVentaTotalFactory factory = new OfertaPorVentaTotalFactory();
		factory.setNombreArchivo("ofertas_venta_total_test.csv");
		
		factory.cargarOfertas();
		
		ArrayList<Oferta> ofertasCreadas = factory.getOfertas();
		
		boolean comparacion = true;
		for (int i = 0; i < ofertasCreadas.size(); ++i){
			if (! ofertas.get(i).equals( (OfertaPorVentaTotal) ofertasCreadas.get(i) ) ) {
				comparacion = false;
				break;
			}
		}
		assertTrue(comparacion);	
	}

}
