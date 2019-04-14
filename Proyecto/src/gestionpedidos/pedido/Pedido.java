package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Sara", apellidoAutor1 = "Alonso apellido2", emailUPMAutor1 = "usr@alumnos.upm.es", nombreAutor2 = "Fernando", apellidoAutor2 = "Bellido Pazos", emailUPMAutor2 = "f.bpazos@alumnos.upm.es")
public class Pedido {
	// C�DIGO DE APOYO
	private Cliente cliente;
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;
	private Transporte transporte;
	private double peso;

	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {
		// TO-DO
		this.cliente = cliente;
		this.comidas = comidas;
		this.restaurante = restaurante;
		this.importe = 0;
		this.transporte = null;
		this.peso = 0;
	}

	public double getPeso(){
	
		//TO-DO	//double res=0;
		for(int i=0; i<comidas.length; i++) {
			res=res+ comidas[i].getPeso();	
		}	return 0;res	}

	public double coste(Transporte transporte) {
		// TO-DO
		return (transporte
				.coste(cliente.getCodigo() + importe + transporte.coste(restaurante.getCodigo(), cliente.getCodigo())));
	}

	// C�DIGO DE APOYO
	public double getImporte() {
		return importe;
	}

	// C�DIGO DE APOYO
	public Transporte getTransporte() {
		return transporte;
	}

	// C�DIGO DE APOYO
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	// C�DIGO DE APOYO
	public Cliente getCliente() {
		return cliente;
	}

	// C�DIGO DE APOYO
	public Restaurante getRestaurante() {
		return restaurante;
	}
}
