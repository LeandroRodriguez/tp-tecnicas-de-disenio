package ofertas.criterios;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarioDia implements Calendario {
	private Calendar calendarioHelper = Calendar.getInstance();
	private HashMap<String, String> diccionarioDias;
	
	public CalendarioDia(){
		this.diccionarioDias = new HashMap<String, String>();
		this.diccionarioDias.put("1", "domingo");
		this.diccionarioDias.put("2", "lunes");
		this.diccionarioDias.put("3", "martes");
		this.diccionarioDias.put("4", "miercoles");
		this.diccionarioDias.put("5", "jueves");
		this.diccionarioDias.put("6", "viernes");
		this.diccionarioDias.put("7", "sabado");
	}
	
	@Override
	public String getDiaCorriente() {
		int numeroDiaCorriente = this.calendarioHelper.get(Calendar.DAY_OF_WEEK);
		String nombreDiaCorriente = this.diccionarioDias.get(Integer.toString(numeroDiaCorriente));
		return nombreDiaCorriente;
	}

}
