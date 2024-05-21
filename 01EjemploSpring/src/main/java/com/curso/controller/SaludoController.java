package com.curso.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Info;

@RestController
public class SaludoController {
	
	//Get, localhost:8080/saludo
	@GetMapping(value="saludo", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Hola desde Spring";
	}
	
	
	//Get, localhost:8080/saludo/parametroX/parametroY
	@GetMapping(value="saludo/{x}/{y}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar(@PathVariable ("x")String a,@PathVariable("y") String b) {
		return "Hola desde spring " + a + "" + b;
	}
	
	
	//Get, localhost:8080/saludo2?x=pepito&y=grillo
	@GetMapping(value="saludo2", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar2(@RequestParam("x")String a,@RequestParam("y") String b) {
		return "Hola desde Spring " + a +" " + b;
	}
	
	
	//Get, localhost:8080/infocliente
	@GetMapping(value="infocliente", produces=MediaType.APPLICATION_JSON_VALUE)
	public Info informacion() {
		return new Info("jaimito", 22, "tusmuertos@gmail.com");
	}
}
