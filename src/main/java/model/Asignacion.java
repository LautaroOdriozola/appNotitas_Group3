package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion{
	String nombre;
	boolean califNumerica;
	List<String> notas;// = new ArrayList<String>();
	
	public Asignacion(String _nombre, boolean _califNum){
		nombre = _nombre;
		califNumerica = _califNum;
	}
	
	public String getUltimaNota() {
		return notas.get(notas.size());
	}
	
	public void crearLista() {
		notas = new ArrayList<String>();
	}
		
	public void agregarNota(String n) {
		notas.add(n);
		//add agrega al final
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEstado() {
		boolean aprobado;
		if(califNumerica) {
			aprobado = Integer.valueOf(this.getUltimaNota()) >= 6;
			
		}else {
			aprobado = this.getUltimaNota().startsWith("M");
		}
		
		if(aprobado) {
			return "Aprobado";
		}else {
			return "Reprobado";
		}

	}
	
}