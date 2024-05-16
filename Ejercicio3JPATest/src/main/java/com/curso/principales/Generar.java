package com.curso.principales;

import java.util.List;

import com.curso.dominio.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * @author AlejandroBarbacil
 * 
 * Esta clase contiene el método principal para generar el esquema de la base de datos
 * y mostrar todas las noticias almacenadas en la misma.
 */
public class Generar {
	public static void main(String[] args) {
        Persistence.generateSchema("bibliotec3", null);
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotec3");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();

        // obtener todas las noticias
        TypedQuery<Noticia> query = entityManager.createQuery("SELECT n FROM Noticia n", Noticia.class);
        List<Noticia> noticias = query.getResultList();

        // mostrar noticias
        for (Noticia noticia : noticias) {
            System.out.println(noticia);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}

