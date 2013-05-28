package ofertas.criterios;

import java.util.ArrayList;

import modelo.ProductosVendidos;

public class ListaDeCriterios {
	
	private ArrayList<Criterio> criterios;
	private boolean cumplirTodos;
	
	/**
	 * Lista de criterios que las ofertas deben aplicar
	 * pueden ser del tipo "Cumplir todos" o "Cumplir al menos uno"
	 */
	public ListaDeCriterios(){
		criterios = new ArrayList<Criterio>();
		cumplirTodos = true;
	}
	
	public boolean equals(Object lista){
		if(!(lista instanceof ListaDeCriterios))
			return false;
		ListaDeCriterios _lista = (ListaDeCriterios) lista;
		return (criterios.size() == _lista.criterios.size());
	}
	
	public void agregarCriterio(Criterio criterio){
		criterios.add(criterio);
	}
	
	public boolean aplica(ProductosVendidos producto){
		if (cumplirTodos){
			return aplicanTodosLosCriterios(producto);
		} else{
			return aplicaAlgunCriterio(producto);
		}
	}
	
	private boolean aplicaAlgunCriterio(ProductosVendidos producto){
		for (Criterio criterio : criterios) {
			if (criterio.aplicaSobre(producto)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean aplicanTodosLosCriterios(ProductosVendidos producto){
		for (Criterio criterio : criterios) {
			if ( ! criterio.aplicaSobre(producto)) {
				return false;
			}
		}
		return true;
	}

	public void cumplirTodo() {
		cumplirTodos = true;
	}

	public void cumplirAlguno() {
		cumplirTodos = false;
	}

	public ArrayList<Criterio> getLista() {
		return criterios;
	}

	public void setLista(ArrayList<Criterio> criterios) {
		this.criterios = criterios;
	}

}
