package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

public class Rey extends PiezaAjedrez{
	public Rey (Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.REY, fila, columna);
	}
	
	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();
		
		int reyFila=this.getFila();
		int reyColumna=this.getColumna();
		
		/*
		A B C
		D * E
		F G H
		 */
		
		casillaVisitable(resultado, reyFila+1, reyColumna+1);//C
		casillaVisitable(resultado, reyFila+1, reyColumna);//B
		casillaVisitable(resultado, reyFila+1, reyColumna-1); //A
		casillaVisitable(resultado, reyFila, reyColumna-1);//D
		casillaVisitable(resultado, reyFila, reyColumna+1);//E
		casillaVisitable(resultado, reyFila-1, reyColumna+1);//H
		casillaVisitable(resultado, reyFila-1, reyColumna);//G
		casillaVisitable(resultado, reyFila-1, reyColumna-1);//F
		
		return resultado;
	}
}
