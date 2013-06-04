package ofertas.criterios;

import modelo.MediadorPregunta;
import modelo.Venta;

public class CriterioPorPregunta implements CriterioVentaTotal {
	
	String pregunta;
	boolean respuesta;
	
	public CriterioPorPregunta(String pregunta){
		this.pregunta = pregunta;
		respuesta = false;
	}
	
	public boolean getRespuesta(){
		return respuesta;
	}

	@Override
	public boolean aplicaSobre(Venta venta) {
		MediadorPregunta med = MediadorPregunta.getInstance();
		return med.pedirConfirmacion(pregunta);
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
