package ui.vm;

import model.*;

import repositories.RepoEstudiantes;

import org.uqbar.commons.utils.Observable;

import java.util.List;

@Observable
public class VerNotaAlumnoViewModel {

	private Estudiante estudianteSeleccionado;
	private List<Estudiante> estudiantes;
	private List<Asignacion> asignaciones;

	public VerNotaAlumnoViewModel() {
		estudianteSeleccionado = RepoEstudiantes.getInstance().getEstudianteSeleccionado();
		estudiantes = RepoEstudiantes.getInstance().all();
		//this.asignaciones = estudianteSeleccionado.getAsignaciones();
	}
	
	public List<Estudiante> getEstudiantes(){
		return estudiantes;
	}
	
	public void setEstudiantes(List<Estudiante> _estudiantes) {
		this.estudiantes = _estudiantes;		
	}
	
	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}
	
	public void setEstudianteSeleccionado(Estudiante _e) {
		this.estudianteSeleccionado = _e;		
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones; 
	}

	public void setAsignaciones(List<Asignacion> _asignaciones) {
		this.asignaciones = _asignaciones;
	}
	
	public void setearAsignaciones() {
		asignaciones = estudianteSeleccionado.getAsignaciones();
	}
	
	public void procesarNotas(){
		System.out.println("HOLA");
	}
	
}