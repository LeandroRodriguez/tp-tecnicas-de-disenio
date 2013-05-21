package ofertas;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OfertaMarcaFactory extends OfertaFactory {

	private String nombreArchivo = "ofertas_marca.json";
	
	public OfertaMarcaFactory() {
		File datos = new File(nombreArchivo);
		try {
			FileWriter fileWriter = new FileWriter(datos);
			BufferedWriter bw = new BufferedWriter(fileWriter);			
			PrintWriter writer = new PrintWriter(bw);  
			OfertaMarca oferta = new OfertaMarca("coca",10);
		
			Gson gson = new Gson();
			String ser = gson.toJson(oferta);
			writer.write(ser);
			
			writer.close();
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
