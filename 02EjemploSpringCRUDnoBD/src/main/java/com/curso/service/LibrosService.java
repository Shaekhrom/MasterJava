package com.curso.service;

import java.util.List;

import com.curso.model.Vehiculo;

public interface LibrosService {
	List<Vehiculo> libros();
	Vehiculo buscarLibro(int isbn);
	void altaLibro(Vehiculo libro);
	void actualizarLibro(Vehiculo libro);
	List<Vehiculo> eliminar(int isbn);
}
