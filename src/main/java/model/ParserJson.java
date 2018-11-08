package model;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ParserJson {	
	private static ParserJson instance;

	public static ParserJson getInstance() {
		if(instance == null) instance = new ParserJson();
		return instance;
	}	

	public Estudiante parsearEstudiante(String jsonEstudiante) throws Exception {
		
		JsonElement jelement = new JsonParser().parse(jsonEstudiante);
		
		JsonObject gsonObj = jelement.getAsJsonObject();
		
		int legajo = gsonObj.get("legajo").getAsInt();
		String firstName = gsonObj.get("nombre").getAsString();
		String lastName = gsonObj.get("apellido").getAsString();
		String usuarioGitHub = gsonObj.get("usuarioGithub").getAsString();		
		
		Estudiante estudianteParseado = new Estudiante();
		estudianteParseado.setNombre(firstName);
		estudianteParseado.setApellido(lastName);
		estudianteParseado.setLegajo(legajo);
		estudianteParseado.setusuarioGithub(usuarioGitHub);
		
		estudianteParseado.crearListaAsignaciones();
		List<Asignacion> asignaciones = new ArrayList<Asignacion>();
		
		JsonArray assignments = gsonObj.get("asignaciones").getAsJsonArray();
		
		for(JsonElement assign : assignments) {			
			Asignacion nuevaAsignacion = new Asignacion();			
			JsonObject materia = assign.getAsJsonObject();			
			String nombre = materia.get("nombre").getAsString();			
			
			nuevaAsignacion.setNombre(nombre);
			nuevaAsignacion.crearLista();		
		
			JsonArray notas = materia.get("notas").getAsJsonArray();
			
			for(JsonElement nota : notas) {
				String note = nota.getAsString();							
				nuevaAsignacion.agregarNota(note);
			}			
				
		asignaciones.add(nuevaAsignacion);				
		}
		
		estudianteParseado.setAsignaciones(asignaciones);
		
		return estudianteParseado;		// Devuelvo un nuevo estudiante en un objeto.
	}	
}
