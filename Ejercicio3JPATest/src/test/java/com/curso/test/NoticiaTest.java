package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.dominio.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * @author Alejandro Barbacil
 * Esta clase contiene pruebas unitarias para la funcionalidad relacionada con la clase Noticia.
 * Las pruebas incluyen la creación y manipulación de entidades Noticia utilizando el EntityManager
 * y verifican diferentes operaciones CRUD.
 */
public class NoticiaTest {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    @BeforeEach
    void iniciar() {
        emf=Persistence.createEntityManagerFactory("bibliotec3");
        em = emf.createEntityManager();
    }
    
    @Test
    public void entityManagerFactoryTest() {
        assertNotNull(emf);
    }
    
    @Test
    public void entityManagerTest() {
        assertNotNull(em);
    }
    
    @Test
    public void seleccionarNoticiaTest() {
        Noticia noticia = em.find(Noticia.class, "Noticia 1");
        assertEquals("Autor 1", noticia.getAutor());
    }
    
    @Test
    public void insertarNoticiaTest() {
        em.getTransaction().begin();
        
        Noticia noticia = new Noticia("Nueva Noticia", "Nuevo Autor", new java.util.Date());
        em.persist(noticia);
        em.getTransaction().commit();
        
        Noticia noticiaInsertada = em.find(Noticia.class, "Nueva Noticia");
        assertEquals("Nueva Noticia", noticiaInsertada.getTitulo());
        
        em.getTransaction().begin();
        em.remove(noticia);
        em.getTransaction().commit();
    }
    
    @Test
    public void borrarNoticiaTest() {
        Noticia noticia = em.find(Noticia.class, "Noticia 1");
        em.getTransaction().begin();
        em.remove(noticia);
        em.getTransaction().commit();
        
        Noticia noNoticia = em.find(Noticia.class, "Noticia 1");
        assertNull(noNoticia);
    }
    
}
