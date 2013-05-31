package ofertas.criterios;

import vista.Vista;
import modelo.Venta;

public class CriterioPorPregunta implements CriterioVentaTotal {
	
	String pregunta;
	boolean respuesta;
	
	public CriterioPorPregunta(String pregunta){
		this.pregunta = pregunta;
	}

	@Override
	public boolean aplicaSobre(Venta venta) {
		Vista vista = new Vista();
		return vista.pedirConfirmacion(pregunta);
	}

	@Override
	public void setExcluyente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncluyente() {
		// TODO Auto-generated method stub
		
	}

}
