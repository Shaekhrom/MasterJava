package com.curso.model;

public class Vehiculo {
	private int id;
	private String nombre;
	private int caballosDePotencia;
	private int velocidadMaxima;
	private String marca;
	
	public Vehiculo(int id, String nombre, int caballosDePotencia, int velocidadMaxima, String marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.caballosDePotencia = caballosDePotencia;
		this.velocidadMaxima = velocidadMaxima;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCaballosDePotencia() {
		return caballosDePotencia;
	}

	public void setCaballosDePotencia(int caballosDePotencia) {
		this.caballosDePotencia = caballosDePotencia;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
