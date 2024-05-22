package com.curso.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vehiculo;
import com.curso.service.VehiculosService;

@RestController
public class VehiculosController {
    
    @Autowired
    VehiculosService service;
    
    @GetMapping(value = "vehiculos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> libros() {
        return service.vehiculos();
    }
    
    @GetMapping(value="vehiculos/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Vehiculo buscarLibro(@PathVariable("id") int id) {
		return service.buscarVehiculo(id);
	}
    
    //insertar libro
    @PostMapping(value = "vehiculos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void agregar(@RequestBody Vehiculo vehiculo) {
        service.agregarVehiculo(vehiculo);
    }
    
    //actualizar vehiculo
    /*
    {
        "isbn": 555,
        "titulo": "tusmuertos",
        "tematica": "viajes"
    }
    */
    @PutMapping(value="vehiculos", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Vehiculo vehiculo) {
        service.actualizarVehiculo(vehiculo);
    }
    //borrar
    @DeleteMapping(value = "vehiculos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> eliminar(@PathVariable("id") int id) {
        return service.eliminarVehiculo(id);
    }
}

