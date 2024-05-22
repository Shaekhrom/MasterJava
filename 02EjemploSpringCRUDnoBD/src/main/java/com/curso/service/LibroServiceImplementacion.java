package com.curso.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.curso.model.Libro;

@Service
public class LibroServiceImplementacion implements LibrosService {
	
	List<Libro> libros;
	
	public LibroServiceImplementacion() {
		libros = new ArrayList<>();
		libros.add(new Libro(111,"Grecia","viajes"));
		libros.add(new Libro(222,"Crimen en el parque","novela negra"));
		libros.add(new Libro(333,"Java21","programacion"));
		libros.add(new Libro(444,"Verano en Hawai","poesia"));
		libros.add(new Libro(555,"Italia","viajes"));
	}
	
	@Override
	public List<Libro> libros() {
		return libros;
	}
	
	@Override
	public Libro buscarLibro(int isbn) {
	    for (Libro libro : libros) {
	        if (libro.getIsbn() == isbn) {
	            return libro;
	        }
	    }
		return null;
	}

	@Override
	public void altaLibro(Libro libro) {
	    libros.add(libro);
	}

	@Override
	public void actualizarLibro(Libro libro) {
	    for (int i = 0; i < libros.size(); i++) {
	        if (libros.get(i).getIsbn() == libro.getIsbn()) {
	            libros.set(i, libro);
	            return;
	        }
	    }
	}

	@Override
	public List<Libro> eliminar(int isbn) {
	    Iterator<Libro> iterator = libros.iterator();
	    while (iterator.hasNext()) {
	        Libro libro = iterator.next();
	        if (libro.getIsbn() == isbn) {
	            iterator.remove();
	        }
	    }
	    return libros;
	}

}
