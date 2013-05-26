package ofertas.criterios;

import java.util.ArrayList;

import modelo.Producto;

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
	
	public void agregarCriterio(Criterio criterio){
		criterios.add(criterio);
	}
	
	public boolean aplica(Producto producto){
		if (cumplirTodos){
			return aplicanTodosLosCriterios(producto);
		} else{
			return aplicaAlgunCriterio(producto);
		}
	}
	
	private boolean aplicaAlgunCriterio(Producto producto){
		for (Criterio criterio : criterios) {
			if (criterio.aplicaSobre(producto)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean aplicanTodosLosCriterios(Producto producto){
		boolean aplicanTodosLosCriterios = true;
		for (Criterio criterio : criterios) {
			if (!criterio.aplicaSobre(producto)) {
				aplicanTodosLosCriterios = false;
			}
		}
		return aplicanTodosLosCriterios;
	}

	public void cumplirTodo() {
		cumplirTodos = true;
	}

	public void cumplirAlguno() {
		cumplirTodos = false;
	}

}
