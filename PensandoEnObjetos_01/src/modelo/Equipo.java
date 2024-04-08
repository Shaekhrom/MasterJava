package modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

	//atributos
	private String nombre;
	private ArrayList<Jugador> listaJugadores;
	private int partidosGanados;
	
	//constructor
	public Equipo(String nombre, ArrayList<Jugador> listaJugadores1, int partidosGanados) {
		super();
		this.nombre = nombre;
		this.listaJugadores = listaJugadores1;
		this.partidosGanados = partidosGanados;
	}

	
	//getters y setters
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

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}


	//toString
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre +  ", partidosGanados=" + partidosGanados + ", listaJugadores=" +
	listaJugadores + "]";
				 
	}


}
