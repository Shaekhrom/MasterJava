package com.viewnext.modelo;

import com.viewnext.interfaces.Conducible;

/**
 * @author Alejandro Barbacil Castro
 * Clase que extiende de Vehiculo y tiene su atributo propio "tipo de motor", este esta basado
 * en una enumeracion, para que solo se puedan crear motos con motores realmente existentes 
 * y no que el usuario pueda poner lo que quiera. Ademas el numero de ruedas esta como
 * final a 2 ya que es una moto.
 */
public class Moto extends Vehiculo implements Conducible {

	//atributo
	private TipoMotorMoto tipoMotor;
	
	//constantes
	private final int numRuedas;
	
	
	 //constructor
	public Moto(int id, String modelo, String marca, int caballosDePotencia, String color, String matricula, TipoMotorMoto tipoMotor) {
		super(id, modelo, marca, caballosDePotencia, color, matricula);
		this.tipoMotor = tipoMotor;
		this.numRuedas = 2;
	}

	//getters y setters
	public int getNumRuedas() {
		return numRuedas;
	}
	
	public TipoMotorMoto getTipoMotor() {
		return tipoMotor;
	}


	public void setTipoMotor(TipoMotorMoto tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	//toString
	@Override
	public String toString() {
		return "Moto [tipoMotor=" + tipoMotor + ", numRuedas=" + numRuedas + ", Id()=" + getId()
				+ ", Matricula()=" + getMatricula() + ", Color()=" + getColor() + ", Modelo()=" + getModelo()
				+ ", Marca()=" + getMarca() + ", Caballos de potencia()=" + getCaballosDePotencia() + "]";
	}
	
	
	//metodo
		@Override
		public String conducir() {
			return "Llevando una moto";
		}
	

	
}
