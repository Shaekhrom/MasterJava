package modelo;
/**
 * 
 * @author Alejandro Barbacil Castro
 * 
 * Clase abstracta para que las demas usen sus elementos
 * 
 */
public abstract class Instrumento {

	//atributos
	private String nombre;
	private String tipo;
	
	
	//constructor
	public Instrumento(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}


	//getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//metodos personalizados
	
	public String tocar() {
		return "Tocando el instrumento '" + getNombre() + "'";
	}
	
	public String afinar() {
		return "Afinando el instrumento " + getNombre();
	}
	
	
	
	
}
