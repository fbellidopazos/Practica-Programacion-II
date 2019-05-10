package progii.juegotablero.model.ajedrez.piezas;

import list.ArrayList;
import progii.juegotablero.model.Jugador;
import progii.juegotablero.model.Casilla;
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

public class Caballo extends PiezaAjedrez {
	public Caballo(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.CABALLO, fila, columna);
	}

	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();
		int fila=this.getFila();
		int columna=this.getColumna();
		/*
		- A - C -
		B - - - E
		- - * - -
		D - - - G
		- F - H -
		 */
		int[][] moves= {{fila+2, columna-1},{fila+1,columna-2},{fila+2,columna+1},{fila+1,columna+2},{fila-1, columna-2},{fila-2,columna-1},{fila-1,columna+2},{fila-2,columna+1}};
		
		
		casillaVisitable(resultado, moves[0][0], moves[0][1]);
		casillaVisitable(resultado, moves[1][0], moves[1][1]);
		casillaVisitable(resultado, moves[2][0], moves[2][1]);
		casillaVisitable(resultado, moves[3][0], moves[3][1]);
		casillaVisitable(resultado, moves[4][0], moves[4][1]);
		casillaVisitable(resultado, moves[5][0], moves[5][1]);
		casillaVisitable(resultado, moves[6][0], moves[6][1]);
		casillaVisitable(resultado, moves[7][0], moves[7][1]);
		
		

		
		
		return resultado;
	}
}
