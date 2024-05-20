package com.curso.repositorio.jpa;

import com.curso.dominio.Departamento;
import com.curso.repositorio.DepartamentoRepositorio;

import jakarta.persistence.EntityManager;

public class DepartamentoRepositorioJPA implements DepartamentoRepositorio {
	private EntityManager entityManager;

	public Departamento findOne(int numero) {
		return entityManager.find(Departamento.class, numero);
	}

	public Iterable<Departamento> findAll() {
		return entityManager.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
	}

	public void save(Departamento departamento) {
		entityManager.persist(departamento);
	}

	public void delete(Departamento departamento) {
		entityManager.remove(departamento);
	}

}
