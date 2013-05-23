package ofertas;


import java.io.*;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.google.gson.Gson;

public class OfertaPorMarcaYCategoriaFactory extends OfertaFactory {

	private String nombreArchivo = "ofertas_por_marca_y_categoria.json";
	private ArrayList<OfertaPorMarcaYCategoria> ofertas = new ArrayList<OfertaPorMarcaYCategoria>();
	
	public OfertaPorMarcaYCategoriaFactory() {
		InputStream    fis;
		BufferedReader br;
		String         line;
		Gson gson = new Gson();
		try {
			fis = new FileInputStream(nombreArchivo);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null) {
				OfertaPorMarcaYCategoria oferta = gson.fromJson(line, OfertaPorMarcaYCategoria.class);
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
   
    public void CrearArchivoOfertaPorMarcaYCategoria() {
        File datos = new File(nombreArchivo);
        try {
            FileWriter fileWriter = new FileWriter(datos);
            BufferedWriter bw = new BufferedWriter(fileWriter);                    
            PrintWriter writer = new PrintWriter(bw);  
            /*lo que meto adentro*/
            ArrayList<String> marcas = new ArrayList<String>();
            marcas.add("+coca");
            marcas.add("+7up");
            marcas.add("-Sprite");
            
			ArrayList<String> categorias = new ArrayList<String>();
			categorias.add("+Gaseosas");
			categorias.add("-Aguas");
			
			OfertaPorMarcaYCategoria oferta = new OfertaPorMarcaYCategoria(marcas, categorias, 15);
            /**/
            
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
	
    public ArrayList<OfertaPorMarcaYCategoria> getOfertas(){
    	return this.ofertas;
    }
    
}
