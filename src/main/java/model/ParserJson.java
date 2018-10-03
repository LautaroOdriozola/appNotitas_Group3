package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
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
			
		int legajo = (int) jsonObjeto.get("code");		
		String usuarioGitHub = (String) jsonObjeto.get("github_user");		
		
		Estudiante estudianteParseado = new Estudiante();
		estudianteParseado.setNombre(firstName);
		estudianteParseado.setApellido(lastName);
		estudianteParseado.setLegajo(legajo);
		estudianteParseado.setusuarioGithub(usuarioGitHub);
		
		return estudianteParseado;		// Devuelvo un nuevo estudiante en un objeto.
	}
	
	// TODO:: No meto nada en la lista todavia porque hay que definir como armamos las notas 
	// El json ya esta parseado
	public ArrayList<Asignacion> parsearNotas(String jsonNotas) throws Exception{
	
		ArrayList<Asignacion> lista = new ArrayList<Asignacion>();
		
		Object objeto = new JSONParser().parse(jsonNotas);		
		JSONObject jsonObjeto = (JSONObject) objeto;
		
		
		JSONArray jsonArray = (JSONArray) jsonObjeto.get("assignments"); 
		Iterator iterator1 = jsonArray.iterator();

		while(iterator1.hasNext()) {
			JSONObject jsonObjetoAux = (JSONObject) iterator1.next();
			
			//Obtengo id, title y descripcion
			int id = (int)jsonObjetoAux.get("id");			
			String title = (String)jsonObjetoAux.get("title");
			String description = (String)jsonObjetoAux.get("description");
			
			//Obtengo grades
			JSONArray jsonArrayGrades = (JSONArray) jsonObjeto.get("grades"); 
			Iterator iterator2 = jsonArray.iterator();
			
			while(iterator2.hasNext()) {
				JSONObject jsonObjetoAux2 = (JSONObject) iterator2.next();
				
				//Obtengo id, value y fechas.
				int idGrade = (int)jsonObjetoAux2.get("id");
				String value = (String)jsonObjetoAux2.get("value");		//TODO: saco el value como STRING pero puede ser INT
				String created = (String)jsonObjetoAux2.get("created_at");
				String updated = (String)jsonObjetoAux2.get("updated_at");				
			}
			
		}
		
			
		return lista;
	}
	
	
}
