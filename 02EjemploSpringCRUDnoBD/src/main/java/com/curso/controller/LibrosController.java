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
import com.curso.service.LibrosService;

@RestController
public class LibrosController {
    
    @Autowired
    LibrosService service;
    
    @GetMapping(value = "libros", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> libros() {
        return service.libros();
    }
    
    @GetMapping(value="libros/{isbn}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Vehiculo buscarLibro(@PathVariable("isbn") int isbn) {
		return service.buscarLibro(isbn);
	}
    
    //insertar libro
    @PostMapping(value = "libros", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void agregar(@RequestBody Vehiculo libro) {
        service.altaLibro(libro);
    }
    
    //actualizar libro
    /*
    {
        "isbn": 555,
        "titulo": "tusmuertos",
        "tematica": "viajes"
    }
    */
    @PutMapping(value="libros", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Vehiculo libro) {
        service.actualizarLibro(libro);
    }
    //borrar
    @DeleteMapping(value = "libros/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> eliminar(@PathVariable("isbn") int isbn) {
        return service.eliminar(isbn);
    }
}

