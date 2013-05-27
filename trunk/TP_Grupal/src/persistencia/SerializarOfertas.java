package persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ofertas.OfertaPorUnidad;
import ofertas.criterios.Criterio;

import com.google.gson.Gson;

public class SerializarOfertas {
	
	private String nombreArchivo;
	
	public SerializarOfertas(String nombreArchivo){
		this.nombreArchivo = nombreArchivo;
	}
	
	private String grabarTipos(ArrayList<Criterio> criterios){		
		String resultado = "";
		for (Criterio criterio : criterios){
			resultado += criterio.getClass().getName();
			resultado += ";";
		}
		return resultado;
	}
	

	/** Serializa un array de ofertas. Guarda en el archivo el nombre de la clase, 
	 * para despues crear la instancia de la clase correspondiente.
	 * @param ofertas
	 * @param apend
	 */
	public void serializarOfertasPorUnidad(ArrayList<OfertaPorUnidad> ofertas, boolean apend){
		BufferedWriter out = null;
		Gson gson = new Gson();
		
		try {
		    out = new BufferedWriter(new FileWriter(nombreArchivo, apend));
		    for (OfertaPorUnidad oferta : ofertas){
		    	ArrayList<Criterio> criterios = oferta.getCriterios();
		    	out.write(gson.toJson(criterios));
		    	out.write("#");
		    	out.write(grabarTipos(criterios));
		    	out.write("#");
		    	out.write(Float.toString(oferta.getPorcentajeDescuento()));
		    	out.write("\n");    	
		    }
	        out.close();
		} catch (IOException e) {
		    // error processing code
		}
	}
}
