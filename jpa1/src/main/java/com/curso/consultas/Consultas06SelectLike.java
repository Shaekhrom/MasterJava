package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa1.Libro;

public class Consultas06SelectLike {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		//libros en los que su autor comienze por m
		TypedQuery consulta = em.createQuery("Select l FROM Libro l WHERE l.autor LIKE 'm%'", Libro.class); //seleccionamos por autor
			
		List<Libro> listaConsultas = consulta.getResultList();
		
		for (Libro libro : listaConsultas) {
			System.out.println(libro);
		}

	}
}
