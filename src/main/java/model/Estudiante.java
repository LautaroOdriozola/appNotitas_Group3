package model;

import java.util.List;

import model.Asignacion;

import org.uqbar.commons.utils.Observable;


@Observable
public class Estudiante{
	String nombre;
	String legajo;
	List<Asignacion> asignaciones;
	String usuarioGithub;
	
	public Estudiante(String _n, String _l, String _u, List<Asignacion> _as) {
		nombre = _n;
		legajo = _l;
		asignaciones = _as;
		usuarioGithub = _u;
	}
	
	public int obtenerUltimaNota(Asignacion a) {
		asignaciones.stream().filter(asig -> (asig.getNombre() == a.getNombre())).obtenerUltimaNota();
	}
	
	public boolean aproboAsignacion(Asignacion a) {
		return a.getEstaAprobada(); 
	}
	
	public void setNombre(String _n) {
		nombre = _n;
	}
	
	public void setusuarioGithub(String _ug) {
		usuarioGithub = _ug;
	}
	
	public void setLegajo(String _l) {
		legajo = _l;
	}
	
	public String getLegajo() {
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
	

}