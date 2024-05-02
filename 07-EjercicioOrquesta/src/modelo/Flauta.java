package modelo;

/**
 * 
 * @author Alejandro Barbacil Castro
 * 
 * Clase objeto flauta, hereda de instrumento
 * 
 */
public class Flauta extends Instrumento {
	
	//atributos
	private String modelo;
	
	//constructor
	public Flauta(String nombre, String tipo, String modelo) {
		super(nombre, tipo);
		this.modelo = modelo;
	}
	
	
	//getters y setters
	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	//metodos
	@Override
	public String tocar() {
		return super.tocar() + " ,soplando";
	}
	
	
}
