package ui.vm;

import org.uqbar.commons.utils.Observable;
import model.*;
import repositories.RepoEstudiantes;

import java.util.List;

@Observable
public class PantallaPrincipalViewModel {	

	private Estudiante estudianteActual;
	private List<Asignacion> asignaciones;
	private String token;

	
	public PantallaPrincipalViewModel(String token) {		
		//esta hardcodeado desde el fixture, estoy seteada yo (nay)
		
		estudianteActual = RepoEstudiantes.getInstance().getEstudianteSeleccionado();	
		
		
		this.token = token;
		//TODO: llamar al metodo get de service request con el token del estudiante actual
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
		
		//TODO: llamar al service request con el metodo get de asignaciones con el token del estudiante actual
		return estudianteActual.getAsignaciones();
	}
	
	public void setAsignaciones(List<Asignacion> _asigns) {
		this.asignaciones = _asigns;
	}
	
	
	public String getToken() {
		return token;
	}


}