package model;

import model.Estudiante;

public class JSONConverter{
	
	public JSONConverter(){
		
	}
	
	public String convertirEstudiateAJSON(Estudiante alum) {
		
		String aDevolver = "{ \"legajo\" : \"" +  alum.getLegajo() + "\"," +
            " \"nombre\":\"" + alum.getNombre() + "\"," + 
            " \"apellido\":\"" +  alum.getApellido() + "\"," +
            " \"usuarioGithub\":\"" + alum.getusuarioGithub() + "\"}" ;
		
		return aDevolver;
     	}
	
}