package gestion;
import org.uqbar.arena.Application;


import org.uqbar.arena.windows.Window;

import model.Fixture;
import requestService.RequestService;
import ui.windows.*;


public class GestionNotasApplication extends Application{

	public static void main(String[] args) {
		
		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
		
		
		RequestService req = new RequestService();
		req.putDatosAlumnos("", token);
		
		//Fixture.initialize();
		new GestionNotasApplication().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new LoginWindow(this);
	}
}