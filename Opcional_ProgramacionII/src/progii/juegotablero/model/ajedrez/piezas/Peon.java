package progii.juegotablero.model.ajedrez.piezas;

import progii.juegotablero.model.ajedrez.ArrayList;
import progii.juegotablero.model.ajedrez.Casilla;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;

public class Peon extends PiezaAjedrez{
	public public Peon(Jugador jugador, int fila, char columna) {
		super(jugador, tipoPiezaAjedrez.PEON, fila, columna);
	}
	
	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado resultado= new ArrayList<Casilla>();
		
		casillasVisitables(resultado, 0, 1);
		
		return resultado;
	}
}
