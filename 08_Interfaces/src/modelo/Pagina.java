package modelo;

import interfaces.Imprimible;

public class Pagina implements Imprimible{
	//atributos
	private int nPagina;
	private int nLineas;
	

	//constructor
	public Pagina(int nPagina, int nLineas) {
		super();
		this.nPagina = nPagina;
		this.nLineas = nLineas;
	}
	
	
	//getters y setters
	public int getnPagina() {
		return nPagina;
	}




	public void setnPagina(int nPagina) {
		this.nPagina = nPagina;
	}




	public int getnLineas() {
		return nLineas;
	}




	public void setnLineas(int nLineas) {
		this.nLineas = nLineas;
	}



	//toString
	@Override
	public String toString() {
		return "Pagina [nPagina=" + nPagina + ", nLineas=" + nLineas + "]";
	}


	//metodos de interfaz
	@Override
	public String informeLargo() {
		return "Numero de paginas: " + getnPagina() + " Numero de lineas; " + getnLineas();
	}
	
	@Override
	public int informeCorto() {
		return getnPagina();
	}
	
}
