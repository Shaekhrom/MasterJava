package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosServiceImpl;

@RestController
public class CursosController {
	@Autowired
	CursosServiceImpl service;
	
	//alta curso
	/*Ejemplo con POST en body RAW: http://localhost:8080/cursos
	 {
	    "codCurso": 109,
	    "nombre": "Bizcochillos pequeñitos",
	    "duracion": 12,
	    "precio": 20.42
	  }
	 */
	@PostMapping(value="cursos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	//eliminar curso
	//ejemplo con DELETE: http://localhost:8080/cursos/104
	@DeleteMapping(value="cursos/{codCurso}")
	List<Curso> eliminar(@PathVariable int codCurso){
		return service.eliminar(codCurso);
	}
	
	//actualizar duracion del curso
	//ejemplo con PUT: http://localhost:8080/cursos/101/duracion?horasDuracion=50
	 @PutMapping(value="cursos/{codCurso}/duracion")
	    public void actualizarDuracion(@PathVariable int codCurso, @RequestParam int horasDuracion) {
	        service.actualizarDuracion(codCurso, horasDuracion);
	    }
	
	//buscar curso por id
	 //ejemplo de uso http://localhost:8080/cursos/104
	@GetMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarLibro(@PathVariable("codCurso") int codCurso) {
		return service.buscarCurso(codCurso);
	}
	//mostrar cursos por rango de precio
	//ejemplo de uso http://localhost:8080/cursos?precio1=1&precio2=100
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarPorRangoDePrecio(@RequestParam int precio1, @RequestParam int precio2) {
        return service.buscarPorRangoDePrecio(precio1, precio2);
    }
}
