package modelo;
/**
 * 
 * @author Alejandro Barbacil Castro
 * 
 * Clase objeto guitarra, hereda de instrumento
 * 
 */
public class Guitarra extends Instrumento {
	
	//atributo
	private int numCuerdas;

	//constructor
	public Guitarra(String nombre, String tipo, int numCuerdas) {
		super(nombre, tipo);
		this.numCuerdas = numCuerdas;
	}

	
	//getters y setters
	public int getNumCuerdas() {
		return numCuerdas;
	}

	public void setNumCuerdas(int numCuerdas) {
		this.numCuerdas = numCuerdas;
	}
	
	//metodo
	@Override
	public String tocar() {
		return super.tocar();
	}

	
}
