package main.java.ui.vm;

import java.util.List;


import main.java.model.*;

import org.uqbar.commons.utils.Observable;

@Observable
public class ModificarDatosAlumnoViewModel{

	private Estudiante alumnoSeleccionado;
	String nombre;
	String legajo;
	String usuarioGithub;

	public ModificarDatosAlumnoViewModel() {
		super();
	}

	public Estudiante getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}
	
	public void setAlumnoSeleccionado(Estudiante _a) {
		 alumnoSeleccionado = _a;
	}

	public void setNombre(String _n) {
		nombre = _n;
	}
	
	public void setusuarioGithub(String _ug) {
		usuarioGithub = _ug;
	}
	
	public void setLegajo(String _l) {
		legajo = _l;
	}
	
	public String getLegajo() {
		return legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getusuarioGithub() {
		return usuarioGithub;
	}


}