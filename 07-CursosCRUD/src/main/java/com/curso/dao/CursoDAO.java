package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Curso;

public interface CursoDAO extends JpaRepository<Curso, Integer> {

	//Buscar curso entre dos precios
	
	/* Forma 1 (menos recomendada pero valida)
	@Query("SELECT c FROM Curso c WHERE c.precio BETWEEN :minPrecio AND :maxPrecio")
	List<Curso> buscarPorPrecio(int minPrecio, int maxPrecio);
	*/
	
	
	
	//Forma 2, recomendada
	List<Curso> findByPrecioBetween (int minPrecio, int maxPrecio);
	
	
}
