package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.ControlJugadoresAjedrez;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

public class Peon extends PiezaAjedrez {
	private boolean start = this.getJugador().getId()==ControlJugadoresAjedrez.NEGRO?this.getFilaAjedrez()==7:this.getFilaAjedrez()==2;
	
	public Peon(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
	}
	
	@Override
	public ArrayList<Casilla> movimientosValidos() {
			
		ArrayList<Casilla> resultado = new ArrayList<>();
		if(start) {
			diagonals(resultado, 1);
			diagonals(resultado, 2);
			
			if(this.getJugador().getId()==ControlJugadoresAjedrez.BLANCO && movimientoDentroLimites(this.getFila()-2, this.getColumna()) && movimientoDentroLimites(this.getFila()-1, this.getColumna()) && queHay(this.getFila()-1, this.getColumna())==null &&queHay(this.getFila()-2, this.getColumna())==null)
				resultado.add(resultado.size(), new Casilla(this.getFila()-2, this.getColumna()));
			else if (this.getJugador().getId()==ControlJugadoresAjedrez.NEGRO && movimientoDentroLimites(this.getFila()+2, this.getColumna())  && movimientoDentroLimites(this.getFila()+1, this.getColumna()) && queHay(this.getFila()+1, this.getColumna())==null && queHay(this.getFila()+2, this.getColumna())==null)
				resultado.add(resultado.size(), new Casilla(this.getFila()+2, this.getColumna()));
				
			
			movements(resultado, 1);
			
			
			
			start=false;
		}
		else {
			movements(resultado, 1);
			diagonals(resultado, 1);
			
		}
		

		return resultado;
	}
	
	
	
	private void diagonals(ArrayList<Casilla> resultado,int i) {
		int fila=this.getFila();
		int columna=this.getColumna();
		Jugador player=this.getJugador();
		
		if(player.getId()==ControlJugadoresAjedrez.BLANCO && movimientoDentroLimites((fila-i), (columna-i)) && queHay((fila-i), (columna-i))!=null && queHay((fila-i), (columna-i)).getJugador().getId()==ControlJugadoresAjedrez.NEGRO)
			resultado.add(resultado.size(), new Casilla((fila-i), (columna-i)));
		if(player.getId()==ControlJugadoresAjedrez.BLANCO && movimientoDentroLimites((fila-i), (columna+i)) && queHay((fila-i), (columna+i))!=null && queHay((fila-i), (columna+i)).getJugador().getId()==ControlJugadoresAjedrez.NEGRO)
			resultado.add(resultado.size(), new Casilla((fila-i), (columna+i)));
		
		if(player.getId()==ControlJugadoresAjedrez.NEGRO && movimientoDentroLimites((fila+i), (columna-i)) && queHay((fila+i), (columna-i))!=null && queHay((fila+i), (columna-i)).getJugador().getId()==ControlJugadoresAjedrez.BLANCO)
			resultado.add(resultado.size(), new Casilla((fila+i), (columna-i)));
		if(player.getId()==ControlJugadoresAjedrez.NEGRO && movimientoDentroLimites((fila+i), (columna+i)) && queHay((fila+i), (columna+i))!=null && queHay((fila+i), (columna+i)).getJugador().getId()==ControlJugadoresAjedrez.BLANCO)
			resultado.add(resultado.size(), new Casilla((fila+i), (columna+i)));
	}
	
	private void movements(ArrayList<Casilla> resultado,int i) {
		if(this.getJugador().getId()==ControlJugadoresAjedrez.BLANCO && movimientoDentroLimites(this.getFila()-i, this.getColumna()) && queHay(this.getFila()-i, this.getColumna())==null)
			resultado.add(resultado.size(), new Casilla(this.getFila()-i, this.getColumna()));
		else if (this.getJugador().getId()==ControlJugadoresAjedrez.NEGRO && movimientoDentroLimites(this.getFila()+i, this.getColumna()) && queHay(this.getFila()+i, this.getColumna())==null)
			resultado.add(resultado.size(), new Casilla(this.getFila()+i, this.getColumna()));
	}	
}
