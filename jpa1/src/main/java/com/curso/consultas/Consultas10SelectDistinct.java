package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consultas10SelectDistinct {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		//selecciona evitando repetidos
		TypedQuery<String> consulta = em.createQuery("Select DISTINCT l.autor FROM Libro l", String.class); 
			
		List<String> listaConsultas = consulta.getResultList();
		
		for (String autorLibro : listaConsultas) {
			System.out.println(autorLibro);
		}

	}
}
