package progii.juegotablero.model;

import progii.juegotablero.exceptions.MovimientoException;
import stacks.exceptions.EmptyStackException;
import stacks.Stack;
import anotacion.Programacion2; 
@Programacion2 (
		nombreAutor1 = "Santiago",
		apellidoAutor1 = "Moreno Domínguez",
		emailUPMAutor1 = "santiago.morenod@alumnos.upm.es",
		nombreAutor2 = "Fernando",
		apellidoAutor2 = "Bellido Pazos", 
		emailUPMAutor2 = "f.bpazos@alumnos.upm.es"
	)

/**
 * Clase que gestiona el historial de movimientos de la partida
 * 
 *
 */
public class GestorHistorial {

	/**
	 * Pila con los movimientos a deshacer
	 */
	Stack<Movimiento> pilaDeshacer;

	/**
	 * Pila con los movimientos a rehacer
	 */
	Stack<Movimiento> pilaRehacer;

	/**
	 * Crea e inicializa las pilas del gestor del historial
	 */
	public GestorHistorial() {
		pilaDeshacer = new Stack<>();
		pilaRehacer = new Stack<>();
	}

	/**
	 * Guarda un nuevo movimientos en el historial
	 * 
	 * @param movimiento Movimiento a guardar
	 */
	public void guardarMovimiento(Movimiento movimiento) {

		pilaDeshacer.push(movimiento);
		if (!pilaRehacer.isEmpty())
			pilaRehacer.makeEmpty();
	}

	/**
	 * Devuelve el último movimiento realizado y lo elimina de la pila de deshacer
	 * 
	 * @return El movimiento a deshacer
	 * @throws MovimientoException En caso de que no haya movimientos que deshacer
	 */
	public Movimiento deshacer() throws MovimientoException {

		try {
			Movimiento resMovimiento = pilaDeshacer.pop();
			pilaRehacer.push(resMovimiento);
			return resMovimiento;
		} catch (EmptyStackException e) {
			// si esta vacia lanza excepcion
			throw new MovimientoException("No se puede deshacer porque no hay movimientos para deshacer");
		}

	}

	/**
	 * Devuelve el último movimiento deshecho y lo elimina de la pila de rehacer
	 * 
	 * @return El movimiento a rehacer
	 * @throws MovimientoException En caso de que no haya movimientos que rehacer
	 */
	public Movimiento rehacer() throws MovimientoException {
		try {
			Movimiento resMovimiento = pilaRehacer.pop();
			pilaDeshacer.push(resMovimiento);
			return resMovimiento;

		} catch (EmptyStackException e) {
			throw new MovimientoException("No se puede rehacer porque no hay movimientos para rehacer");
		}

	}

}
