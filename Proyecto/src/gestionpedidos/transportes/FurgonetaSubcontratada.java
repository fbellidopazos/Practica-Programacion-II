package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public class FurgonetaSubcontratada extends Furgoneta {
	private double eurosPKm = 1;

	public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);

	}

	/*
	 * Si la tara de la clase es menor a 1000 No a�adimos mas valor , en caso
	 * contrario aumentamos el valor un 10% mas
	 */
	@Override
	public double coste(String codPosOrigen, String codPosDestino) {
		double res;
		res = super.getTara() < 1000 ? super.getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm
				: super.getMapa().distancia(codPosOrigen, codPosDestino) * (eurosPKm * 1.10);

		return res;
	}

	@Override
	public double coste(String codPosDestino) {
		// Calcula el coste que supone ir desde la posici�n donde se encuntra el
		// transporte hasta otra pasada como par�metro
		double res;
		String codPosOrigen = super.getCodigo();

		res = super.getTara() < 1000 ? super.getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm
				: super.getMapa().distancia(codPosOrigen, codPosDestino) * (eurosPKm * 1.10);

		return res;
	}

	public double getEurosPKm() {
		// Devolvemos el valor de EurosPKm
		return eurosPKm;
	}

	public void setEurosPKm(double eurosPKm) {
		// Estalecemos el valor EurosPKm segun el parametro dado
		this.eurosPKm = eurosPKm;
	}

}
