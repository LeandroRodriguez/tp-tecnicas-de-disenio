package modelo;

public class Producto {
	double precio;
	String nombre, marca, categoria;
	
	public Producto(String nombre, String marca, String categoria, double precio) {
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
