package com.curso.principales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa1.Libro;

public class Principal02Insertar {
	public static void main(String[] args) {
		//esto en JPA se tiene siempre
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		Libro libro = new Libro(3472, "testInsercion", "Alejandro", 80.52); //seleccionamos libro por ID de la BBDD
		
		em.getTransaction().begin(); //comienza transaccion
		em.persist(libro); //le pasamos el objeto para que lo "persista"
		em.getTransaction().commit(); //hacemos commit a la BBDD
	}
}
