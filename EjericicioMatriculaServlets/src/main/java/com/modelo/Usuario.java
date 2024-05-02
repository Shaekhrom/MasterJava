package com.modelo;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	
	private String detalles;
	
	private String contrasegna;
	
	private ArrayList<String> matriculas;

	public Usuario(String nombre, String detalles, String contrasegna, ArrayList<String> matriculas) {
		super();
		this.nombre = nombre;
		this.detalles = detalles;
		this.contrasegna = contrasegna;
		this.matriculas = matriculas;
	}
	
	public Usuario(String nombre, String detalles, String contrasegna) {
		this.nombre = nombre;
		this.detalles = detalles;
		this.contrasegna = contrasegna;
		this.matriculas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getContrasegna() {
		return contrasegna;
	}

	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}

	public ArrayList<String> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<String> matriculas) {
		this.matriculas = matriculas;
	}

	
	
	
}
