package model;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;
//import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion{
	List<Integer> notas;
	String nombre;
	boolean califNumerica;
	
	
	public int obtenerUltimaNota() {
		return notas.get(0);
	}
	
	public void agregarNota(int n) {
		notas.add(n);
		//add agrega al final
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean estaAprobada() {
		if(califNumerica) {
			return this.obtenerUltimaNota() >= 6;
		}else {
			return this.obtenerUltimaNota() == 'B';
		}

	}
	
}