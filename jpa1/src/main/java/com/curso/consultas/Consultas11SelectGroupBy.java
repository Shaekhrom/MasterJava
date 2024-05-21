package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consultas11SelectGroupBy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		//select con + de 1 tipo de elemento devuelto
		//selecciona con group by y con varios tipos de elementos, en este caso String y double
		//de precio xxx hay xxx elementos
		TypedQuery<Object[]> consulta = em.createQuery("Select l.precio, COUNT(l.precio) FROM Libro l GROUP BY l.precio", Object[].class); 
			
		List<Object[]> listaConsultas = consulta.getResultList();
		
		for (Object[] respuestaConsulta : listaConsultas) {
			System.out.println("De precio " + respuestaConsulta[0] + " hay " + respuestaConsulta[1]  + " elementos");
		}

	}
}
