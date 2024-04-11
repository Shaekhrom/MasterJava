package modelo;
/**
 * 
 * @author Alejandro Barbacil Castro
 * 
 * Clase objeto tambor, hereda de instrumento
 * 
 */
public class Tambor extends Instrumento {
	
	//atributos
	private int tamaño;

	
	//constructor
	public Tambor(String nombre, String tipo, int tamaño) {
		super(nombre, tipo);
		this.tamaño = tamaño;
	}

	//getters y setters
	public int getTamaño() {
		return tamaño;
	}


	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	
	
	//metodo
	public String aporrear() {
		return "Aporreando el tambor '" + getNombre() + "'";
	}

}
