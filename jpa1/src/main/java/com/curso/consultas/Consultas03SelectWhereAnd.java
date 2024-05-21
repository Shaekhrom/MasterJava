package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa1.Libro;

public class Consultas03SelectWhereAnd {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery consulta = em.createQuery("Select l FROM Libro l WHERE l.autor = :autor AND l.precio > 50", Libro.class); //seleccionamos por autor
		
		consulta.setParameter("autor", "Manuel"); //le decimos el parametro
		
		List<Libro> listaConsultas = consulta.getResultList();
		
		for (Libro libro : listaConsultas) {
			System.out.println(libro);
		}

	}

}
