package com.curso.principales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa1.Libro;

public class Principal03Borrar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		Libro libro = em.find(Libro.class, "3472"); //seleccionamos libro por ID de la BBDD
		
		em.getTransaction().begin(); //comienza transaccion
		em.remove(libro); //le pasamos el objeto para que lo elimine
		em.getTransaction().commit(); //hacemos commit a la BBDD

	}

}
