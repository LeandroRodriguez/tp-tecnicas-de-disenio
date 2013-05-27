package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import ofertas.OfertaIndividual;
import ofertas.OfertaIndividualFactory;

import org.junit.Test;

import persistencia.SerializarOfertas;

public class OfertaIndividualFactoryTest extends TestCase{

	@Test
	public void testPersistir() {
		OfertaIndividual ofertaInd1 = new OfertaIndividual();
		ofertaInd1.setValor(15);
		ofertaInd1.agregarMarca("CocaCola", true);
		ofertaInd1.agregarMarca("7Up", true);
		ofertaInd1.agregarMarca("Cordoba", true);

		OfertaIndividual ofertaInd2 = new OfertaIndividual();
		ofertaInd2.setValor(10);
		ofertaInd2.agregarCategoria("lacteos", true);
		ofertaInd2.agregarCategoria("congelados", true);
		ofertaInd2.agregarCategoria("pastas", true);

		OfertaIndividual ofertaInd3 = new OfertaIndividual();
		ofertaInd3.setValor(5);
		ofertaInd3.agregarCategoria("bebidas", true);
		ofertaInd3.agregarMarca("7Up", true);
		ofertaInd3.agregarCategoria("almacen", true);
		
		ArrayList<OfertaIndividual> ofertas = new ArrayList<OfertaIndividual>();
		ofertas.add(ofertaInd1);
		ofertas.add(ofertaInd2);
		ofertas.add(ofertaInd3);
		
		// Grabacion en disco
		SerializarOfertas serializador = new SerializarOfertas("ofertas_individuales_test.csv");
		serializador.serializarOfertasIndividuales(ofertas, false);
		
		OfertaIndividualFactory factory = new OfertaIndividualFactory();
		factory.setNombreArchivo("ofertas_individuales_test.csv");
		
		factory.cargarOfertas();
		
		ArrayList<OfertaIndividual> ofertasCreadas = factory.getOfertas();
		
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
