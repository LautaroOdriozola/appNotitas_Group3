package ui.vm;

import model.*;

import repositories.RepoEstudiantes;

import org.uqbar.commons.utils.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Observable
public class VerNotaAlumnoViewModel {

	private Estudiante estudianteSeleccionado;
	private String nombre;
	private List<Estudiante> estudiantes;
	private List<Asignacion> asignaciones;

	public VerNotaAlumnoViewModel() {
		//estudianteSeleccionado = RepoEstudiantes.getInstance().getEstudianteSeleccionado();
		estudiantes = RepoEstudiantes.getInstance().all();
		this.crearListaAsignaciones();
	}
	
	public List<Estudiante> getEstudiantes(){
		return estudiantes;
	}
	
	public void setNombre(String _n) {
		nombre = _n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void crearListaEstudiantes() {
		estudiantes = new ArrayList<Estudiante>();
	}
	
	public void crearListaAsignaciones() {
		asignaciones = new ArrayList<Asignacion>();
	}
	
	public void getListaDeAsignacionesDeAlumno() {		
		asignaciones = this.devolverEstudiante().getAsignaciones();
	}
	
	public Estudiante devolverEstudiante() {
		return estudiantes.stream().filter(alumno -> alumno.getNombre() == nombre).findFirst().get();
	}
	
	public Boolean tieneEstudiante(String nombreEstudiante) {
		
		List<String> listaDeNombres = listarNombresEstudiantes();
		
		//Comparo strings
		return listaDeNombres.contains(nombreEstudiante);
	}
	
	//Creo lista de string con los nombres de todos los estudiantes
	public List<String> listarNombresEstudiantes(){
		//Creo lista de nombres
		List<String> listaDeNombres;
		listaDeNombres = estudiantes.stream().map(est -> est.getNombre()).collect(Collectors.toList());
		
		return listaDeNombres;		
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
		System.out.println("MOSTRANDO NOTAS");
		//this.getListaDeAsignacionesDeAlumno();
		
	}
	
}