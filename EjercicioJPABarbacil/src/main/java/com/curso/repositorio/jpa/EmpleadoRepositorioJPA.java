package com.curso.repositorio.jpa;

import com.curso.dominio.Empleado;
import com.curso.repositorio.EmpleadoRepositorio;

import jakarta.persistence.EntityManager;

public class EmpleadoRepositorioJPA implements EmpleadoRepositorio {
	private EntityManager entityManager;

	public Empleado findOne(int numero) {
		return entityManager.find(Empleado.class, numero);
	}

	public Iterable<Empleado> findAll() {
		return entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
	}

	public void save(Empleado empleado) {
		entityManager.persist(empleado);
	}

	public void delete(Empleado empleado) {
		entityManager.remove(empleado);
	}

}
