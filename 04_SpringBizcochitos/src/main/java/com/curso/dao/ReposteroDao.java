package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.model.Repostero;

@Repository
public interface ReposteroDao extends JpaRepository<Repostero, Integer> {

    @Query("SELECT COUNT(r) FROM Repostero r WHERE r.edad BETWEEN 20 AND 30")
    long countByAgeBetween20And30();

    @Query("SELECT AVG(r.salario) FROM Repostero r")
    double findAverageSalary();
}
