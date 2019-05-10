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

public class Alfil extends PiezaAjedrez{
	public Alfil(Jugador jugador, int fila, char columna) {
		super(jugador, TipoPiezaAjedrez.ALFIL, fila, columna);
	}
	
	@Override
	public ArrayList<Casilla> movimientosValidos() {
		ArrayList<Casilla> resultado = new ArrayList<>();
		
		casillasVisitables(resultado, 1, 1);
		casillasVisitables(resultado, -1, 1);
		casillasVisitables(resultado, -1, -1);
		casillasVisitables(resultado, 1, -1);
		
		return resultado;
	}
	
}
