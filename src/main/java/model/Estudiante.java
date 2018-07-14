package model;

import java.util.ArrayList;
import java.util.List;

import model.Asignacion;

import org.uqbar.commons.utils.Observable;


@Observable
public class Estudiante{
	String nombre;
	int legajo;
	List<Asignacion> asignaciones;
	String usuarioGithub;
	
	public Estudiante(String _n, int _l, String _u){		
		nombre = _n;
		legajo = _l;
		usuarioGithub = _u;		
	}
	
	public void crearListaAsignaciones() {
		asignaciones = new ArrayList<Asignacion>();
	}
	
	public String devolverUltimaNota(Asignacion asig) {
		return asig.getUltimaNota();
	}
	
	public String obtenerUltimaNotaDeAsignacion(Asignacion a) {
		return asignaciones.stream().
				filter(asig -> (asig.getNombre() == a.getNombre())).
				findFirst().
				get().
				getUltimaNota();
	}
	
	/*public boolean aproboAsignacion(Asignacion a) {
		return a.getEstaAprobada(); 
	}*/
	
	public void setNombre(String _n) {
		nombre = _n;
	}
	
	public void setusuarioGithub(String _ug) {
		usuarioGithub = _ug;
	}
	
	public void setLegajo(int _l) {
		legajo = _l;
	}
	
	public void setAsignaciones(List<Asignacion> _asig){
		asignaciones = _asig;
	}
	
	public int getLegajo() {
		return legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getusuarioGithub() {
		return usuarioGithub;
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	
	public void agregarAsignacion(Asignacion _as) {
		asignaciones.add(_as);
	}
	

}