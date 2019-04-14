package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
import anotacion.Programacion2;

@Programacion2 (
		nombreAutor1 = "Sara",
		apellidoAutor1 = "Alonso Fernández",
		emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es",
		nombreAutor2 = "Fernando",
		apellidoAutor2 = "Bellido Pazos", 
		emailUPMAutor2 = "f.bpazos@alumnos.upm.es"
	)
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
	public double coste( String codPosDestino) {
		double res;
		String codPosOrigen=super.getCodigo();
		if (super.getTara()<1000)
			res = super.getMapa().distancia(codPosOrigen, codPosDestino)*eurosPKm;
		else 
			res = super.getMapa().distancia(codPosOrigen, codPosDestino)* (eurosPKm*1.10);
		
		return res;
	}

	public double getEurosPKm() {
		return eurosPKm;
	}

	public void setEurosPKm(double eurosPKm) {
		this.eurosPKm = eurosPKm;
	}
	
	
}
