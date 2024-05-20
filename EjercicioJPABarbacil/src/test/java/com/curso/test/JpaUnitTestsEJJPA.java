package com.curso.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class JpaUnitTestsEJJPA {

	static EntityManagerFactory emf;
	EntityManager em;
	
	
	@BeforeAll
	static void setupStaticTest() {
		Persistence.generateSchema("empresa", null);
		emf = Persistence.createEntityManagerFactory("empresa");
		
	}
	@BeforeEach
	void setupTest() {
		em = emf.createEntityManager();
		
	}
	@AfterEach
	void downTest() {
		em.clear();
		em.close();
	}
	
	@AfterAll
	static void downStaticTest() {
		emf.close();
	}

}
