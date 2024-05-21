package com.curso.principales;

import java.util.List;

import com.curso.dominio.Categoria;
import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Ejemplo05 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //ponemos uds de persistencia persistence.xml
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Categoria> consulta = em.createQuery("SELECT c FROM Categoria c WHERE SIZE(c.libros) < 3", Categoria.class);
		
		List<Categoria> lista = consulta.getResultList();
		
		for(Categoria categoria:lista) {
			System.out.println(categoria);
		}
	}
}
