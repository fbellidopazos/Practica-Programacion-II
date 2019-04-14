package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public abstract class Furgoneta extends Transporte {
	private double tara;
	
	public Furgoneta (String codigo, Mapa mapa, double tara) {
		super (codigo, mapa);
		this.tara=tara;
	}
	
	public double getTara() {
		return tara;
	}
	
	 @Override
	public abstract double coste(String codPosOrigen, String codPosDestino) ;

}
