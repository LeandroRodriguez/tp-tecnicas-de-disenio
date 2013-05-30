package ofertas.criterios;

import java.util.ArrayList;

import modelo.Venta;

public class ListaDeCriteriosVentaTotal {
	
	private ArrayList<CriterioVentaTotal> criterios;
	private boolean cumplirTodos;
	
	/**
	 * Lista de criterios que las ofertas deben aplicar
	 * pueden ser del tipo "Cumplir todos" o "Cumplir al menos uno"
	 */
	public ListaDeCriteriosVentaTotal(){
		criterios = new ArrayList<CriterioVentaTotal>();
		cumplirTodos = true;
	}
	
	public boolean equals(Object lista){
		if(!(lista instanceof ListaDeCriteriosVentaTotal))
			return false;
		ListaDeCriteriosVentaTotal _lista = (ListaDeCriteriosVentaTotal) lista;
		return (criterios.size() == _lista.criterios.size());
	}
	
	public void agregarCriterio(CriterioVentaTotal criterio){
		criterios.add(criterio);
	}
	
	public boolean aplica(Venta venta){
		if (cumplirTodos){
			return aplicanTodosLosCriterios(venta);
		} else{
			return aplicaAlgunCriterio(venta);
		}
	}
	
	private boolean aplicaAlgunCriterio(Venta venta){
		for (CriterioVentaTotal criterio : criterios) {
			if (criterio.aplicaSobre(venta)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean aplicanTodosLosCriterios(Venta venta){
		for (CriterioVentaTotal criterio : criterios) {
			if ( ! criterio.aplicaSobre(venta)) {
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

	public ArrayList<CriterioVentaTotal> getLista() {
		return criterios;
	}

	public void setLista(ArrayList<CriterioVentaTotal> criterios) {
		this.criterios = criterios;
	}

}
