package repositories;

import java.util.ArrayList;

import java.util.stream.Collectors;
import java.util.List;

import model.Estudiante;

public class RepoEstudiantes {

	private static RepoEstudiantes instance;
	private Estudiante estudianteSeleccionado;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

	private RepoEstudiantes() {

	}
	
	public void nuevoEstudiante(Estudiante nuevoEstudiante) {
		
		int posicion;
		
		if(this.tieneEstudiante(nuevoEstudiante)) {
			// Busco la posicion donde esta el estudiante en el array
			posicion = posicionEstudiante(nuevoEstudiante);
			//Saco la info del estudiante para modificarla
			Estudiante auxiliar = estudiantes.get(posicion);
			
			//auxiliar.setNombre(nuevoEstudiante.getNombre());
			auxiliar.setLegajo(nuevoEstudiante.getLegajo());
			auxiliar.setusuarioGithub(nuevoEstudiante.getusuarioGithub());
		} else {
			estudiantes.add(nuevoEstudiante);
		}	

	}
	
	//Creo lista de string con los nombres de todos los estudiantes
	public List<String> listarNombresEstudiantes(){
		//Creo lista de nombres
		List<String> listaDeNombres;
		listaDeNombres = estudiantes.stream().map(est -> est.getNombre()).collect(Collectors.toList());
		
		return listaDeNombres;		
	}
	
	//Busco la posicion del estudiante a traves de su nombre
	public int posicionEstudiante(Estudiante _e) {
		List<String> listaDeNombres = listarNombresEstudiantes();
		
		//Busco posicion 
		int posicion;
		posicion = listaDeNombres.indexOf(_e.getNombre());
		
		return posicion;
		
	}
	
	//Verifico si el estudiante ingresado ya estaba en la lista
	public Boolean tieneEstudiante(Estudiante _e) {
			
		List<String> listaDeNombres = listarNombresEstudiantes();
		
		//Comparo strings
		return listaDeNombres.contains(_e.getNombre());
	}


	public static RepoEstudiantes getInstance() {
		if (instance == null) instance = new RepoEstudiantes();
		return instance;
	}
	
	public Estudiante devolverEstudiante(String nombre) {
		return estudiantes.stream().filter(alumno -> alumno.getNombre() == nombre).findFirst().get();
	}


	public List<Estudiante> all() {
		return this.estudiantes;
	}

	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}
	
	public void setEstudianteSeleccionado(Estudiante _est) {
		estudianteSeleccionado = _est;
	}
}