package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class FurgonetaPropia extends Furgoneta {
	private double velocidadMedia;
	private double eurosPHora;
	
	public FurgonetaPropia (String codigo, Mapa mapa, double tara, double velocidadMedia, double eurosPHora) {
		super(codigo,mapa,tara);
		this.velocidadMedia=velocidadMedia;
		this.eurosPHora=eurosPHoras;
	}

}
