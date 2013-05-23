package tests;

import java.util.ArrayList;

import ofertas.OfertaPorMarcaYCategoria;
import ofertas.OfertaPorMarcaYCategoriaFactory;

import org.junit.Test;

public class OfertaPorMarcaYCategoriaTest {

	@Test
	public void testFactory() {
		// TODO
		OfertaPorMarcaYCategoriaFactory factory = new OfertaPorMarcaYCategoriaFactory();
		//factory.CrearArchivoOfertaPorMarcaYCategoria();
		
		//Queria ver que levantase bien el archivo. Despues habria que hacer testUnitarios correctos
		ArrayList<OfertaPorMarcaYCategoria> ofertas = factory.getOfertas();
		
		OfertaPorMarcaYCategoria primerOferta = ofertas.get(0);
		ArrayList<String> marcasIncluidas = primerOferta.getMarcasIncluidas();
		ArrayList<String> marcasExcluidas = primerOferta.getMarcasExcluidas();
		ArrayList<String> categoriasIncluidas = primerOferta.getCategoriasIncluidas();
		ArrayList<String> categoriasExcluidas = primerOferta.getCategoriasExcluidas();
		
		System.out.println("Marcas Incluidas:");
		for (String marcaIncluida : marcasIncluidas) {
			System.out.println(marcaIncluida);
		}
		System.out.println("Marcas Excluidas:");
		for (String marcasExcluida : marcasExcluidas) {
			System.out.println(marcasExcluida);
		}
		System.out.println("Categorias Incluidas:");
		for (String categoriasIncluida : categoriasIncluidas) {
			System.out.println(categoriasIncluida);
		}
		System.out.println("Categorias Excluidas:");
		for (String categoriasExcluida : categoriasExcluidas) {
			System.out.println(categoriasExcluida);
		}
		
	}

}
