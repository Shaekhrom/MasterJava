package modelo;

import java.util.ArrayList;

//hija de usuario
public class Administrador extends Usuario {
	
	//atributos
	private ArrayList<String> partidosJugados;
	private ArrayList<Equipo> listaEquipos;
	private ArrayList<Jugador> listaJugadores;
	
	
	//constructor
	public Administrador(int id, String nombre, ArrayList<String> partidosJugados, ArrayList<Equipo> listaEquipos,
			ArrayList<Jugador> listaJugadores) {
		super(id, nombre);
		this.partidosJugados = partidosJugados;
		this.listaEquipos = listaEquipos;
		this.listaJugadores = listaJugadores;
	}


	//getters y setters
	public ArrayList<String> getPartidosJugados() {
		return partidosJugados;
	}


	public void setPartidosJugados(ArrayList<String> partidosJugados) {
		this.partidosJugados = partidosJugados;
	}


	public ArrayList<Equipo> getListaEquipos() {
		return listaEquipos;
	}


	public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
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
		return "Administrador [partidosJugados=" + partidosJugados + ", listaEquipos=" + listaEquipos
				+ ", listaJugadores=" + listaJugadores + ", getId()=" + getId() + ", getNombre()=" + getNombre() + "]";
	}
	
	
	
	
	

}
