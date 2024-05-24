package com.curso.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.curso.model.Bizcocho;
import com.curso.model.Repostero;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PasteleriaServiceImpl implements PasteleriaService {

    @PersistenceContext
    private EntityManager entityManager;
   
    @Override
    public long countBizcochos() {
        return (long) entityManager.createNamedQuery("Bizcocho.countTotal").getSingleResult();
    }
    @Override
    public double percentageVeganos() {
        long total = countBizcochos();

        long veganos = (long) entityManager.createNamedQuery("Bizcocho.countVeganos").getSingleResult();

        if (total > 0) {
            double porcentajeVeganos = (double) veganos / total * 100;
            return porcentajeVeganos;
        } else {
            return 0;
        }
    }
    @Override
    public List<String> countBizcochosByRepostero() {
        List<Repostero> reposteros = entityManager.createQuery("SELECT r FROM Repostero r", Repostero.class).getResultList();
        return reposteros.stream()
            .map(repostero -> {
                long count = (long) entityManager.createNamedQuery("Bizcocho.countByRepostero")
                                                 .setParameter("idRepostero", repostero.getIdEmpleado())
                                                 .getSingleResult();
                return repostero.getNombre() + ": " + count;
            })
            .collect(Collectors.toList());
    }
    @Override
    public long countReposterosByAgeBetween20And30() {
        return (long) entityManager.createNamedQuery("Repostero.countByAgeBetween20And30").getSingleResult();
    }
    @Override
    public double averageSalary() {
        return (double) entityManager.createNamedQuery("Repostero.findAverageSalary").getSingleResult();
    }
}
