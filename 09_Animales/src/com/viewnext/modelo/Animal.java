package com.viewnext.modelo;

public abstract class Animal {
	
	//atributos de clase
	private int numPatas;

	//constructor
	public Animal(int numPatas) {
		super();
		this.numPatas = numPatas;
	}

	//getters y setters
	public int getNumPatas() {
		return numPatas;
	}

	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}
	
	public String andar() {
		return "Este animal anda sobre " + numPatas + " numero de patas";
	}
	
	public String comer() {
		return "";
	}
	
	
}
