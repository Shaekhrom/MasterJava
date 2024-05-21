package com.curso.principales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa1.Libro;

public class Principal04Actualizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		Libro libro = em.find(Libro.class, "9780"); //seleccionamos libro por ID de la BBDD
		
		em.getTransaction().begin(); //comienza transaccion
		libro.setAutor("Manuel");  
		libro.setPrecio(67);
		em.merge(libro); //actualziamos datos
		em.getTransaction().commit();

	}
}
