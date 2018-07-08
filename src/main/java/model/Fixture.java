package model;

import repositories.RepoEstudiantes;

public class Fixture {

	public static void initialize() {
		
		//TODO: falta crear asignaciones y crear las listaAsig 
		
		Estudiante naylaWinter = new Estudiante("Nayla Winter", 1591915, "naylawinter");
		Estudiante lautaroOdriozola = new Estudiante("Lautaro Odriozola", 1566076, "lautaroOdriozola");
		
		RepoEstudiantes.getInstance().nuevoEstudiante(naylaWinter);
		RepoEstudiantes.getInstance().nuevoEstudiante(lautaroOdriozola);
		
		
	}

}