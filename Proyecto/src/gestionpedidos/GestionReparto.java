package gestionpedidos;

import gestionpedidos.mapa.Mapa;

import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernández", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public class GestionReparto {
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;

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

	// PRE: el transporte no ha sido asignado a ninguna zona
	public void addTransporteLocalidad(Transporte transporte) {
		// TO-DO
		

		double MaxCoordX = mapa.getMaxCoordX();
		double MaxCoordY = mapa.getMaxCoordY();
		double coordTransX = mapa.getPosicion(transporte.getCodigo()).getX();
		double coordTransY = mapa.getPosicion(transporte.getCodigo()).getY();

		// Zona 0: X  [0, maxCoordX/2] Y  [0, maxCoordY/2]
		if ((0 <= coordTransX && coordTransX <= (MaxCoordX / 2))
				&& (0 <= coordTransY && coordTransX <= (MaxCoordY / 2))) {
			gestoresLocales[0].add(transporte);
		}

		// Zona 1: X  [0, maxCoordX/2] Y  [maxCoordY/2 + 1, maxCoordY]
		else if ((0 <= coordTransX && coordTransX <= (MaxCoordX / 2))
				&& (((MaxCoordY / 2) + 1) <= coordTransY && coordTransX <= (MaxCoordY))) {
			gestoresLocales[1].add(transporte);
		}

		// Zona 2: X  [maxCoordX/2 + 1, maxCoordX] Y  [0, maxCoordY/2]
		else if (((((MaxCoordX / 2) + 1)) <= coordTransX && coordTransX <= (MaxCoordX))
				&& (0 <= coordTransY && coordTransX <= (MaxCoordY / 2))) {
			gestoresLocales[2].add(transporte);
		}

		// Zona 3: X  [maxCoordX/2 + 1, maxCoordX] Y  [maxCoordY/2 + 1, maxCoordY]
		else if (((((MaxCoordX / 2) + 1)) <= coordTransX && coordTransX <= (MaxCoordX)) // Coordenada X
				&& (((MaxCoordY / 2) + 1) <= coordTransY && coordTransX <= (MaxCoordY))) { // Coordenada Y
			gestoresLocales[3].add(transporte);
		}

	}

	// PRE: el pedido no tiene asignado ning�n transporte
	public void asignarPedido(Pedido pedido) {

		int MaxCoordX = mapa.getMaxCoordX();
		int MaxCoordY = mapa.getMaxCoordY();
		int coordTransX = mapa.getPosicion(pedido.getRestaurante().getCodigo()).getX();
		int coordTransY = mapa.getPosicion(pedido.getRestaurante().getCodigo()).getY();



		// Zona 0: X  [0, maxCoordX/2] Y  [0, maxCoordY/2]
		if ((0 <= coordTransX && coordTransX <= (MaxCoordX / 2))
				&& (0 <= coordTransY && coordTransX <= (MaxCoordY / 2))) {
			gestoresLocales[0].asignarPedido(pedido);
		}

		// Zona 1: X  [0, maxCoordX/2] Y  [maxCoordY/2 + 1, maxCoordY]
		else if ((0 <= coordTransX && coordTransX <= (MaxCoordX / 2))
				&& (((MaxCoordY / 2) + 1) <= coordTransY && coordTransX <= (MaxCoordY))) {
			gestoresLocales[1].asignarPedido(pedido);
		}

		// Zona 2: X  [maxCoordX/2 + 1, maxCoordX] Y  [0, maxCoordY/2]
		else if (((((MaxCoordX / 2) + 1)) <= coordTransX && coordTransX <= (MaxCoordX))
				&& (0 <= coordTransY && coordTransX <= (MaxCoordY / 2))) {
			gestoresLocales[2].asignarPedido(pedido);
		}

		// Zona 3: X  [maxCoordX/2 + 1, maxCoordX] Y  [maxCoordY/2 + 1, maxCoordY]
		else if (((((MaxCoordX / 2) + 1)) <= coordTransX && coordTransX <= (MaxCoordX)) // Coordenada X
				&& (((MaxCoordY / 2) + 1) <= coordTransY && coordTransX <= (MaxCoordY))) { // Coordenada Y
			gestoresLocales[3].asignarPedido(pedido);
		}

	}

	// PRE: el pedido tiene asignado un transporte
	public void notificarEntregaPedido(Pedido pedido) {
		int MaxCoordX = mapa.getMaxCoordX();
		int MaxCoordY = mapa.getMaxCoordY();
		int coordTransX = mapa.getPosicion(pedido.getTransporte().getCodigo()).getX();
		int coordTransY = mapa.getPosicion(pedido.getTransporte().getCodigo()).getY();

		// Zona 0: X  [0, maxCoordX/2] Y  [0, maxCoordY/2]
		if ((0 <= coordTransX && coordTransX <= (MaxCoordX / 2))
				&& (0 <= coordTransY && coordTransX <= (MaxCoordY / 2))) {
			gestoresLocales[0].notificarEntregaPedido(pedido);
		}

		// Zona 1: X  [0, maxCoordX/2] Y  [maxCoordY/2 + 1, maxCoordY]
		else if ((0 <= coordTransX && coordTransX <= (MaxCoordX / 2))
				&& (((MaxCoordY / 2) + 1) <= coordTransY && coordTransX <= (MaxCoordY))) {
			gestoresLocales[1].notificarEntregaPedido(pedido);
		}

		// Zona 2: X  [maxCoordX/2 + 1, maxCoordX] Y  [0, maxCoordY/2]
		else if (((((MaxCoordX / 2) + 1)) <= coordTransX && coordTransX <= (MaxCoordX))
				&& (0 <= coordTransY && coordTransX <= (MaxCoordY / 2))) {
			gestoresLocales[2].notificarEntregaPedido(pedido);
		}

		// Zona 3: X  [maxCoordX/2 + 1, maxCoordX] Y  [maxCoordY/2 + 1, maxCoordY]
		else if (((((MaxCoordX / 2) + 1)) <= coordTransX && coordTransX <= (MaxCoordX)) // Coordenada X
				&& (((MaxCoordY / 2) + 1) <= coordTransY && coordTransX <= (MaxCoordY))) { // Coordenada Y
			gestoresLocales[3].notificarEntregaPedido(pedido);
		}

	}

}
