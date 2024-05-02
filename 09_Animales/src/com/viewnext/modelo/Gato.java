package com.viewnext.modelo;

import com.viewnext.interfaz.Mascota;

/**
 * @author Alejandro Barbacil
 * hereda de animal y usa la interfaz mascota
 */
public class Gato extends Animal implements Mascota {
	private String nombre;
	
	public Gato(int numPatas, String nombre) {
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

	//metodos
	@Override
	public String jugar() {
		return "A '" + nombre + "' le gusta jugar con pelotas";
	}
	
	
	@Override
	public String comer() {
		return "A los gatos les gusta comer peces y arañas";
	}

}
