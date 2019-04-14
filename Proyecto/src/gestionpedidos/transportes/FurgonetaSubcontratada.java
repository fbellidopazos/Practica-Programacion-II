package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public class FurgonetaSubcontratada extends Furgoneta{
	private double eurosPKm=1;
	
	public FurgonetaSubcontratada (String codigo, Mapa mapa, double tara) {
		super(codigo,mapa,tara);
		//this.eurosPKm=eurosPKm;
		//, double eurosPKm
	}
	
	public double coste(String codPosOrigen, String codPosDestino) {
		double res;
		if (super.getTara()<1000)
			res = super.getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm;
		else 
			res = super.getMapa().distancia(codPosOrigen, codPosDestino)* (eurosPKm*1.10);
		
		return res;
	}
}
