package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public abstract class Furgoneta extends Transporte {
	private double tara;

	public Furgoneta(String codigo, Mapa mapa, double tara) {
		// Mandamos los valores "codigo" y "mapa" a la clase padre de donde son
		// atributos.
		super(codigo, mapa);
		// Inicializamos el valor del atributo con el valor pasado.
		this.tara = tara;
	}

	public double getTara() {
		// Devuelve el valor del atributo "tara".
		return tara;
	}

	@Override
	public abstract double coste(String codPosOrigen, String codPosDestino);
	// Calculamos el precio para ir de una posición origen hasta el destino.

}
