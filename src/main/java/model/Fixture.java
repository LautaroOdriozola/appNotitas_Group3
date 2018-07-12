package model;

import java.util.ArrayList;
import java.util.List;

import repositories.RepoEstudiantes;

public class Fixture {

	public static void initialize() {
		
		Estudiante naylaWinter = new Estudiante("Nayla Winter", 1591915, "naylawinter");
		Estudiante lautaroOdriozola = new Estudiante("Lautaro Odriozola", 1566076, "lautaroOdriozola");
		
		List<String> notasArena = new ArrayList<>();
		notasArena.add("B");
		notasArena.add("B+");
		
		List<String> notasOp = new ArrayList<>();
		notasArena.add("8");
		notasArena.add("9");
		
		List<String> notasSup = new ArrayList<>();
		notasArena.add("6");
		notasArena.add("10");
		
		Asignacion tpArena = new Asignacion("TP ARENA", false, notasArena);
		Asignacion operativos = new Asignacion("Sistemas operativos", true, notasOp);
		Asignacion matsuperior = new Asignacion("Matematica superior", true, notasSup);
		
		List<Asignacion> asigNayla = new ArrayList<>();
		asigNayla.add(tpArena);
		asigNayla.add(matsuperior);
		
		List<Asignacion> asigLauti = new ArrayList<>();
		asigLauti.add(tpArena);
		asigLauti.add(operativos);
		
		naylaWinter.setAsignaciones(asigNayla);
		lautaroOdriozola.setAsignaciones(asigLauti);
		
		
		RepoEstudiantes.getInstance().nuevoEstudiante(naylaWinter);
		RepoEstudiantes.getInstance().nuevoEstudiante(lautaroOdriozola);
		
		
	}

}