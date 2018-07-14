package ui.vm;

import org.uqbar.commons.utils.Observable;
import model.*;
import repositories.RepoEstudiantes;

import java.util.List;

@Observable
public class PantallaPrincipalViewModel {	

	private Estudiante estudianteActual;
	private List<Asignacion> asignaciones;

	
	public PantallaPrincipalViewModel() {		
		//esta hardcodeado desde el fixture, estoy seteada yo (nay)
		
		estudianteActual = RepoEstudiantes.getInstance().getEstudianteSeleccionado();	
	}

	public Estudiante getEstudianteActual() {
		return estudianteActual;
	}
	
	public String getNombreEstudianteActual() {
		return estudianteActual.getNombre();
	}
	
	public void setEstudianteActual(Estudiante _a) {
		estudianteActual = _a;
	}
	
	public List<Asignacion> getAsignaciones() {
		return estudianteActual.getAsignaciones();
	}
	
	public void setAsignaciones(List<Asignacion> _asigns) {
		this.asignaciones = _asigns;
	}
	


}