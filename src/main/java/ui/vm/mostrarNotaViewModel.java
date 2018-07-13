package ui.vm;

import model.*;

import repositories.RepoEstudiantes;

import org.uqbar.commons.utils.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Observable
public class mostrarNotaViewModel {
	private Estudiante estudianteSeleccionado;
	private String nombre;
	private String nota;
	
	public mostrarNotaViewModel(String _nombre) {
		nombre = _nombre;
	}
	
	public void setEstudianteSeleccionado(Estudiante _e) {
		estudianteSeleccionado = _e;
	}
	
	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}
	
	public void setNombre(String _n) {
		nombre = _n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNota(String _n) {
		nota = _n;
	}
	
	public String getNota() {
		return nota;
	}
	
	public void procesarCambios() {
	}
	
}
