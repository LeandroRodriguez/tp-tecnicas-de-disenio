package ofertas.criterios;

import java.util.Scanner;

import modelo.Venta;

public class CriterioPorPregunta implements CriterioVentaTotal {
	
	String pregunta;
	boolean respuesta;
	
	public CriterioPorPregunta(String pregunta){
		this.pregunta = pregunta;
	}

	@Override
	public boolean aplicaSobre(Venta venta) {
		System.out.println(pregunta+"?");	
		Scanner sc = new Scanner(System.in);
		String aux = "";
		int i = -1;
		boolean done = false;
		while ( ! done) {
			try {
				aux = sc.next();
				done = true;
			} catch (NumberFormatException e){
			}
		}
		respuesta = (aux.equals("s"));
		return respuesta;
	
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
