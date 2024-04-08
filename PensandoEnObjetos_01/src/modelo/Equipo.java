package modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

	//atributos
	private String nombre;
	private ArrayList<Jugador> listaJugadores;
	
	
	//constructor
	public Equipo(String nombre, ArrayList<Jugador> listaJugadores1) {
		super();
		this.nombre = nombre;
		this.listaJugadores = listaJugadores1;
	}


	//getters and setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}


	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}


	//toString
	@Override
	public String toString() {
		return "\nEquipo [nombre=" + nombre + ", listaJugadores=" + listaJugadores + "]";
	}
	
	
	
	
}
