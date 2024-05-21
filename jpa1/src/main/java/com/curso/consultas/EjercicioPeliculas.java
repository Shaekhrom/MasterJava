package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EjercicioPeliculas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		//De precio xxx hay xxx peliculas
		TypedQuery<Object[]> consulta = em.createQuery("SELECT p.precio_alquiler, COUNT(p) FROM Pelicula p GROUP BY p.precio_alquiler", Object[].class); 
			
		List<Object[]> listaConsultas = consulta.getResultList();
		
		for (Object[] respuestaConsulta : listaConsultas) {
			System.out.println("De precio " + respuestaConsulta[0] + " hay " + respuestaConsulta[1]  + " peliculas");
		}

	}
}
