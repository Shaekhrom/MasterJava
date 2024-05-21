package com.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	private String nombre;
	
	private String apellidos;
	
	private String contrasegna;
		
	private HashMap<String,String> asignaturaYnota;

	
	public Usuario(String nombre, String apellidos, String contrasegna) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasegna = contrasegna;
		this.asignaturaYnota = new HashMap<>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getContrasegna() {
		return contrasegna;
	}


	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}


	public HashMap<String, String> getAsignaturaYnota() {
		return asignaturaYnota;
	}


	public void setAsignaturaYnota(HashMap<String, String> asignaturaYnota) {
		this.asignaturaYnota = asignaturaYnota;
	}

	
	
	
	
}
