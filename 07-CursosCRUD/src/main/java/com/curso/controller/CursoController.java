package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;

@RestController
public class CursoController {
	@Autowired
	CursoService service;
	
	@PostMapping(value="cursos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> alta(@RequestBody Curso curso){
		return service.alta(curso);
	}
	
	@DeleteMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@PathVariable("codCurso") int codCurso){
		return service.eliminar(codCurso);
	}
	
	@PutMapping(value="cursos/{codCurso}/{duracion}")
	public void actualizarDuracion(@PathVariable("codCurso") int codCurso, int duracion) {
		service.actualizarDuracion(codCurso, duracion);
	}
	
	
	@GetMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<Curso> buscarCurso(@PathVariable("codCurso") int codCurso){
		return service.buscarCurso(codCurso);
	}
	
	@GetMapping(value="cursos/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> findByPrecioBetween(@PathVariable("precioMin") int precioMin, @PathVariable("precioMax") int precioMax){
		return service.findByPrecioBetween(precioMin, precioMax);
	}
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos(){
		return service.cursos();
	}
	
}
