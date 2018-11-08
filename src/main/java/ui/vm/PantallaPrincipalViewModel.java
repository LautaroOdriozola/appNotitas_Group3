package ui.vm;

import org.uqbar.commons.utils.Observable;


import model.*;
import requestService.RequestService;

import java.util.ArrayList;
import java.util.List;

@Observable
public class PantallaPrincipalViewModel {	

	private Estudiante estudianteActual;
	private List<Asignacion> asignaciones;
	private String token;

	
	public PantallaPrincipalViewModel(String tokenNuevo) throws Exception{		

		this.token = tokenNuevo;
		
		RequestService req = new RequestService();
		
		String json = req.getDatosAlumno("", token);
		
		this.estudianteActual = ParserJson.getInstance().parsearEstudiante(json);
		this.asignaciones = estudianteActual.getAsignaciones();
		
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
		return this.asignaciones;
	}
	
	public void setAsignaciones(List<Asignacion> _asigns) {
		this.asignaciones = _asigns;
	}
	
	
	public String getToken() {
		return token;
	}


}