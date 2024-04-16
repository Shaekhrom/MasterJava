package com.viewnext.modelo;

import com.viewnext.interfaces.Conducible;

/**
 * @author Alejandro Barbacil
 * Esta clase representa un tipo de vehiculo, un coche.
 * Extiende de la clase abstracta vehiculo e implementa los atributos
 * color y matricula.
 */
public class Coche extends Vehiculo implements Conducible{
	
	//constantes
	private final int numRuedas;
	
	//constructor
	public Coche(int id, String modelo, String marca, int caballosDePotencia, String color, String matricula) {
		super(id, modelo, marca, caballosDePotencia, color ,matricula);
		this.numRuedas = 4;
	}

	
	public int getNumRuedas() {
		return numRuedas;
	}

	@Override
	public String toString() {
		return "Coche [id= " + getId() +" color=" + getColor() + ", matricula=" + getMatricula() + ", numRuedas=" + numRuedas + ", Modelo="
				+ getModelo() + ", Marca=" + getMarca() + ", Caballos de potencia=" + getCaballosDePotencia()
				+ "]";
	}
	
	//metodo
	@Override
	public String conducir() {
		return "Manejando un coche";
	}
	
	
	
}
