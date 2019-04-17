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
	 
	
	 
	 
	 
	public String getCodigo() {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

}
