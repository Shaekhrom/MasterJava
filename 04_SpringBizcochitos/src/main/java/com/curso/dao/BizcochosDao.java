package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Bizcocho;

public interface BizcochosDao extends JpaRepository<Bizcocho, Integer> {

}
