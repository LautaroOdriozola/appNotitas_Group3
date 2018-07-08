package ui.vm;

import java.util.List;

import model.*;
import repositories.RepoEstudiantes;
import org.uqbar.commons.utils.Observable;

@Observable
public class ModificarDatosAlumnoViewModel{

	private Estudiante alumnoSeleccionado;
	String nombre;
	int legajo;
	String usuarioGithub;

	public ModificarDatosAlumnoViewModel() {
		alumnoSeleccionado = RepoEstudiantes.getInstance().getEstudianteSeleccionado();
	}

	public Estudiante getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}
	
	public void setAlumnoSeleccionado(Estudiante _a) {
		 alumnoSeleccionado = _a;
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
		// Creo estudiante y lo agrego al repo. Hay que chequear si ya estaba asi no se agregan varios
		Estudiante estudiante = new Estudiante(nombre,legajo,usuarioGithub);
		RepoEstudiantes .getInstance().nuevoEstudiante(estudiante);
	}


}
