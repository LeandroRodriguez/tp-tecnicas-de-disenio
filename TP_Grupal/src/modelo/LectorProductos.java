package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class LectorProductos {
	
	private String nombreArchivo;
	
	public LectorProductos() {
		nombreArchivo = "productos.csv";
	}
	
	public void setArchivo(String nombre) {
		nombreArchivo = nombre;
	}
	
	public ArrayList<Producto> cargarProductos() {
		InputStream fis;
		BufferedReader br;
		String line;
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			fis = new FileInputStream(nombreArchivo);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null) {
				String atributos[] = line.split(";");				
				Producto nuevo = new Producto(atributos[0], atributos[1],  
						atributos[2], Float.parseFloat(atributos[3]) );
				productos.add(nuevo);
			}
			br.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return productos;
	}

}
