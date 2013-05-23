package ofertas;

import java.util.ArrayList;

import productos.Producto;

public class OfertaPorMarcaYCategoria extends Oferta {

	private ArrayList<String> marcas = new ArrayList<String>();
	private ArrayList<String> categorias = new ArrayList<String>();

	private float descuento;
	
	
	public OfertaPorMarcaYCategoria(ArrayList<String> marcas, ArrayList<String> categorias, float descuento){
		this.marcas = marcas;
		this.categorias = categorias;
		this.descuento = descuento;
	}
	
	public ArrayList<String> getMarcasIncluidas() {
		ArrayList<String> marcasIncluidas = new ArrayList<String>();
		for (String marca : this.marcas) {
			String signoMarca = marca.substring(0,1);
			if(signoMarca.equals("+")){
				//le corto el signo y agrego la marca a la lista
				String marcaIncluida = marca.substring(1); 
				marcasIncluidas.add(marcaIncluida);
			}
		}
		return marcasIncluidas;
	}
	
	public ArrayList<String> getMarcasExcluidas() {
		ArrayList<String> marcasExcluidas = new ArrayList<String>();
		for (String marca : this.marcas) {
			String signoMarca = marca.substring(0,1);
			if(signoMarca.equals("-")){
				//le corto el signo y agrego la marca a la lista
				String marcaExcluidas = marca.substring(1); 
				marcasExcluidas.add(marcaExcluidas);
			}
		}
		return marcasExcluidas;
	}

	public void setMarcas(ArrayList<String> marcas) {
		this.marcas = marcas;
	}

	public ArrayList<String> getCategoriasIncluidas() {
		ArrayList<String> categoriasIncluidas = new ArrayList<String>();
		for (String categoria : this.categorias) {
			String signoCategoria = categoria.substring(0,1);
			if(signoCategoria.equals("+")){
				//le corto el signo y agrego la categoria a la lista
				String categoriaIncluidas = categoria.substring(1); 
				categoriasIncluidas.add(categoriaIncluidas);
			}
		}
		return categoriasIncluidas;
	}
	
	public ArrayList<String> getCategoriasExcluidas() {
		ArrayList<String> categoriasExcluidas = new ArrayList<String>();
		for (String categoria : this.categorias) {
			String signoCategoria = categoria.substring(0,1);
			if(signoCategoria.equals("-")){
				//le corto el signo y agrego la categoria a la lista
				String categoriaExcluidas = categoria.substring(1); 
				categoriasExcluidas.add(categoriaExcluidas);
			}
		}
		return categoriasExcluidas;
	}

	public void setCategorias(ArrayList<String> categorias) {
		this.categorias = categorias;
	}
	
	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	
	//Por mas que esto no vaya aca, lo pongo para que se vea cual es mi idea
	public void aplicarOfertas(ArrayList<Producto> productos){
		//en productos recibiria la interseccion de la lista de productos comprados con la lista de productos 
		//a los que ya se les aplico un descuento
		for (Producto producto : productos) {
			if(this.encajaEnOferta(producto)){
				//APLICO EL DESCUENTO SOBRE EL PRODUCTO, Y LO AGREGO A LA LISTA DE PRODUCTOS A LOS QUE YA SE LES APLICO
			}
		}
		
	}
	
	public boolean encajaEnOferta(Producto producto){
		String marca = producto.getMarca();
		String categoria = producto.getCategoria();
		
		ArrayList<String> marcasIncluidas = this.getMarcasIncluidas();
		ArrayList<String> marcasExcluidas = this.getMarcasExcluidas();
		ArrayList<String> categoriasIncluidas = this.getCategoriasIncluidas();
		ArrayList<String> categoriasExcluidas = this.getCategoriasExcluidas();
		
		boolean encajaMarca = (marcasIncluidas.contains(marca) && !categoriasExcluidas.contains(categoria)); 
		boolean encajaCategoria = (categoriasIncluidas.contains(categoria) && !marcasExcluidas.contains(marca));
		if(encajaMarca || encajaCategoria){
			return true;
		}
		return false;
	}
	
	
}
