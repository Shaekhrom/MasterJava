package com.curso.principales;

import jakarta.persistence.EntityManager; 
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa1.Libro;

public class Principal01Leer {

	public static void main(String[] args) {
		//esto en JPA se tiene siempre
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		Libro libro = em.find(Libro.class, "3521"); //seleccionamos libro por ID de la BBDD
		System.out.println(libro.toString());
	}

}
