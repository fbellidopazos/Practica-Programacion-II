package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

public class Caballo extends PiezaAjedrez {
	public Caballo(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.CABALLO, fila, columna);
	}

	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();
		int fila=this.getFilaAjedrez();
		int columna=this.getColumnaAjedrez();
		/*
		- A - C -
		B - - - E
		- - * - -
		D - - - G
		- F - H -
		 */
		int[][] moves= {{fila+2, columna-1},{fila+1,columna-2},{fila+2,columna+1},{fila+1,columna+2},{fila-1, columna-2},{fila-2,columna-1},{fila-1,columna+2},{fila-2,columna-1}};
		
		for (int i = 0; i < moves.length; i++) {
			casillaVisitable(resultado, moves[i][0], moves[i][1]);
			
		}
		
		
		
		return resultado;
	}
}
