package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion{
	List<String> notas;
	String nombre;
	boolean califNumerica;
	
	public Asignacion(String _nombre, boolean _califNum, List<String> _notas) {
		nombre = _nombre;
		califNumerica = _califNum;
		notas = _notas;
	}
	
	public String getUltimaNota() {
		return notas.get(0);
	}
	
	public void agregarNota(String n) {
		notas.add(n);
		//add agrega al final
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean getEstaAprobada() {
		if(califNumerica) {
			return Integer.valueOf(this.getUltimaNota()) >= 6;
		}else {
			return this.getUltimaNota().startsWith("M");
		}

	}
	
}