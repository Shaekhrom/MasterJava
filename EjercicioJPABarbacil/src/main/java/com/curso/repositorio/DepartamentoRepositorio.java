package com.curso.repositorio;

import com.curso.dominio.Departamento;

public interface DepartamentoRepositorio {
	public Departamento findOne(int numero);
	public Iterable<Departamento> findAll();
	public void save(Departamento comentario);
	public void delete(Departamento comentario);
}
