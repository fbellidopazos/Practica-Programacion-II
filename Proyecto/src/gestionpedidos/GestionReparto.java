package gestionpedidos;

import gestionpedidos.mapa.Mapa;

import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public class GestionReparto {
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;

	/*
	 * Constructor Inicializamos Mapa Creamos for loop para inicializar los gestores
	 * locales, O(n)[Hay que recorrer el array entero]
	 */
	public GestionReparto(Mapa mapa) {
		this.mapa = mapa;
		this.gestoresLocales = new GestionRepartoLocal[4];
		for (int i = 0; i < gestoresLocales.length; i++) {
			gestoresLocales[i] = new GestionRepartoLocal();

		}

		// TO DO
	}

	// C�DIGO DE APOYO
	public Mapa getMapa() {
		return mapa;
	}

	// C�DIGO DE APOYO
	public String getEstadoGestorLocal(int i) {
		return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
	}

	// C�DIGO DE APOYO
	public String getEstadoGestorLocalNum(int i) {
		return this.gestoresLocales[i].getCodMotosDisponibles().size() + ";"
				+ this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";"
				+ this.gestoresLocales[i].getCodEsperandoMoto().size() + ";"
				+ this.gestoresLocales[i].getCodEsperandoFurgo().size();
	}
	/*
	 * PRE: parametros >=0 y <= MaxCoordX e Y
	 */
	private int getLocalidad(double coordX, double coordY) {
		double maxcoordx = mapa.getMaxCoordX();
		double maxcoordy = mapa.getMaxCoordY();
		int res = -1;
		// Comprobamos si es una coordenada v�lida

		//
		if (coordX <= maxcoordx / 2) {

			// Zona 0: X  [0, maxCoordX/2] Y  [0, maxCoordY/2]
			if (coordY <= maxcoordy / 2)
				res = 0;

			// Zona 1: X  [0, maxCoordX/2] Y  [maxCoordY/2 + 1, maxCoordY]
			else {
				res = 1;
			}
		}

		else {
			if (coordY <= maxcoordy / 2)
				// Zona 2: X  [maxCoordX/2 + 1, maxCoordX] Y  [0, maxCoordY/2]
				res = 2;
			else {
				// Zona 3: X  [maxCoordX/2 + 1, maxCoordX] Y  [maxCoordY/2 + 1, maxCoordY]
				res = 3;
			}
		}
		return res;

	}

	// PRE: el transporte no ha sido asignado a ninguna zona
	/*
	 * 1.Obtenemos las Maximas coordenadas del Mapa 2.Obtenemos las coordenadas del
	 * transporte,es decir su posicion en el mapa 3.Comprobamos subzoneando las
	 * localidades y a�adimos el transporte a la localidad
	 */
	public void addTransporteLocalidad(Transporte transporte) {
		// TO-DO

		gestoresLocales[getLocalidad(mapa.getPosicion(transporte.getCodigo()).getX(),
				mapa.getPosicion(transporte.getCodigo()).getY())].add(transporte);

	}

	// PRE: el pedido no tiene asignado ning�n transporte
	/*
	 * 1.Obtenemos las Maximas coordenadas del Mapa 2.Obtenemos las coordenadas del
	 * restaurante(donde se encuentra el pedido),es decir su posicion en el mapa
	 * 3.Comprobamos subzoneando las localidades y asignamos el pedido
	 */
	public void asignarPedido(Pedido pedido) {

		gestoresLocales[getLocalidad(mapa.getPosicion(pedido.getRestaurante().getCodigo()).getX(),
				mapa.getPosicion(pedido.getRestaurante().getCodigo()).getY())].asignarPedido(pedido);

	}

	// PRE: el pedido tiene asignado un transporte
	/*
	 * 1.Obtenemos las Maximas coordenadas del Mapa 2.Obtenemos las coordenadas del
	 * transporte asignado al pedido,es decir su posicion en el mapa 3.Comprobamos
	 * subzoneando las localidades y notificamos el pedido
	 */
	public void notificarEntregaPedido(Pedido pedido) {
		gestoresLocales[getLocalidad(mapa.getPosicion(pedido.getTransporte().getCodigo()).getX(),
				mapa.getPosicion(pedido.getTransporte().getCodigo()).getY())].notificarEntregaPedido(pedido);

	}

}
