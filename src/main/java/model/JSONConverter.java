package model;

import model.Estudiante;

public class JSONConverter{
	
	public JSONConverter(){
		
	}
	
	public String convertirEstudiateAJSON(Estudiante alum) {
		
		String aDevolver = "{ \" code\" : \"" +  alum.getLegajo() + "\"," +
            " \"first_name\":\"" + alum.getNombre() + "\"," + 
            " \"last_name\":\"" +  alum.getApellido() + "\"," +
            " \"github_user\":\"" + alum.getusuarioGithub() + "\"}" ;
		
		return aDevolver;
     	}
	
}