package gestionpedidos.pedido;
import anotacion.Programacion2;
@Programacion2 (
		nombreAutor1 = "Sara",
		apellidoAutor1 = "Alonso Fernández",
		emailUPMAutor1 = "sara.alonso.fernandez@alumnos.upm.es",
		nombreAutor2 = "Fernando",
		apellidoAutor2 = "Bellido Pazos", 
		emailUPMAutor2 = "f.bpazos@alumnos.upm.es"
	)
public class PlatoComida {
	private String codigo;
	private double precio;
	private double peso;

	public PlatoComida(String codigo, double precio, double peso) {		
		this.codigo = codigo;
		this.precio = precio;
		this.peso = peso;
	}

	public double getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}
	
	public String getCodigo(){
		return codigo;
	}

	public double getPeso() {
		return peso;
	}
	
	

}
