package tests.utilidades;

import vista.Vista;

public class VistaDummy extends Vista {
	
	private boolean respuesta;
	
	public VistaDummy(boolean respuesta){
		super(null);
		this.respuesta = respuesta;
	}
	
	public boolean pedirConfirmacion(String pregunta){
		return respuesta;
	}

}
