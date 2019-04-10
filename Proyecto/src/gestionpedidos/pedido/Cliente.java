package gestionpedidos.pedido;
import anotacion.Programacion2;
@Programacion2 (
		nombreAutor1 = "Sara",
		apellidoAutor1 = "Alonso apellido2",
		emailUPMAutor1 = "usr@alumnos.upm.es",
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
