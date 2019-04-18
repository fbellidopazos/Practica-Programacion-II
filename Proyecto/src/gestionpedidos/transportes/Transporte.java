package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public abstract class Transporte {

	private String codigo;
	private Mapa mapa;

	/*
	 * Inicializamos codigo y mapa mediante argumentos dados
	 */
	public Transporte(String codigo, Mapa mapa) {

		this.codigo = codigo;
		this.mapa = mapa;
	}

	/*
	 * Calculamso el coste desde codigo (atributo) a el destino
	 */
	public double coste(String codPosDestino) {

		return coste(codigo, codPosDestino);
	}

	/*
	 * Abstract de Coste(Para clases hijas)
	 */
	public abstract double coste(String codPosOrigen, String codPosDestino);

	/*
	 * Setter de Codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/*
	 * Getter de Codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/*
	 * Getter de mapa(PROTECTED)
	 */
	protected Mapa getMapa() {
		return mapa;
	}
}
