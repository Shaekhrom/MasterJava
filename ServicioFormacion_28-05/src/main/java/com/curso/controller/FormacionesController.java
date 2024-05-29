package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionesService;

@RestController
public class FormacionesController {
	
	@Autowired
	FormacionesService service;
	
	@GetMapping(value="formaciones")
	List<Object> listaCursos(
			@PathVariable("curso") String curso,
			@PathVariable("tematica") String tematica){
		
		return service.listarCursos();
	}
	
}
