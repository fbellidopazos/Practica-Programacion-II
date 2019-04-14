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
public abstract class Transporte {
	

	private String codigo;
	private Mapa mapa;
	
	
	
	public Transporte(String codigo, Mapa mapa) {
		
		this.codigo = codigo;
		this.mapa = mapa;
	}

	

//	public double coste (String codPosDestino){
//		
//		//TO-DO
//	}
	
	public abstract double coste(String codPosOrigen,String codPosDestino);
	
	public String getCodigo() {
		return codigo;
	}
	
	//Creado por si acaso
	public Mapa getMapa() {
		return mapa;
	}
}
