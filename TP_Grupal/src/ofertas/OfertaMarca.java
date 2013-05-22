package ofertas;

public class OfertaMarca extends Oferta {

	private String marca;
	private float descuento;
	
	public OfertaMarca(String marca, float descuento){
		this.marca = marca;
		this.descuento = descuento;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
}
