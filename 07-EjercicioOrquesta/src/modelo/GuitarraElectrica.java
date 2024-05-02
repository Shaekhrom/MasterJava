package modelo;
/**
 * 
 * @author Alejandro Barbacil Castro
 * 
 * Clase objeto guitarra electrica, hereda de guitarra
 * 
 */
public class GuitarraElectrica extends Guitarra {

	//atributos
	private int potencia;
		
	
	//constructor
	public GuitarraElectrica(String nombre, String tipo, int numCuerdas, int potencia) {
		super(nombre, tipo, numCuerdas);
		this.potencia = potencia;
	}

	//getters y setters
	public int getPotencia() {
		return potencia;
	}


	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}


	//metodos
	@Override
	public String tocar() {
		return "Tocando la guitarra electrica";
	}
	
}
