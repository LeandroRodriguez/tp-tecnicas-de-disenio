package ofertas;

import modelo.Descuento;

public class DescuentoPorVolumen extends Descuento {

	private float valor;

	@Override
	public float getDescuento() {
		return valor;
	}

	public DescuentoPorVolumen(float valor) {
		super();
		this.valor = valor;
	}

}
