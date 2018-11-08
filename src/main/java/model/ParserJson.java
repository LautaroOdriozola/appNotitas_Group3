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

	//Asumo que le llega el json en forma de STRING ( SE PUEDE CAMBIAR )
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
	
	
	/*public List<Asignacion> parsearNotas(String jsonNotas) throws Exception{
	
		List<Asignacion> lista = new ArrayList<Asignacion>();
		
		JsonElement jelement = new JsonParser().parse(jsonNotas);		

		JsonObject gsonObj = jelement.getAsJsonObject();
		
		JsonArray assignments = gsonObj.get("assignments").getAsJsonArray();
		
		for(JsonElement assign : assignments) {		
						
			JsonObject materia = assign.getAsJsonObject();
			
			 int id = materia.get("id").getAsInt();
			 String title = materia.get("title").getAsString();
			 String description = materia.get("description").getAsString();
			 
			 JsonArray notas = materia.get("grades").getAsJsonArray();
			 
			 for(JsonElement nota : notas) {
				 
				 JsonObject notes = nota.getAsJsonObject();
				 
				 int idNota = notes.get("id").getAsInt();
				 String value = notes.get("value").getAsString();
				 String created_at = notes.get("created_at").getAsString();
				 String updated_at = notes.get("updated_at").getAsString();					 
			 }			 
		}
		
		
		
		
			
		return lista;
	}*/
	
	
}
