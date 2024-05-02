package com.viewnext.modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.viewnext.interfaces.Conducible;
/**
 * @author Alejandro Barbacil Castro
 * 
 * Clase que extiende de vehiculo, con el atributo numRuedas fijado a 16, y con
 * un atributo arraylist que va guardando todas las velocidades segun
 * se va llamando a la funcion avanzar
 */
public class Camion extends Vehiculo implements Conducible {
	
	//constante
	private final int numRuedas;
	
	//atributo
    private ArrayList<Double> tacometro = new ArrayList<>();

	//constructor
	public Camion(int id, String modelo, String marca, int caballosDePotencia, String color, String matricula) {
		super(id, modelo, marca, caballosDePotencia, color, matricula);
		this.numRuedas = 16;
	}

	//getters y setters
	public int getNumRuedas() {
		return numRuedas;
	}
	
	 public ArrayList<Double> getTacometro() {
		return tacometro;
	}


	public void setTacometro(ArrayList<Double> tacometro) {
		this.tacometro = tacometro;
	}

	//metodos
	
	@Override
	public String conducir() {
		return "Conduciendo un camion";
	}
	
	/**
	 * Metodo modificado de avanzar para implementar la funcion del tacometro
	 * en la que registra los km/h cada vez que el usuario usa el metodo avanzar
	 */
	@Override
	    public String avanzar(int numMetrosAvanzados) {
	        super.avanzar(numMetrosAvanzados);	        
	        double velocidadActual = super.calcularVelocidadActual();
	        
	        tacometro.add(velocidadActual);
	        
	        return "Avanzo " + numMetrosAvanzados + " metros, Velocidad actual: " + velocidadActual + " km/h" 
	        		+ "  |Estado del tacografo: " + getTacometro();
	    }

}
