package com.curso.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Curso;
import com.curso.model.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SaludoController {
    
    private List<Curso> cursos = new ArrayList<>();
    private Long currentId = 1L;
    
    public SaludoController() {
        cursos.add(new Curso(currentId++, "Java Básico", "Curso introductorio de Java"));
        cursos.add(new Curso(currentId++, "Spring Boot", "Curso avanzado de Spring Boot"));
        cursos.add(new Curso(currentId++, "Microservicios", "Curso sobre arquitectura de microservicios"));
    }

    //Get, localhost:8080/saludo
    @GetMapping(value="saludo", produces=MediaType.TEXT_PLAIN_VALUE)
    public String saludar() {
        return "Hola desde Spring";
    }

    //Get, localhost:8080/saludo/parametroX/parametroY
    @GetMapping(value="saludo/{x}/{y}", produces=MediaType.TEXT_PLAIN_VALUE)
    public String saludar(@PathVariable("x") String a, @PathVariable("y") String b) {
        return "Hola desde Spring " + a + " " + b;
    }

    //Get, localhost:8080/saludo2?x=pepito&y=grillo
    @GetMapping(value="saludo2", produces=MediaType.TEXT_PLAIN_VALUE)
    public String saludar2(@RequestParam("x") String a, @RequestParam("y") String b) {
        return "Hola desde Spring " + a + " " + b;
    }

    //Get, localhost:8080/infocliente
    @GetMapping(value="infocliente", produces=MediaType.APPLICATION_JSON_VALUE)
    public Info informacion() {
        return new Info("jaimito", 22, "bizcochito@gmail.com");
    }
    
    /*CURSOS
	 * localhost:8080/cursos      			--> GET todos los cursos
	 * localhost:8080/cursos/{id} 			--> GET curso con id proporcionado
	 * localhost:8080/cursos/{id}			--> POST dar de alta el curso con id proporcionado, en el cuerpo paso la info
	 * localhost:8080/cursos/{id}			--> DELETE el curso con id proporcionado
	 * localhost:8080/cursos/{id}			--> PUT actualizar el curso con id proporcionado, en el cuerpo paso la info
	 *
	 */

    // Obtener todos los cursos
    @GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> obtenerTodosLosCursos() {
        return cursos;
    }

    // Obtener un curso por ID
    //con direccion http://localhost:8080/cursos/x
    @GetMapping(value="cursos/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable("id") Long id) {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                return ResponseEntity.ok(curso);
            }
        }
        return ResponseEntity.notFound().build();
    }


    // Crear un nuevo curso, en postman, en POST ->body -> raw
    //con direccion http://localhost:8080/cursos
    
    /*
     {
	    "nombre": "Curso de Docker",
	    "descripcion": "Curso completo sobre Docker y contenedores"
	 } 
     */
    
    @PostMapping(value="cursos", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public Curso crearCurso(@RequestBody Curso curso) {
        curso.setId(currentId++);
        cursos.add(curso);
        return curso;
    }

    // Eliminar un curso por ID
    //con direccion http://localhost:8080/cursos/x
    @DeleteMapping(value="cursos/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> eliminarCurso(@PathVariable("id") Long id) {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                cursos.remove(curso);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


    // Actualizar un curso por ID, en postman, en PUT ->body -> raw
    //con direccion http://localhost:8080/cursos/x
    /*
     {
	    "nombre": "Curso de Docker Avanzado",
	    "descripcion": "Curso completo sobre Docker y contenedores, ahora con contenido avanzado"
	 }
     */
    
    @PutMapping(value="cursos/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> actualizarCurso(@PathVariable("id") Long id, @RequestBody Curso cursoActualizado) {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                curso.setNombre(cursoActualizado.getNombre());
                curso.setDescripcion(cursoActualizado.getDescripcion());
                return ResponseEntity.ok(curso);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
