package modelo;

import vista.Vista;

public class MediadorPregunta {
	private static MediadorPregunta instance = new MediadorPregunta();
	
	private static Vista vista;
	
	public static void setVista(Vista v) {
		vista = v;
	}
	
	private MediadorPregunta(){
	}
	
	public static MediadorPregunta getInstance() {
		return instance;
	}
	
	public boolean pedirConfirmacion(String pregunta) {
		return vista.pedirConfirmacion(pregunta);
	}

}

	