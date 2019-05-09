package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.ControlJugadoresAjedrez;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

public class Peon extends PiezaAjedrez {
	private boolean start = true;
	private boolean bajar=false;
	public Peon(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
	}
	
	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();
		if(start) {
			movements(resultado, 1);
			movements(resultado, 2);
			diagonals(resultado, 1);
			diagonals(resultado, 2);
			start=false;
		}
		else {
			movements(resultado, 1);
			diagonals(resultado, 1);
		}
		

		return resultado;
	}
	
	
	private void diagonals(ArrayList<Casilla> resultado,int i) {
		
		/*
		 A - B
		 - * - 
		 C - D
		
		 */
		
		
		if(this.getJugador().getId() == ControlJugadoresAjedrez.NEGRO) {
//							COMPROBAMOS QUE HAYA ALGO EN ESA POS				 	 En esa posicion hay ficha de otro color
			boolean checkC=(queHay(this.getFila() - i, this.getColumna()-i)!=null && queHay(this.getFila() - i, this.getColumna()-i).getJugador().getId()==ControlJugadoresAjedrez.BLANCO) ;
			boolean checkD=(queHay(this.getFila() - i, this.getColumna()+i)!=null && queHay(this.getFila() - i, this.getColumna()+i).getJugador().getId()==ControlJugadoresAjedrez.BLANCO);
			
			if (checkC)// CHECK C
				casillasVisitables(resultado, this.getFila() - i, this.getColumna()-i);
			else if(checkD) //CHECK D
				casillaVisitable(resultado, this.getFila() - i, this.getColumna()-i);
		}
		
		
		
		
		
	}
	private void movements(ArrayList<Casilla> resultado,int i) {
		if(this.getJugador().getId() == ControlJugadoresAjedrez.NEGRO && (queHay(this.getFila() - i, this.getColumna())!=null&& queHay(this.getFila() - i, this.getColumna()).getJugador().getId()!=ControlJugadoresAjedrez.BLANCO))
			casillaVisitable(resultado, this.getFila() - i, this.getColumna());
		else if(this.getJugador().getId() == ControlJugadoresAjedrez.BLANCO && ((queHay(this.getFila() - i, this.getColumna())!=null && queHay(this.getFila() - i, this.getColumna()).getJugador().getId()!=ControlJugadoresAjedrez.NEGRO )))
			casillaVisitable(resultado, this.getFila() + i, this.getColumna());
	}
	
	
}
