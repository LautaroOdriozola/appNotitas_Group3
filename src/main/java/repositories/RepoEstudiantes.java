package repositories;

import java.util.ArrayList;
import java.util.List;

import model.Estudiante;

public class RepoEstudiantes {

	private static RepoEstudiantes instance;
	private Estudiante estudianteSeleccionado;
	private List<Estudiante> estudiantes = new ArrayList<>();

	private RepoEstudiantes() {

	}
	
	public void nuevoEstudiante(Estudiante _e) {
		estudiantes.add(_e);
	}


	public static RepoEstudiantes getInstance() {
		if (instance == null) instance = new RepoEstudiantes();
		return instance;
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