package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public class Moto extends Transporte {
	private double eurosPKm = 2;

	/*
	 * Inicializamos codigo y mapa con argumentos dados
	 */
	public Moto(String codigo, Mapa mapa) {
		// double eurosPKm
		super(codigo, mapa);
		// this.eurosPKm=eurosPKm;
	}

	/*
	 * Calculamos precio para ir desde donde esta la moto hasta el lugar
	 * correspondiente
	 */
	public double coste(String codPosDestino) {
		return (super.getMapa().distancia(super.getCodigo(), codPosDestino) * eurosPKm);
	}

	/*
	 * Calculamos precio para ir desde lugar dado hasta el destino dado
	 */
	public double coste(String codPosOrigen, String codPosDestino) {
		return (super.getMapa().distancia(codPosOrigen, codPosDestino) * eurosPKm);
	}

	/*
	 * Getter de EurosPKm
	 */
	public double getEurosPKm() {
		return eurosPKm;
	}

	/*
	 * Setter de EurosPKm
	 */
	public void setEurosPKm(double eurosPKm) {
		this.eurosPKm = eurosPKm;
	}

}
