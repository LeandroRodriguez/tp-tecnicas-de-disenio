package tp_supermarket.tests;

public class TarjetaDePuntos {

	private String cliente;
	private int puntos;

	public TarjetaDePuntos(String cliente) {
		this.cliente = cliente;
		this.puntos = 0;
	}

	public void sumarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public String getCliente() {
		return cliente;
	}

	public int getPuntos() {
		return puntos;
	}

	public float canjearPuntosSobreMonto(float monto) {
		float puntosCanjeados = Math.min(monto, this.puntos);
		this.puntos -= puntosCanjeados;
		return monto - puntosCanjeados;
	}

}
