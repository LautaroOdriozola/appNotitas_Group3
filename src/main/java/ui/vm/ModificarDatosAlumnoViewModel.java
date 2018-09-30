package ui.vm;

import java.util.List;

import model.*;
import repositories.RepoEstudiantes;
import org.uqbar.commons.utils.Observable;

@Observable
public class ModificarDatosAlumnoViewModel{

	private Estudiante estudianteActual;
	String nombre;
	int legajo;
	String usuarioGithub;

	public ModificarDatosAlumnoViewModel(String token) {
		//TODO: hacerle get al service request con el token que me mandan,
		//setearle los parametros al estudiante actual
	}

	public Estudiante estudianteActual() {
		return estudianteActual;
	}
	
	public void estudianteActual(Estudiante _a) {
		estudianteActual = _a;
	}

	public void setNombre(String _n) {
		nombre = _n;
	}
	
	public void setusuarioGithub(String _ug) {
		usuarioGithub = _ug;
	}
	
	public void setLegajo(int _l) {
		legajo = _l;
	}
	
	public int getLegajo() {
		return legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getusuarioGithub() {
		return usuarioGithub;
	}
	
	public void procesarCambios() {
		
		//TODO: llamar al service request con el metodo de PUT
		estudianteActual.setLegajo(this.legajo);
		estudianteActual.setusuarioGithub(this.usuarioGithub);
		estudianteActual.setNombre(this.nombre);
		
		//supongo que si ya le cambio los datos al estudiante no tengo 
		//que actualizar ningun repo ni nada
	}


}
