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
public class LibroServiceImplementacion implements LibrosService {
	
	List<Vehiculo> libros;
	
	public LibroServiceImplementacion() {
		libros = new ArrayList<>();
		libros.add(new Vehiculo(111,"Grecia","viajes"));
		libros.add(new Vehiculo(222,"Crimen en el parque","novela negra"));
		libros.add(new Vehiculo(333,"Java21","programacion"));
		libros.add(new Vehiculo(444,"Verano en Hawai","poesia"));
		libros.add(new Vehiculo(555,"Italia","viajes"));
	}
	
	@Override
	public List<Vehiculo> libros() {
		return libros;
	}
	
	@Override
	public Vehiculo buscarLibro(int isbn) {
	    for (Vehiculo libro : libros) {
	        if (libro.getIsbn() == isbn) {
	            return libro;
	        }
	    }
		return null;
	}

	@Override
	public void altaLibro(Vehiculo libro) {
	    libros.add(libro);
	}

	@Override
	public void actualizarLibro(Vehiculo libro) {
	    for (int i = 0; i < libros.size(); i++) {
	        if (libros.get(i).getIsbn() == libro.getIsbn()) {
	            libros.set(i, libro);
	            return;
	        }
	    }
	}

	@Override
	public List<Vehiculo> eliminar(int isbn) {
	    Iterator<Vehiculo> iterator = libros.iterator();
	    while (iterator.hasNext()) {
	        Vehiculo libro = iterator.next();
	        if (libro.getIsbn() == isbn) {
	            iterator.remove();
	        }
	    }
	    return libros;
	}

}
