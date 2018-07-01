package model;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;
//import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion{
	List<Integer> notas;
	String nombre;
	boolean califNumerica;
	
	
	public int getUltimaNota() {
		return notas.get(0);
	}
	
	public void agregarNota(int n) {
		notas.add(n);
		//add agrega al final
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean getEstaAprobada() {
		if(califNumerica) {
			return this.getUltimaNota() >= 6;
		}else {
			return this.getUltimaNota() == 'B';
			//TODO: faltarian mas casos
		}

	}
	
}