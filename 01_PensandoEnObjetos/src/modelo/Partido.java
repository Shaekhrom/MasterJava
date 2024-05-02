package modelo;

public class Partido {
	
	//atributos
	private Equipo equipo1;
	private Equipo equipo2;
	private String resultado;
	
	
	//constructor
	public Partido(Equipo equipo1, Equipo equipo2, String resultado) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.resultado = resultado;
	}


	//getters and setters
	public Equipo getEquipo1() {
		return equipo1;
	}


	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}


	public Equipo getEquipo2() {
		return equipo2;
	}


	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	
	//toString
	@Override
	public String toString() {
		return "Partido [equipo1= " + equipo1.getNombre() + ", equipo2= " + equipo2.getNombre() + ", resultado= " + resultado + "]";
	}
	
	
	
}
