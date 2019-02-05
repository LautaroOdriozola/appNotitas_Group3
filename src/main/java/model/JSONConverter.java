package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Estudiante;

public class JSONConverter{
	
	public JSONConverter(){
		
	}
	
	public String convertirEstudiateAJSON(Estudiante alum) {
		
		Gson gson = new GsonBuilder().create();
		String toReturn = gson.toJson(alum);		
		
		return toReturn;
     	}
	
}