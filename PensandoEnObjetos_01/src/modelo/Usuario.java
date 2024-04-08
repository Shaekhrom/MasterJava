package modelo;

//clase padre de jugador y administrador
public abstract class Usuario {
	
	//atributos
	private int id;
	private String Nombre;
	
	
	
	//constructor
	public Usuario(int id, String nombre) {
		super();
		this.id = id;
		Nombre = nombre;
	}


	//getters and setters
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
	
	

}
