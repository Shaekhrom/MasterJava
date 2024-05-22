package com.curso.service;

import java.util.List;

import com.curso.model.Vehiculo;

public interface VehiculosService {
	List<Vehiculo> vehiculos();
	Vehiculo buscarVehiculo(int isbn);
	void agregarVehiculo(Vehiculo vehiculo);
	void actualizarVehiculo(Vehiculo vehiculo);
	List<Vehiculo> eliminarVehiculo(int isbn);
}
