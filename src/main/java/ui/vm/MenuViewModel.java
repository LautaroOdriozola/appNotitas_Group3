package main.java.ui.vm;

import org.uqbar.commons.utils.Observable;


import main.java.model.*;

import java.util.List;

@Observable
public class MenuViewModel {
	

	private Estudiante alumnoSeleccionado;
	public MenuViewModel() {
		super();
	}

	public Estudiante getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}
	
	public void setAlumnoSeleccionado(Estudiante _a) {
		 alumnoSeleccionado = _a;
	}


}