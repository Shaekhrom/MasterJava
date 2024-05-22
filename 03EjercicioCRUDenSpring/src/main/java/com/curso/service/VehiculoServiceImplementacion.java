package com.curso.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.curso.model.Vehiculo;

@Service
public class VehiculoServiceImplementacion implements VehiculosService {
	
	List<Vehiculo> vehiculos;
	
	public VehiculoServiceImplementacion() {
		vehiculos = new ArrayList<>();
		vehiculos.add(new Vehiculo(111,"Fiesta",22, 120, "Ford"));
		vehiculos.add(new Vehiculo(222,"ibiza",32, 250, "Seat"));
		vehiculos.add(new Vehiculo(333,"Picasso",25, 170, "Seat"));
		vehiculos.add(new Vehiculo(444,"F40",180, 380, "Ferrari"));
		vehiculos.add(new Vehiculo(555,"Aventador",200, 400, "Lamborghini"));
	}
	
	@Override
	public List<Vehiculo> vehiculos() {
		return vehiculos;
	}
	
	@Override
	public Vehiculo buscarVehiculo(int id) {
	    for (Vehiculo vehiculo : vehiculos) {
	        if (vehiculo.getId() == id) {
	            return vehiculo;
	        }
	    }
		return null;
	}

	@Override
	public void agregarVehiculo(Vehiculo vehiculo) {
	    vehiculos.add(vehiculo);
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
	    for (int i = 0; i < vehiculos.size(); i++) {
	        if (vehiculos.get(i).getId() == vehiculo.getId()) {
	            vehiculos.set(i, vehiculo);
	            return;
	        }
	    }
	}

	@Override
	public List<Vehiculo> eliminarVehiculo(int id) {
	    Iterator<Vehiculo> iterator = vehiculos.iterator();
	    while (iterator.hasNext()) {
	        Vehiculo vehiculo = iterator.next();
	        if (vehiculo.getId() == id) {
	            iterator.remove();
	        }
	    }
	    return vehiculos;
	}

}
