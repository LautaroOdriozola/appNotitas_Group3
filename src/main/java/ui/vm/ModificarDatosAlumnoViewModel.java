package ui.vm;

import java.util.List;

import model.*;
import repositories.RepoEstudiantes;
import requestService.RequestService;

import org.uqbar.commons.utils.Observable;


@Observable
public class ModificarDatosAlumnoViewModel{

	private Estudiante estudianteActual;
	String nombre;
	String apellido;
	int legajo;
	String usuarioGithub;
	String tokenActual;

	public ModificarDatosAlumnoViewModel(String token) {
		this.tokenActual = token;
	}

	public Estudiante estudianteActual() {
		return estudianteActual;
	}
	
	public void estudianteActual(Estudiante _a) {
		estudianteActual = _a;
	}

	public void setNombre(String _n) {
		nombre = _n;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	
	public String getApellido() {
		return apellido;
	}
	
	public String getusuarioGithub() {
		return usuarioGithub;
	}
	
	public void procesarCambios() {
		
		Estudiante estudianteNuevo = new Estudiante();
		estudianteNuevo.setLegajo(this.legajo);
		estudianteNuevo.setusuarioGithub(this.usuarioGithub);
		estudianteNuevo.setNombre(this.nombre);
		estudianteNuevo.setApellido(this.apellido);
		
		System.out.println("Nombre: " + estudianteNuevo.getNombre());
		System.out.println("Apellido: " + estudianteNuevo.getApellido());
		System.out.println("Legajo: " + estudianteNuevo.getLegajo());
		System.out.println("User Github: " + estudianteNuevo.getusuarioGithub());
		
		
		JSONConverter convertidor = new JSONConverter();
		String estudianteJSON = convertidor.convertirEstudiateAJSON(estudianteNuevo);
		
		RequestService reqser = new RequestService();
		reqser.putDatosAlumnos(estudianteJSON, this.tokenActual);
	}


}
