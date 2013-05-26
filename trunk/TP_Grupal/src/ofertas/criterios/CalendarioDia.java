package ofertas.criterios;

import java.util.Calendar;

public class CalendarioDia implements Calendario {

	@Override
	public String getDia() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		// If current day is Sunday, day=1
		String dias[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
		return dias[day - 1];	
	
	}

}
