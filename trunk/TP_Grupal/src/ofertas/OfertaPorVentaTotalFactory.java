package ofertas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import ofertas.criterios.CriterioPorMedioDePago;
import ofertas.criterios.CriterioVentaTotal;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class OfertaPorVentaTotalFactory extends OfertaFactory {

	private String nombreArchivo;
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	
	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public OfertaPorVentaTotalFactory() {
		nombreArchivo = "ofertas_venta_total.csv";
	}

	private ArrayList<Class<?>> generarTipos(String s){
		ArrayList<Class<?>> clases = new ArrayList<Class<?>>();
		String nombres[] = s.split(";");
		for (String nombre : nombres){
			if (nombre.length() > 0){
				try {
					Class<?> clase = Class.forName(nombre);
					clases.add(clase);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return clases;
	}
	
	private ArrayList<CriterioVentaTotal> crearCriterios(String ser, String nombres){
		ArrayList<CriterioVentaTotal> criterios = new ArrayList<CriterioVentaTotal>();
		ArrayList<Class<?>> clases = generarTipos(nombres);
		Gson gson = new Gson();
	    JsonParser parser = new JsonParser();
	    JsonArray array = parser.parse(ser).getAsJsonArray();
	    //int i = 0;
	    for (int i=0; i<array.size(); ++i ){
	    	Object criterio = gson.fromJson(array.get(i), CriterioPorMedioDePago.class);
	    	criterios.add( (CriterioVentaTotal) criterio);
	    }
		return criterios;
	}
	
	public void cargarOfertas(){
		InputStream    fis;
		BufferedReader br;
		String         line;
		try {
			fis = new FileInputStream(nombreArchivo);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null) {
				
				OfertaPorVentaTotal oferta = new OfertaPorVentaTotal();
				oferta.cargarDeArchivo(line);
				ofertas.add(oferta);
			}
			br.close();
			br = null;
			fis = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
