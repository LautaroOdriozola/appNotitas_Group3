package ui.vm;

import model.*;
import repositories.RepoEstudiantes;

import org.uqbar.commons.utils.Observable;

import java.util.List;

@Observable
public class VerNotaAlumnoViewModel {

	private Estudiante estudianteSeleccionado;
	private List<Asignacion> asignaciones;

	public VerNotaAlumnoViewModel() {
		this.asignaciones = estudianteSeleccionado.getAsignaciones();
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
	
	public void mostrarNotas() {
		//como hago q las muestre??
	}
}