package ui.vm;

import org.uqbar.commons.utils.Observable;
import model.*;
import repositories.RepoEstudiantes;

import java.util.List;

@Observable
public class PantallaPrincipalViewModel {	

	private Estudiante estudianteActual;

	
	public PantallaPrincipalViewModel() {
	}

	public Estudiante getEstudianteActual() {
		return estudianteActual;
	}
	
	public void setEstudianteActual(Estudiante _a) {
		estudianteActual = _a;
	}
	
	public List<Asignacion> getNotasAlumnoSeleccionado() {
		return estudianteActual.getAsignaciones();
	}
	


}