package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.model.Bizcocho;

import jakarta.transaction.Transactional;

@Repository
public interface BizcochosDao extends JpaRepository<Bizcocho, Integer> {

    @Query("SELECT COUNT(b) FROM Bizcocho b")
    long countTotal();

    @Query("SELECT COUNT(b) FROM Bizcocho b WHERE b.esVegano = true")
    long countVeganos();

    @Query("SELECT COUNT(b) FROM Bizcocho b WHERE b.idRepostero = :idRepostero")
    long countByRepostero(int idRepostero);
    
    
}
