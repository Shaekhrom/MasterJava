package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {
	void altaCurso(Curso curso);
	List<Curso> eliminar(int codCurso);
	void actualizarDuracion(int codCurso, int horasDuracion);
	Curso buscarCurso(int codCurso);
	List<Curso>buscarPorRangoDePrecio(int precio1, int precio2);
}
