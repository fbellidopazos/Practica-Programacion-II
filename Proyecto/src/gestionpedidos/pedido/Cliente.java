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
public class Cliente {
	private String codigo;
		
	public Cliente(String codigo) {
		this.codigo = codigo;		
	}
	
	public String getCodigo(){
		return codigo;
	}
}
