package com.curso.principales;

import java.util.ArrayList;
import java.util.List;

import com.curso.dominio.Categoria;
import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo02 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //ponemos uds de persistencia persistence.xml
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria("categoria1","desc de la c1");
		Libro libro1 = new Libro("B02", "Soy un titulo", "tu", 64);
		Libro libro2 = new Libro("B03", "soy otro titulo", "tambien tu", 99);
		libro1.setCategoria(categoria);
		libro2.setCategoria(categoria);
		
		List<Libro> lista = new ArrayList<Libro>();
		lista.add(libro1);
		lista.add(libro2);
		
		categoria.setLibros(lista);
		em.persist(categoria);
		em.persist(libro1);
		em.persist(libro2);

		em.getTransaction().commit();
		}
}
