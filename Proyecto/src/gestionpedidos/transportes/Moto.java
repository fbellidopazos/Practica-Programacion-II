package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class Moto extends Transporte {
	private double eurosPKm;
	
	public Moto (String codigo,Mapa mapa,double eurosPKm) {
		super(codigo, mapa);
		this.eurosPKm=eurosPKm;
	}
	
	public double coste(String codPosOrigen,String codPosDestino) {
		return( super.getMapa().distancia(codPosOrigen,codPosDestino)*eurosPKm);
	}

}
