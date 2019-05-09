package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.ControlJugadoresAjedrez;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

public class Peon extends PiezaAjedrez {
	private boolean start = true;
	
	public Peon(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
	}
	
	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();
		if(start) {
			movements(resultado, 1);
			movements(resultado, 2);
			addDiagonals(resultado,1);
			
			start=false;
		}
		else {
			movements(resultado, 1);
			addDiagonals(resultado,1);
		}
		

		return resultado;
	}
	
	
	private void addDiagonals(ArrayList<Casilla> resultado,int i) {
		
		/*
		 A - B
		 - * - 
		 C - D
		
		 */
		int[][] diagonales={{this.getFila()-i,this.getColumna()-i},{this.getFila()-i,this.getColumna()+i},{this.getFila()+i,this.getColumna()-i},{this.getFila()+i,this.getColumna()-i}};
		for (int j = 0; j < diagonales.length; j++) {
			diagonal(diagonales[j][0],diagonales[j][1],resultado);
		}
		
		
		
	}
	private void diagonal(int i,int j,ArrayList<Casilla> resultado) {
		// si i<Fila (Es negra ya que restamos -1)--> Si en la posicion hay una ficha--> Es esa ficha de distinto color al jugador
		if(i<this.getFila() && queHay(i, j)!=null && queHay(i, j).getJugador().getId()!=ControlJugadoresAjedrez.NEGRO || i>this.getFila() && queHay(i, j)!=null && queHay(i, j).getJugador().getId()!=ControlJugadoresAjedrez.BLANCO)
			
			casillaVisitable(resultado, i, j);
		
			
		
			
	}
	
	
	
	
	private void movements(ArrayList<Casilla> resultado,int i) {
		//Comprobamos si es negro --> Si hay ficha delante --> 
		if(this.getJugador().getId() == ControlJugadoresAjedrez.NEGRO && (queHay(this.getFila() - i, this.getColumna())!=null&& queHay(this.getFila() - i, this.getColumna()).getJugador().getId()!=ControlJugadoresAjedrez.BLANCO))
			casillaVisitable(resultado, this.getFila() - i, this.getColumna());
		else if(this.getJugador().getId() == ControlJugadoresAjedrez.BLANCO && (queHay(this.getFila() - i, this.getColumna())!=null && queHay(this.getFila() - i, this.getColumna()).getJugador().getId()!=ControlJugadoresAjedrez.NEGRO ))
			casillaVisitable(resultado, this.getFila() + i, this.getColumna());
	}
	
	
}
