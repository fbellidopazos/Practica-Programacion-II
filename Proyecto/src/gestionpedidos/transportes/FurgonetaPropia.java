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
	public double coste ( String codPosDestino) {
		String codPosOrigen=super.getCodigo();
		double res;
		if (super.getTara()<500)
			res = super.getMapa().distancia(codPosOrigen, codPosDestino)* (EUROS_P_HORA/velocidadMedia);
		else 
			res= super.getMapa().distancia(codPosOrigen, codPosDestino)* (EUROS_P_HORA/velocidadMedia*1.10);
		
		return res;

	}

	
	
	public double getVelocidadMedia() {
		return velocidadMedia;
	}

	public void setVelocidadMedia(double velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}

	public double getEUROS_P_HORA() {
		return EUROS_P_HORA;
	}

	public void setEUROS_P_HORA(double eUROS_P_HORA) {
		EUROS_P_HORA = eUROS_P_HORA;
	}
	

}
