package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import ofertas.OfertaPorUnidad;
import ofertas.OfertaPorUnidadFactory;
import ofertas.criterios.SeleccionarPorCategoria;
import ofertas.criterios.SeleccionarPorMarca;

import org.junit.Test;

import persistencia.SerializarOfertas;

public class OfertaPorUnidadFactoryTest extends TestCase{

	@Test
	public void testPersistir() {
		OfertaPorUnidad ofertaInd1 = new OfertaPorUnidad();
		ofertaInd1.setPorcentajeDescuento(15);
		ofertaInd1.agregarCriterio(new SeleccionarPorMarca("CocaCola", true));
		ofertaInd1.agregarCriterio(new SeleccionarPorMarca("7Up", true));
		ofertaInd1.agregarCriterio(new SeleccionarPorMarca("Cordoba", true));

		OfertaPorUnidad ofertaInd2 = new OfertaPorUnidad();
		ofertaInd2.setPorcentajeDescuento(10);
		ofertaInd2.agregarCriterio(new SeleccionarPorCategoria("lacteos", true));
		ofertaInd2.agregarCriterio(new SeleccionarPorCategoria("congelados", true));
		ofertaInd2.agregarCriterio(new SeleccionarPorCategoria("pastas", true));

		OfertaPorUnidad ofertaInd3 = new OfertaPorUnidad();
		ofertaInd3.setPorcentajeDescuento(5);
		ofertaInd3.agregarCriterio(new SeleccionarPorCategoria("bebidas", true));
		ofertaInd3.agregarCriterio(new SeleccionarPorMarca("7Up", true));
		ofertaInd3.agregarCriterio(new SeleccionarPorCategoria("almacen", true));
		
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
