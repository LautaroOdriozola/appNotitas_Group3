package ui.vm;

import org.uqbar.commons.utils.Observable;

import json.JSONConverter;
import model.*;
import repositories.RepoEstudiantes;
import serviceRequest.RequestService;

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
		
		JSONConverter convertidor = new JSONConverter();
		String alumnoEnJSON = convertidor.convertirEstudiateAJSON(estudianteActual);
		
		RequestService reqser = new RequestService();
		String asignacionesJSON = reqser.getDatosAsignaciones(alumnoEnJson, this.token);
		
		//TODO: this.asignaciones = convertidor.desconvertirNotas(asignacionesJSON);
		
		// return this.asignaciones;
	}
	
	public void setAsignaciones(List<Asignacion> _asigns) {
		this.asignaciones = _asigns;
	}
	
	
	public String getToken() {
		return token;
	}


}