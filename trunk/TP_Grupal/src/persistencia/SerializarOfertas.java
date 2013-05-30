package persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ofertas.OfertaPorUnidad;
import ofertas.OfertaPorVentaTotal;
import ofertas.OfertaPorVolumen;
import ofertas.criterios.Criterio;
import ofertas.criterios.CriterioVentaTotal;

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
		    	ArrayList<Criterio> criterios = oferta.getCriterios().getLista();
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
	
	/** Serializa un array de ofertas. Guarda en el archivo el nombre de la clase, 
	 * para despues crear la instancia de la clase correspondiente.
	 * @param ofertas
	 * @param apend
	 */
	public void serializarOfertasPorVolumen(ArrayList<OfertaPorVolumen> ofertas, boolean apend){
		BufferedWriter out = null;		
		try {
		    out = new BufferedWriter(new FileWriter(nombreArchivo, apend));
		    for (OfertaPorVolumen oferta : ofertas){
		    	out.write(oferta.serializar());
		    	out.write("\n");    	
		    }
	        out.close();
		} catch (IOException e) {
		    // error processing code
		}
	}

	public void serializarOfertasPorVentaTotal(
			ArrayList<OfertaPorVentaTotal> ofertas, boolean b) {
		BufferedWriter out = null;
		Gson gson = new Gson();
		
		try {
		    out = new BufferedWriter(new FileWriter(nombreArchivo, true));
		    for (OfertaPorVentaTotal oferta : ofertas){
		    	for (CriterioVentaTotal criterio : oferta.getCriterios().getLista()){
		    		out.write(gson.toJson(criterio)+"&");
		    	}
		    	out.write("/");
		    	out.write(Float.toString(oferta.getPorcentajeDescuento()));
		    	out.write("\n");    	
		    }
	        out.close();
		} catch (IOException e) {
		    // error processing code
		}
	}
}
