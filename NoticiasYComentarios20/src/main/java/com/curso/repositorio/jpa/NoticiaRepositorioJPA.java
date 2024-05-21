package com.curso.repositorio.jpa;

import com.curso.modelo.Noticia;
import com.curso.repositorio.NoticiasRepositorio;

import jakarta.persistence.EntityManager;

public class NoticiaRepositorioJPA implements NoticiasRepositorio {
	
	private EntityManager entityManager;
	
	public Noticia findOne(String titulo) {
		
		return entityManager.find(Noticia.class, titulo);
	}

	public Iterable<Noticia> findAll() {
		return entityManager.createQuery("SELECT n FROM Noticia n", Noticia.class).getResultList();
	}

	public void save(Noticia noticia) {
		entityManager.persist(noticia);

	}

	public void delete(Noticia noticia) {
		entityManager.remove(noticia);

	}

}
