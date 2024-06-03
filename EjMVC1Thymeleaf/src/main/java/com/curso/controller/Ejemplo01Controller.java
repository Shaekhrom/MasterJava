package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Ejemplo01Controller {
	
	//siempre seran tipo String porque usan el nombre de la pagina a invocar
	@GetMapping
	public String hello() {
		return "hola2";
	}
}
