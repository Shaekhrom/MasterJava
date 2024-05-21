package com.curso.principales;

import com.curso.dominio.Categoria;
import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo01 {
	public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //ponemos uds de persistencia persistence.xml
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	Libro libro1 = new Libro("001", "Titulo1", "Jaimito", 65);
	
	Categoria categoria = em.find(Categoria.class, "web");
	libro1.setCategoria(categoria);
	em.persist(libro1);
	
	em.getTransaction().commit();
	}
}
