package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import com.curso.modelo.Comentario;
import com.curso.repositorio.jpa.ComentarioRepositorioJPA;

class ComentarioRepositorioTest extends JpaUnitTests {
	ComentarioRepositorioJPA repositorio;

	@BeforeEach
	void setup() {
		super.setupTest();
		repositorio = new ComentarioRepositorioJPA();
		repositorio.setEntityManager(em);
	}
	
	@Test
	void inyectarEntityManager() {
		assertEquals(em, repositorio.getEntityManager());
	}
	
	@Test
	public void seleccionarTodosLosComentariosTest() {
		Comentario comentario = repositorio.findAll().iterator().next();
		assertEquals("manolito", comentario.getAutor());
	}
	
	@Test
	void seleccionarUnComentario() {
		Comentario comentario = repositorio.findOne(1);
		assertEquals("que bien", comentario.getTexto());
	}

}
