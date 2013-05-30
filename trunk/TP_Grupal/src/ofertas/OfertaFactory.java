package ofertas;

import java.util.ArrayList;

public abstract class OfertaFactory {
	
	public abstract void cargarOfertas();
	
	public abstract ArrayList<Oferta> getOfertas();

}
