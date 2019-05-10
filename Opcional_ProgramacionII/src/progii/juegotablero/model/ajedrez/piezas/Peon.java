package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
import progii.juegotablero.model.ajedrez.ControlJugadoresAjedrez;
import progii.juegotablero.model.ajedrez.PiezaAjedrez;
import progii.juegotablero.model.ajedrez.TipoPiezaAjedrez;
import anotacion.Programacion2; 
@Programacion2 (
		nombreAutor1 = "Santiago",
		apellidoAutor1 = "Moreno Domínguez",
		emailUPMAutor1 = "santiago.morenod@alumnos.upm.es",
		nombreAutor2 = "Fernando",
		apellidoAutor2 = "Bellido Pazos", 
		emailUPMAutor2 = "f.bpazos@alumnos.upm.es"
	)


public class Peon extends PiezaAjedrez {
	private boolean start = this.getJugador().getId() == ControlJugadoresAjedrez.NEGRO ? this.getFilaAjedrez() == 7
			: this.getFilaAjedrez() == 2;

	public Peon(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.PEON, fila, columna);
	}

	@Override
	public ArrayList<Casilla> movimientosValidos() {
		boolean esBlanco = this.getJugador().getId() == ControlJugadoresAjedrez.BLANCO;
		int fila = this.getFila();
		int columna = this.getColumna();

		ArrayList<Casilla> resultado = new ArrayList<>();
		if (start) {
			diagonals(resultado, 1);
			diagonals(resultado, 2);
			movements(resultado, 1);
			// Compruebo si puede mover 2 comprobando antes si puede mover 1
			if (esBlanco && movimientoDentroLimites(fila - 2, columna) && movimientoDentroLimites(fila - 1, columna)
					&& queHay(fila - 1, columna) == null && queHay(fila - 2, columna) == null)
				resultado.add(resultado.size(), new Casilla(fila - 2, columna));
			else if (!esBlanco && movimientoDentroLimites(fila + 2, columna)
					&& movimientoDentroLimites(fila + 1, columna) && queHay(fila + 1, columna) == null
					&& queHay(fila + 2, columna) == null)
				resultado.add(resultado.size(), new Casilla(fila + 2, columna));
			start = false;
		} else {
			movements(resultado, 1);
			diagonals(resultado, 1);

		}

		return resultado;
	}

	private void diagonals(ArrayList<Casilla> resultado, int i) {
		boolean esBlanco = this.getJugador().getId() == ControlJugadoresAjedrez.BLANCO;
		int fila = this.getFila();
		int columna = this.getColumna();

		int[][] movements = { { (fila - i), (columna - i) }, { (fila - i), (columna + i) },
				{ (fila + i), (columna - i) }, { (fila + i), (columna + i) } };

		for (int j = 0; j < movements.length; j++) {
			boolean enLimite = movimientoDentroLimites(movements[j][0], movements[j][1]);
			boolean queHay = queHay(movements[j][0], movements[j][1]) != null;

			if (j <= 1 && esBlanco && enLimite && queHay
					&& queHay(movements[j][0], movements[j][1]).getJugador().getId() == ControlJugadoresAjedrez.NEGRO
					|| j >= 2 && !esBlanco && enLimite && queHay && queHay(movements[j][0], movements[j][1])
							.getJugador().getId() == ControlJugadoresAjedrez.BLANCO)
				resultado.add(resultado.size(), new Casilla(movements[j][0], movements[j][1]));
		}
	}

	private void movements(ArrayList<Casilla> resultado, int i) {
		boolean esBlanco = this.getJugador().getId() == ControlJugadoresAjedrez.BLANCO;
		int fila = this.getFila();
		int columna = this.getColumna();

		if (esBlanco && movimientoDentroLimites(fila - i, columna) && queHay(fila - i, columna) == null)
			resultado.add(resultado.size(), new Casilla(fila - i, columna));
		else if (!esBlanco && movimientoDentroLimites(fila + i, columna) && queHay(fila + i, columna) == null)
			resultado.add(resultado.size(), new Casilla(fila + i, columna));
	}

}
