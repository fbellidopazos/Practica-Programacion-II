package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class Furgoneta extends Transporte {
	private double tara;
	
	public Furgoneta (String codigo, Mapa mapa, double tara) {
		super (codigo, mapa);
		this.tara=tara;
	}

}
