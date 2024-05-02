package com.viewnext.modelo;

public class Araña extends Animal {

	public Araña(int numPatas) {
		super(numPatas);
	}

	@Override
	public String comer() {
		return "Las arañas comen mosquitos";
	}
}
