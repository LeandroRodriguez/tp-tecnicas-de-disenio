package tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import junit.framework.TestCase;
import ofertas.OfertaIndividual;
import ofertas.OfertaIndividualFactory;
import ofertas.OfertaPorMarcaYCategoria;

import org.junit.Test;

import persistencia.SerializarOfertas;

import com.google.gson.Gson;

public class OfertaIndividualFactoryTest extends TestCase{

	@Test
	public void testPersistir() {
		OfertaIndividual ofertaInd1 = new OfertaIndividual();
		ofertaInd1.setValor(15);
		ofertaInd1.agregarMarca("CocaCola");
		ofertaInd1.agregarMarca("7Up");
		ofertaInd1.agregarMarca("Cordoba");

		OfertaIndividual ofertaInd2 = new OfertaIndividual();
		ofertaInd2.setValor(10);
		ofertaInd2.agregarCategoria("lacteos");
		ofertaInd2.agregarCategoria("congelados");
		ofertaInd2.agregarCategoria("pastas");

		OfertaIndividual ofertaInd3 = new OfertaIndividual();
		ofertaInd3.setValor(5);
		ofertaInd3.agregarCategoria("bebidas");
		ofertaInd3.agregarMarca("7Up");
		ofertaInd3.agregarCategoria("almacen");
		
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
