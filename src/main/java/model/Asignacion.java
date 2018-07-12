package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion{
	String nombre;
	String nota;
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
	
	public void setNota(String _n){
		nota = _n;		
	}
	
	public String getNota(){
		return nota;
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