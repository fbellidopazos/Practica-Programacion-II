package gestionpedidos;

import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;
import queues.NaiveQueue;

import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")

public class GestionRepartoLocal {
	// C�DIGO DE APOYO
	private ArrayList<Moto> motosDisponibles;
	private ArrayList<Furgoneta> furgonetasDisponibles;

	private NaiveQueue<Pedido> pedidosEsperandoMoto;
	private NaiveQueue<Pedido> pedidosEsperandoFurgoneta;

	// C�DIGO DE APOYO
	private static ArrayList<String> getCodList(ArrayList<?> disponibles) {
		ArrayList<String> salida = new ArrayList<>();
		for (int i = 0; i < disponibles.size(); i++)
			salida.add(salida.size(), ((Transporte) disponibles.get(i)).getCodigo());
		return salida;
	}

	// C�DIGO DE APOYO
	private static ArrayList<String[]> getClienteRestauranteList(NaiveQueue<Pedido> pendientes) {
		ArrayList<String[]> salida = new ArrayList<>();
		NaiveQueue<Pedido> aux = new NaiveQueue<>();
		while (!pendientes.isEmpty()) {
			Pedido pedido = pendientes.poll();

			salida.add(salida.size(),
					new String[] { pedido.getCliente().getCodigo(), pedido.getRestaurante().getCodigo() });
			aux.add(pedido);
		}
		while (!aux.isEmpty())
			pendientes.add(aux.poll());

		return salida;
	}

	// C�DIGO DE APOYO
	private static String myArrayListToString(ArrayList<?> list) {
		String salida = "";
		for (int i = 0; i < list.size(); i++) {
			salida += " ";
			if (list.get(i) instanceof String[]) {
				String[] item = (String[]) list.get(i);
				for (int j = 0; j < item.length; j++) {
					salida += item[j];
				}
			} else if (list.get(i) instanceof String) {
				salida += (String) list.get(i);
			}
		}

		return salida;
	}

	// C�DIGO DE APOYO
	public String getDisponibles() {
		return "Motos Disponibles:" + myArrayListToString(getCodList(motosDisponibles)) + System.lineSeparator()
				+ "Furgonetas Disponibles:" + myArrayListToString(getCodList(furgonetasDisponibles))
				+ System.lineSeparator();

	}

	// C�DIGO DE APOYO
	public String getEsperando() {
		return "Pedidos esperando moto:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoMoto))
				+ System.lineSeparator() + "Pedidos esperando furgoneta:"
				+ myArrayListToString(getClienteRestauranteList(pedidosEsperandoFurgoneta)) + System.lineSeparator();
	}

	// C�DIGO DE APOYO
	public ArrayList<String> getCodMotosDisponibles() {
		return getCodList(motosDisponibles);
	}

	// C�DIGO DE APOYO
	public ArrayList<String> getCodFurgoDisponibles() {
		return getCodList(furgonetasDisponibles);

	}

	// C�DIGO DE APOYO
	public ArrayList<String[]> getCodEsperandoMoto() {
		return getClienteRestauranteList(pedidosEsperandoMoto);
	}

	public ArrayList<String[]> getCodEsperandoFurgo() {
		return getClienteRestauranteList(pedidosEsperandoFurgoneta);
	}

	private static final double PESOMAXMOTO = 20;

	// C�DIGO DE APOYO
	public GestionRepartoLocal() {

		this.motosDisponibles = new ArrayList<>();
		this.furgonetasDisponibles = new ArrayList<>();

		this.pedidosEsperandoFurgoneta = new NaiveQueue<>();
		this.pedidosEsperandoMoto = new NaiveQueue<>();
	}

	// PRE: el transporte no ha sido asignado a ninguna zona
	/*
	 * Comprobamos si es una instancia de moto o Furgoneta Una vez comprobado
	 * asignamos segun corresponda al array list correspondiente(haciendo un
	 * downcast)
	 */
	public void add(Transporte transporte) {
		// TO-DO
		if (transporte instanceof Moto)
			motosDisponibles.add(motosDisponibles.size(), (Moto) transporte);
		if (transporte instanceof Furgoneta)
			furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta) transporte);

	}
	
	private Transporte getMinimo(Pedido pedido,ArrayList<? extends Transporte> transporteDisponible) {
		
		Transporte minimoTransporte = transporteDisponible.get(0);
		for (int i = 1; i < transporteDisponible.size(); i++) {
			if (pedido.coste(minimoTransporte) > pedido.coste(transporteDisponible.get(i))) {
				minimoTransporte = transporteDisponible.get(i);
			}

		}
		return minimoTransporte;
		
	}

	// PRE: el pedido no tiene asignado ningï¿½n transporte
	/*
	 * Primero comprobamos si el peso es menor o no Una vez comprobado si el array
	 * list esta vacio asignamos a pedidosesperando<x> el pedido si no buscamos el
	 * minimo de los costes y lo asignamos
	 */
	public void asignarPedido(Pedido pedido) {

		// TO-DO
		if (pedido.getPeso() <= PESOMAXMOTO) {
			if (motosDisponibles.size() == 0)
				pedidosEsperandoMoto.add(pedido);
			else {
				// Buscamos el Minimo de las motos bajo el parametro COSTE O(n)
				
				Moto minimaMoto=(Moto)getMinimo(pedido, motosDisponibles);
				pedido.setTransporte(minimaMoto);
				motosDisponibles.remove(minimaMoto);
				

			}

		}

		else {
			if (furgonetasDisponibles.size() == 0)
				pedidosEsperandoFurgoneta.add(pedido);
			else {
				//Editarlo era para que funcionase
				
				// Buscamos el Minimo de las Furgonetas bajo el parametro COSTE O(n)
				Furgoneta minimaFurgoneta=(Furgoneta)getMinimo(pedido, furgonetasDisponibles);
				pedido.setTransporte(minimaFurgoneta);
				furgonetasDisponibles.remove(minimaFurgoneta);
				
			}
		}

	}

	// PRE: el pedido tiene asignado un transporte
	/*
	 * miramos si el transporte del pedido tiene una moto o una furgonte(Solo hay
	 * dos posibilidades segun la precondicion dada) luego a�adimos miramos si los
	 * pedidos esperando estan vacios si es asi los metemos en disponibles si no
	 * hacemos settransporte
	 */
	public void notificarEntregaPedido(Pedido pedido) {
		// TO-DO
		if (pedido.getTransporte() instanceof Moto) {
			if (pedidosEsperandoMoto.isEmpty())
				motosDisponibles.add(motosDisponibles.size(), (Moto) pedido.getTransporte());
			else
				pedidosEsperandoMoto.poll().setTransporte(pedido.getTransporte());
		} else {
			if (pedidosEsperandoFurgoneta.isEmpty())
				furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta) pedido.getTransporte());
			else
				pedidosEsperandoFurgoneta.poll().setTransporte(pedido.getTransporte());
		}

	}
}