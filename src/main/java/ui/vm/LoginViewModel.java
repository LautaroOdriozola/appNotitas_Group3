package ui.vm;

import org.uqbar.commons.utils.Observable;
import model.*;
import repositories.RepoEstudiantes;

import java.util.List;

@Observable
public class LoginViewModel {	

	private String usuario;
	private String contrasenia;
	private String token;
	
	public LoginViewModel() {		
	}

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
		//TODO: se obtiene el token del estudiante seleccionado
	}
	
	public boolean logueoCorrecto() {
		return token != null || token != "";
	}
	
	public String getToken() {
		return token;
	}
	
	


}