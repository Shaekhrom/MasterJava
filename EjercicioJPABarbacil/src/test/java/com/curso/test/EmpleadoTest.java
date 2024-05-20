package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.dominio.Departamento;
import com.curso.dominio.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class EmpleadoTest extends JpaUnitTestsEJJPA {
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
    void seleccionarEmpleadoInicialTest() {
        Empleado empleado = em.find(Empleado.class, 1);
        assertNotNull(empleado);
        assertEquals(15, empleado.getDepartamento().getIdDept());
    }

    @Test
    void seleccionarEmpleadoDeDepartamento() {
        Departamento departamento = em.find(Departamento.class, 1);
        assertNotNull(departamento);
        assertNotNull(departamento.getEmpleados());
        assertFalse(departamento.getEmpleados().isEmpty());
        Empleado empleado = departamento.getEmpleados().get(0);
        assertNotNull(empleado);
        assertEquals(1, empleado.getDepartamento().getIdDept());
    }
}