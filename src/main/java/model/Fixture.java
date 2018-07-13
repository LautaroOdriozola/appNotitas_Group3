package model;

import java.util.ArrayList;
import java.util.List;
import model.Asignacion;
import model.Estudiante;
import repositories.RepoEstudiantes;

public class Fixture {

	public static void initialize() {
		
		Estudiante naylaWinter = new Estudiante("Nayla Winter", 1591915, "naylawinter");
		Estudiante lautaroOdriozola = new Estudiante("Lautaro Odriozola", 1566076, "lautaroOdriozola");
				
		
		Asignacion tpArena = new Asignacion("TP ARENA", false);
		tpArena.crearLista();
		tpArena.agregarNota("B");
		tpArena.agregarNota("B+");
		Asignacion operativos = new Asignacion("Sistemas operativos", true);
		operativos.crearLista();
		operativos.agregarNota("8");
		operativos.agregarNota("9");
		Asignacion matsuperior = new Asignacion("Matematica superior", true);
		matsuperior.crearLista();
		matsuperior.agregarNota("6");
		matsuperior.agregarNota("10");
		
		
		List<Asignacion> asigNayla = new ArrayList<Asignacion>();
		asigNayla.add(tpArena);
		asigNayla.add(matsuperior);
		
		List<Asignacion> asigLauti = new ArrayList<Asignacion>();
		asigLauti.add(tpArena);
		asigLauti.add(operativos);
		
		naylaWinter.crearListaAsignaciones();
		naylaWinter.setAsignaciones(asigNayla);
		lautaroOdriozola.crearListaAsignaciones();
		lautaroOdriozola.setAsignaciones(asigLauti);	
	
		
		RepoEstudiantes.getInstance().nuevoEstudiante(naylaWinter);
		RepoEstudiantes.getInstance().nuevoEstudiante(lautaroOdriozola);
		
		RepoEstudiantes.getInstance().setEstudianteSeleccionado(naylaWinter);
		
		
	}

}