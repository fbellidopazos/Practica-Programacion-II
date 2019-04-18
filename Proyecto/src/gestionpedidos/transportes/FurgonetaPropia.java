package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public class FurgonetaPropia extends Furgoneta {
	private double velocidadMedia = 30;
	private static final double EUROS_P_HORA = 40;

	public FurgonetaPropia(String codigo, Mapa mapa, double tara) {
		// Pasamos los valores "codigo", "mapa" y "tara" a la clase padre de donde son
		// atributos.
		super(codigo, mapa, tara);

	}

	public double coste(String codPosOrigen, String codPosDestino) {
		// Calculamos el coste desde una posición origen a otra destino pasadas como
		// parámetros.
		double res;
		if (super.getTara() < 500)
			res = super.getMapa().distancia(codPosOrigen, codPosDestino) * (EUROS_P_HORA / velocidadMedia);
		else
			res = super.getMapa().distancia(codPosOrigen, codPosDestino) * (EUROS_P_HORA / velocidadMedia * 1.10);

		return res;

	}

	public double coste(String codPosDestino) {
		// Calculamos el coste desde la posición donde se encuentra el transporte hasta
		// una posición destino pasada como parámetro.
		String codPosOrigen = super.getCodigo();
		double res;
		if (super.getTara() < 500)
			res = super.getMapa().distancia(codPosOrigen, codPosDestino) * (EUROS_P_HORA / velocidadMedia);
		else
			res = super.getMapa().distancia(codPosOrigen, codPosDestino) * (EUROS_P_HORA / velocidadMedia * 1.10);

		return res;

	}

	public double getVelocidadMedia() {
		// Devuelve el valor de la velocidad media (30) .
		return velocidadMedia;
	}

	public void setVelocidadMedia(double velocidadMedia) {
		// Permite cambiar el valor de la velocidad media.
		this.velocidadMedia = velocidadMedia;
	}

}
