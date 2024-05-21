package com.curso.escuela;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa1.Alumno;

public class EjemploSeleccionarTodos {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("escuela");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Alumno> consulta = em.createNamedQuery("mostrarTodosAlumnos",Alumno.class);
		
		List<Alumno> lista = consulta.getResultList();
		System.out.println("------------Lista de todos los Alumnos---------------");
		for (Alumno a: lista) {
			System.out.println(a);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("------------Alumnos que su apellido Empieza por G---------------");
		TypedQuery<Alumno> consulta2 = em.createNamedQuery("alumnosApellidoEmpiezaConG",Alumno.class);
		List<Alumno> lista2 = consulta2.getResultList();
		for (Alumno a: lista2) {
			System.out.println(a);
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("------------Alumnos matriculados en Historia---------------");
		String curso = "Historia";
		TypedQuery<Alumno> consulta3 = em.createNamedQuery("alumnosMatriculadosEnHistoria",Alumno.class).setParameter("curso", curso)
;
		List<Alumno> lista3 = consulta3.getResultList();
		for (Alumno a: lista3) {
			System.out.println(a);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("------------Alumnos con codigo entre 10 y 17---------------");
		TypedQuery<Alumno> consulta4 = em.createNamedQuery("codigoEntreDosValores",Alumno.class);
		List<Alumno> lista4 = consulta4.getResultList();
		for (Alumno a: lista4) {
			System.out.println(a);
		}
	}

}
