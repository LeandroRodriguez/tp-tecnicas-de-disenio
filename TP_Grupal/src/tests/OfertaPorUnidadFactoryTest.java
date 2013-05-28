package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import ofertas.OfertaPorUnidad;
import ofertas.OfertaPorUnidadFactory;
import ofertas.criterios.CriterioPorCategoria;
import ofertas.criterios.CriterioPorMarca;

import org.junit.Test;

import persistencia.SerializarOfertas;

public class OfertaPorUnidadFactoryTest extends TestCase{

	@Test
	public void testPersistir() {
		OfertaPorUnidad ofertaInd1 = new OfertaPorUnidad();
		ofertaInd1.setPorcentajeDescuento(15);
		ofertaInd1.agregarCriterio(new CriterioPorMarca("CocaCola", true));
		ofertaInd1.agregarCriterio(new CriterioPorMarca("7Up", true));
		ofertaInd1.agregarCriterio(new CriterioPorMarca("Cordoba", true));

		OfertaPorUnidad ofertaInd2 = new OfertaPorUnidad();
		ofertaInd2.setPorcentajeDescuento(10);
		ofertaInd2.agregarCriterio(new CriterioPorCategoria("lacteos", true));
		ofertaInd2.agregarCriterio(new CriterioPorCategoria("congelados", true));
		ofertaInd2.agregarCriterio(new CriterioPorCategoria("pastas", true));

		OfertaPorUnidad ofertaInd3 = new OfertaPorUnidad();
		ofertaInd3.setPorcentajeDescuento(5);
		ofertaInd3.agregarCriterio(new CriterioPorCategoria("bebidas", true));
		ofertaInd3.agregarCriterio(new CriterioPorMarca("7Up", true));
		ofertaInd3.agregarCriterio(new CriterioPorCategoria("almacen", true));
		
		ArrayList<OfertaPorUnidad> ofertas = new ArrayList<OfertaPorUnidad>();
		ofertas.add(ofertaInd1);
		ofertas.add(ofertaInd2);
		ofertas.add(ofertaInd3);
		
		// Grabacion en disco
		SerializarOfertas serializador = new SerializarOfertas("ofertas_individuales_test.csv");
		serializador.serializarOfertasPorUnidad(ofertas, false);
		
		OfertaPorUnidadFactory factory = new OfertaPorUnidadFactory();
		factory.setNombreArchivo("ofertas_individuales_test.csv");
		
		factory.cargarOfertas();
		
		ArrayList<OfertaPorUnidad> ofertasCreadas = factory.getOfertas();
		
		boolean comparacion = true;
		for (int i = 0; i < ofertasCreadas.size(); ++i){
			if (! ofertas.get(i).equals(ofertasCreadas.get(i))){
				comparacion = false;
				break;
			}
		}
		assertTrue(comparacion);	
	}

}
