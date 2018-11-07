package ui.vm;

import org.uqbar.commons.utils.Observable;

import model.*;

import java.util.List;

@Observable
public class LoginViewModel {	

	private String usuario;
	private String contrasenia;
	private String token;
	
	//public LoginViewModel() {		
	//}

	public String getUsuario() {
		return usuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	public void setContrasenia(String cont) {
		this.contrasenia = cont;
	}
	
	public void ingresar() {
		//hardcodeado con el token que esta en el tp. 
		this.token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	}
	
	public boolean logueoCorrecto() {
		return token != null || token != "";
	}
	
	public String getToken() {
		return token;
	}
	
	


}