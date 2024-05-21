package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa1.Libro;

public class Consultas01Select {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery consulta = em.createQuery("Select l FROM Libro l", Libro.class); //seleccionamos todo con JPAQL
		
		List<Libro> listaConsultas = consulta.getResultList();
		
		for (Libro libro : listaConsultas) {
			System.out.println(libro);
		}
	}
}
