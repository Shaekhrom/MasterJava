package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.curso.dominio.Departamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class DepartamentoTest extends JpaUnitTestsEJJPA {
	/*
	EntityManagerFactory emf;
	EntityManager em;

	@BeforeEach
	public void iniciar() {
		Persistence.generateSchema("empresa", null);
		emf = Persistence.createEntityManagerFactory("empresa");
		em = emf.createEntityManager();
	}
	*/
	@Test
	void entityManagerFactoryTest() {
		assertNotNull(emf);
	}
	
	@Test 
	void entityManagerTest() {
		assertNotNull(em);
	}
	
	@Test
	@Order(3)
	void seleccionarDepartamentoInicialTest() {
		Departamento departamento = em.find(Departamento.class, 1);
		assertEquals("Departamento 1", departamento.getNombre());
	}
	
	@Test
	@Order(4)
	void borrarDepartamentoInicialTest() {
	    em.getTransaction().begin();
	    try {
	        Departamento departamento = em.find(Departamento.class, 1);
	        assertNotNull(departamento, "El departamento debería existir antes de ser eliminado");
	        
	        em.remove(departamento);
	        
	        // Simular el commit
	        em.flush();

	        Departamento sinDepartamento = em.find(Departamento.class, 1);
	        assertNull(sinDepartamento, "El departamento debería ser nulo después de la eliminación");

	    } finally {
	        // Rollback al final de la prueba para asegurarse de que los cambios se reviertan
	        em.getTransaction().rollback();
	    }
	}

	
	 @Test
	    @Order(4)
	    void insertarDepartamentoTest() {
	        em.getTransaction().begin();
	        try {
	            Departamento departamentoNuevo = new Departamento("Departamento 6", "Localidad 6");
	            em.persist(departamentoNuevo);

	            // Simular el commit
	            em.flush();

	            // Obtener el ID generado
	            int idGenerado = departamentoNuevo.getIdDept();
	            
	            Departamento departamentoInsertado = em.find(Departamento.class, idGenerado);
	            assertNotNull(departamentoInsertado, "El departamento debería haber sido insertado.");
	            assertEquals("Departamento 6", departamentoInsertado.getNombre());
	            assertEquals("Localidad 6", departamentoInsertado.getLocalidad());
	        } finally {
	            // Rollback al final de la prueba para asegurarse de que los cambios se reviertan
	            em.getTransaction().rollback();
	        }
	    }
}
