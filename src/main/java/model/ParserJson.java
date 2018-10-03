package model;
import java.util.List;

import org.json.simple.JSONObject; 
import org.json.simple.parser.*;


public class ParserJson {	
	private static ParserJson instance;

	public static ParserJson getInstance() {
		if(instance == null) instance = new ParserJson();
		return instance;
	}	

	//Asumo que le llega el json en forma de STRING ( SE PUEDE CAMBIAR )
	public Estudiante parsearEstudiante(String jsonEstudiante) throws Exception {
		
		Object objeto = new JSONParser().parse(jsonEstudiante);
		
		JSONObject jsonObjeto = (JSONObject) objeto;		
		
		String firstName = (String) jsonObjeto.get("first_name");
		String lastName = (String) jsonObjeto.get("last_name");
		
		
		String nombreCompleto = firstName + " " + lastName;		
		int legajo = (int) jsonObjeto.get("code");		
		String usuarioGitHub = (String) jsonObjeto.get("github_user");		
		
		Estudiante estudianteParseado = new Estudiante(nombreCompleto, legajo, usuarioGitHub);
		
		return estudianteParseado;		// Devuelvo un nuevo estudiante en un objeto.
	}
	
	public List<Asignacion> parsearNotas(String jsonNotas) throws Exception{
		
	}
	
	
}
