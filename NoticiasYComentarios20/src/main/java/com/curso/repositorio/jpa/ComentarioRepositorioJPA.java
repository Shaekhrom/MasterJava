package com.curso.repositorio.jpa;

import com.curso.modelo.Comentario;
import com.curso.modelo.Noticia;
import com.curso.repositorio.ComentarioRepositorio;

import jakarta.persistence.EntityManager;

public class ComentarioRepositorioJPA implements ComentarioRepositorio {
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

	public Comentario findOne(int numero) {
		return em.find(Comentario.class, numero);
	}

	public Iterable<Comentario> findAll() {
		return em.createQuery("SELECT c FROM Comentario c", Comentario.class).getResultList();
	}

	public void save(Comentario comentario) {
		em.persist(comentario);

	}

	public void delete(Comentario comentario) {
		em.remove(comentario);

	}

}
