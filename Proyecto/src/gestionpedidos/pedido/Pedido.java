package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso Fernandez", emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")

public class Pedido {
	// Cï¿½DIGO DE APOYO
	private Cliente cliente;
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;
	private Transporte transporte;
	private double peso;

	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {
		// TO-DO
		// Asignamos los parametros a los atributos.
		this.cliente = cliente;
		this.comidas = new PlatoComida[comidas.length];
		//Si se hace forloop no salta
		for (int i = 0; i < comidas.length; i++) {
			this.comidas[i]=comidas[i];
			
		}
		
		this.restaurante = restaurante;

		// Como todavía no tenemos información sobre transporte y peso los inicializamos
		// a null y 0 respectivamente.
		this.transporte = null;
		

		double res = 0;
		for (int i = 0; i < comidas.length; i++) {
			res = res + comidas[i].getPeso();
		}
		peso = res;
		// Recorremos el array "comidas" sumando el precio de cada una de las comidas
		// para calcular el importe total del pedido.
		double res2 = 0;
		for (int i = 0; i < comidas.length; i++) {
			res2 += comidas[i].getPrecio();
		}

		this.importe = res2;
	}

	public double getPeso() {

		// TO-DO
		// Sumamos el peso de cada comida del array "comidas" para devolver el peso
		// total del pedido.
		
		return peso;
	}

	public double coste(Transporte transporte) {

		// TO-DO
		// Calculamos el coste total sumando el importe de la comida y el del
		// desplazamiento, primero hasta el restaurante, y luego del restaurante al
		// cliente.
		return (transporte.coste(restaurante.getCodigo()) + importe
				+ transporte.coste(restaurante.getCodigo(), cliente.getCodigo()));
	}

	// Cï¿½DIGO DE APOYO
	public double getImporte() {
		return importe;
	}

	// Cï¿½DIGO DE APOYO
	public Transporte getTransporte() {
		return transporte;
	}

	// Cï¿½DIGO DE APOYO
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	// Cï¿½DIGO DE APOYO
	public Cliente getCliente() {
		return cliente;
	}

	// Cï¿½DIGO DE APOYO
	public Restaurante getRestaurante() {
		return restaurante;
	}
}
