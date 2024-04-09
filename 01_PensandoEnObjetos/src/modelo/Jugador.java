package modelo;

//hija de usuario
public class Jugador extends Usuario {

	//atributos
	private int golesMarcados;
	private String equipo;
	
	
	//constructor
	public Jugador(int id, String nombre, int golesMarcados, String equipo) {
		super(id, nombre);
		this.golesMarcados = golesMarcados;
		this.equipo = equipo;
	}


	//getters and setters
	public int getGolesMarcados() {
		return golesMarcados;
	}


	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}


	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}


	//toString
	@Override
	public String toString() {
		return "\n             -Jugador [" + "Nombre=" + getNombre() + ", GolesMarcados= " +
	golesMarcados + ", equipo=" + equipo + ", Id()=" + getId() + "]";
	}
	
	
	
	
	
	
	
	
}
