package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa1.Libro;

public class Consultas08SelectPorAtributos {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<String> consulta = em.createQuery("Select l.autor FROM Libro l", String.class); 
			
		List<String> listaConsultas = consulta.getResultList();
		
		for (String autorLibro : listaConsultas) {
			System.out.println(autorLibro);
		}

	}
}
