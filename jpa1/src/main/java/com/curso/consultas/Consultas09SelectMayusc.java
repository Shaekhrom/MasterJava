package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consultas09SelectMayusc {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		//pone todo en mayusculas
		TypedQuery<String> consulta = em.createQuery("Select UPPER(l.autor) FROM Libro l", String.class); 
			
		List<String> listaConsultas = consulta.getResultList();
		
		for (String autorLibro : listaConsultas) {
			System.out.println(autorLibro);
		}

	}
}
