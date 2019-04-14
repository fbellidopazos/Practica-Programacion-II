package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class FurgonetaPropia extends Furgoneta {
	private double velocidadMedia=30;
	private double EUROS_P_HORA=40;
	
	public FurgonetaPropia (String codigo, Mapa mapa, double tara) {
		super(codigo,mapa,tara);
		/*
		 * , double velocidadMedia, double EUROS_P_HORA
		 * this.velocidadMedia=velocidadMedia;
		 * this.EUROS_P_HORA=EUROS_P_HORA;
		 */
	}
	
	public double coste (String codPosOrigen, String codPosDestino) {
		double res;
		if (super.getTara()<500)
			res = super.getMapa().distancia(codPosOrigen, codPosDestino)* (EUROS_P_HORA/velocidadMedia);
		else 
			res= super.getMapa().distancia(codPosOrigen, codPosDestino)* (EUROS_P_HORA/velocidadMedia*1.10);
		
		return res;

	}

}
