package com.curso.service;

import java.util.List;

import com.curso.model.Formacion;

public interface FormacionService {
	List<Formacion> listaCursosExistentes();  //isabel le llamaria formaciones(ns xq)
	void altaCurso(Formacion formacion);
}
