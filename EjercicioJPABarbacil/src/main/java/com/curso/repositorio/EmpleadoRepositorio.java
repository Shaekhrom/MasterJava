package com.curso.repositorio;

import com.curso.dominio.Empleado;

public interface EmpleadoRepositorio {
	public Empleado findOne(int numero);
	public Iterable<Empleado> findAll();
	public void save(Empleado comentario);
	public void delete(Empleado comentario);
}
