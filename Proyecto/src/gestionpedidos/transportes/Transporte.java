package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

public abstract class Transporte {
	

	private String codigo;
	private Mapa mapa;
	
	
	
	public Transporte(String codigo, Mapa mapa) {
		
		this.codigo = codigo;
		this.mapa = mapa;
	}

	

	public double coste (String codPosDestino){
		
		//TO-DO
	}
	
	public abstract double coste(String codPosOrigen,String codPosDestino);
	
	
	//Creado por si acaso
	public Mapa getMapa() {
		return mapa;
	}
}
