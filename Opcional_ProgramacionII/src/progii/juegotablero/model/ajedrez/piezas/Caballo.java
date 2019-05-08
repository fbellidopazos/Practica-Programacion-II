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
		/* La torre se puede mover en horizontal y vertical
		 * Si hay una ficha de color contrario también puede moverse a esa posición comíendose la pieza 
		*/
		//Vertical descendente según el modelo interno (matriz)
		casillasVisitables (resultado, 1, 0);
		//Vertical ascendente según el modelo interno (matriz)
		casillasVisitables (resultado, -1, 0);
		
		//Horiznotal izquierda según el modelo interno (matriz)
		casillasVisitables (resultado, 0, -1);
		//Horizontal derecha según el modelo interno (matriz)
		casillasVisitables (resultado, 0, 1);
		
		return resultado;
	}
}
