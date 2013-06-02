package ofertas.criterios;

import vista.Vista;
import modelo.Venta;

public class CriterioPorPregunta implements CriterioVentaTotal {
	
	String pregunta;
	boolean respuesta;
	Vista vista;
	
	public CriterioPorPregunta(String pregunta){
		this.pregunta = pregunta;
		respuesta = false;
	}
	
	public CriterioPorPregunta(String pregunta, Vista vista){
		this.pregunta = pregunta;
		this.respuesta = false;
		this.vista = vista;
	}
	
	public boolean getRespuesta(){
		return respuesta;
	}

	@Override
	public boolean aplicaSobre(Venta venta) {
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
