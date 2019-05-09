package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;

public class Peon extends PiezaAjedrez {
	public Peon(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
	}

	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();

		
		casillaVisitable(resultado, 0, this.getColumna()+1);
		casillaVisitable(resultado, 0, this.getColumna()-1);
		casillaVisitable(resultado, this.getFila()+1, this.getColumna()+1);
		
		return resultado;
	}
}
