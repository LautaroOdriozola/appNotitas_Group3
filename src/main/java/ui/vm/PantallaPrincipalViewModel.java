package ui.vm;

import org.uqbar.commons.utils.Observable;

import model.*;
import repositories.RepoEstudiantes;
import requestService.RequestService;

import java.util.List;

@Observable
public class PantallaPrincipalViewModel {	

	private Estudiante estudianteActual;
	private List<Asignacion> asignaciones;
	private String token;

	
	public PantallaPrincipalViewModel(String tokenNuevo) throws Exception{		
		//esta hardcodeado desde el fixture, estoy seteada yo (nay)
		
		//estudianteActual = RepoEstudiantes.getInstance().getEstudianteSeleccionado();
		
		this.token = tokenNuevo;
		
		RequestService req = new RequestService();
		String json = req.getDatosAlumno("", token);
		
		this.estudianteActual = ParserJson.getInstance().parsearEstudiante(json);
		
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
	
	//TODO: Comento metodo porque todavia no devuelve nada en concreto.
	public List<Asignacion> getAsignaciones() {
		/*
		JSONConverter convertidor = new JSONConverter();
		String alumnoEnJSON = convertidor.convertirEstudiateAJSON(estudianteActual);
		
		RequestService reqser = new RequestService();
		String asignacionesJSON = reqser.getDatosAsignaciones(alumnoEnJSON, this.token);
		*/
		
		
		//TODO: this.asignaciones = convertidor.desconvertirNotas(asignacionesJSON);
		
		// return this.asignaciones;
		
		return estudianteActual.getAsignaciones();
	}
	
	public void setAsignaciones(List<Asignacion> _asigns) {
		this.asignaciones = _asigns;
	}
	
	
	public String getToken() {
		return token;
	}


}