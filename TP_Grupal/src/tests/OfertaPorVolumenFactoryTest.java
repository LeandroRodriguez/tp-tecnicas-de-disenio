package tests;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.Producto;
import ofertas.Oferta;
import ofertas.OfertaPorVolumen;
import ofertas.OfertaPorVolumenFactory;

import org.junit.Test;

import persistencia.SerializarOfertas;
import excepciones.ExcepcionCantidadInvalida;

public class OfertaPorVolumenFactoryTest extends TestCase{

	@Test
	public void testPersistirUnaOferta() throws ExcepcionCantidadInvalida {
		Producto producto1 = new Producto("nombre1", "marca1", "categoria1", 10);
		Producto producto2 = new Producto("nombre2", "marca2", "categoria2", 20);
		OfertaPorVolumen oferta = new OfertaPorVolumen();
		oferta.addProducto(producto1, 1, 0);
		oferta.addProducto(producto2, 1, 1);

		ArrayList<OfertaPorVolumen> ofertas = new ArrayList<OfertaPorVolumen>();
		ofertas.add(oferta);

		SerializarOfertas serializador = new SerializarOfertas("ofertas_volumen_test.csv");
		serializador.serializarOfertasPorVolumen(ofertas, false);
		
		OfertaPorVolumenFactory factory = new OfertaPorVolumenFactory();
		factory.setNombreArchivo("ofertas_volumen_test.csv");
		
		factory.cargarOfertas();
		
		ArrayList<Oferta> ofertasCreadas = factory.getOfertas();
		
		boolean comparacion = true;
		for (int i = 0; i < ofertasCreadas.size(); ++i){
			if (! ofertas.get(i).equals((OfertaPorVolumen)ofertasCreadas.get(i))){
				comparacion = false;
				break;
			}
		}
		assertTrue(comparacion);	
	}

}
