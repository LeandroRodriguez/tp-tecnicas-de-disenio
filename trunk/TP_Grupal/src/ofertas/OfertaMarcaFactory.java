package ofertas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.google.gson.Gson;

public class OfertaMarcaFactory extends OfertaFactory {

	private String nombreArchivo = "ofertas_marca.json";
	private ArrayList<OfertaMarca> ofertas = new ArrayList<OfertaMarca>();
	
	public OfertaMarcaFactory() {
		InputStream    fis;
		BufferedReader br;
		String         line;
		Gson gson = new Gson();
		try {
			fis = new FileInputStream(nombreArchivo);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null) {
				OfertaMarca oferta = gson.fromJson(line, OfertaMarca.class);
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
