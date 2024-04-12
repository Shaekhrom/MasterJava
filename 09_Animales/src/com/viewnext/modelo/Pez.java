package com.viewnext.modelo;

import com.viewnext.interfaz.Mascota;

public class Pez extends Animal implements Mascota {
	private String nombre;
	
	public Pez(int numPatas, String nombre) {
		super(numPatas);
		this.nombre = nombre;
	}

	
	@Override
	public String getNombreMascota() {
		return this.nombre;
	}

	@Override
	public void setNombreMascota(String nombre) {
		this.nombre = nombre;
		
	}

	@Override
	public String jugar() {
		return "Estoy nadando";
	}
	
	@Override
	public String comer() {
		return "Los peces comen plancton";
	}
	
	@Override
	public String andar() {
		return "En realidad no ando, nado";
	}
	
	

}
