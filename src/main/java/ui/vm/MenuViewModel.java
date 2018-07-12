package ui.vm;

import org.uqbar.commons.utils.Observable;
import model.*;
import repositories.RepoEstudiantes;

import java.util.List;

@Observable
public class MenuViewModel {	

	private Estudiante alumnoSeleccionado;
	private List<Estudiante> estudiantes;
	
	public MenuViewModel() {
		this.estudiantes = RepoEstudiantes.getInstance().all();
	}

	public Estudiante getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}
	
	public void setAlumnoSeleccionado(Estudiante _a) {
		 alumnoSeleccionado = _a;
		 RepoEstudiantes.getInstance().setEstudianteSeleccionado(alumnoSeleccionado);
	}
	
	public List<Asignacion> getNotasAlumnoSeleccionado() {
		return alumnoSeleccionado.getAsignaciones();
	}
	
	public void setEstudiantes(List<Estudiante> est) {
		estudiantes = est;
	}
	
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}


}