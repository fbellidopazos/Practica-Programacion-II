package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

public class Alfil extends PiezaAjedrez{
	public Alfil(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.ALFIL, fila, columna);
	}
	
	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<Casilla>();
		
		casillasVisitables(resultado, 1, 1);
		casillasVisitables(resultado, -1, 1);
		casillasVisitables(resultado, -1, -1);
		casillasVisitables(resultado, 1, -1);
		
		return resultado;
	}
	
}
