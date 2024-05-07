package com.cursojava.model;

public class Producto {

	private String nombre;
	private String sector;
	private double precio;
	private int stock;
	
	
	public Producto(String nombre, String sector, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.sector = sector;
		this.precio = precio;
		this.stock = stock;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}
