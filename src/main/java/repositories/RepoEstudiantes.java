package repositories;

import java.util.ArrayList;
import java.util.List;

import model.Estudiante;

public class RepoEstudiantes {

	private static RepoEstudiantes instance;
	private List<Estudiante> estudiantes = new ArrayList<>();

	private RepoEstudiantes() {

	}

	public static RepoEstudiantes getInstance() {
		if (instance == null) instance = new RepoEstudiantes();
		return instance;
	}


	public List<Estudiante> all() {
		return this.estudiantes;
	}

	public void modificar(Estudiante _est) {
		//TODO: eliminar estudiante
		//TODO: agregarlo de nuevo
	}
}