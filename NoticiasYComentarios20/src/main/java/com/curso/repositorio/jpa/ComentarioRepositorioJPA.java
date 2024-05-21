package com.curso.repositorio.jpa;

import com.curso.modelo.Comentario;
import com.curso.modelo.Noticia;
import com.curso.repositorio.ComentarioRepositorio;

import jakarta.persistence.EntityManager;

public class ComentarioRepositorioJPA implements ComentarioRepositorio {
	private EntityManager entityManager;

	public Comentario findOne(int numero) {
		return entityManager.find(Comentario.class, numero);
	}

	public Iterable<Comentario> findAll() {
		return entityManager.createQuery("SELECT c FROM Comentario c", Comentario.class).getResultList();
	}

	public void save(Comentario comentario) {
		entityManager.persist(comentario);

	}

	public void delete(Comentario comentario) {
		entityManager.remove(comentario);

	}

}
