package ofertas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class OfertaPorVolumenFactory extends OfertaFactory {

	private String nombreArchivo;
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	
	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public OfertaPorVolumenFactory() {
		nombreArchivo = "ofertas_por_volumen.csv";
	}
	
	public void cargarOfertas(){
		InputStream    fis;
		BufferedReader br;
		String         line;
		try {
			fis = new FileInputStream(nombreArchivo);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null) {
				OfertaPorVolumen oferta = new OfertaPorVolumen();
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
