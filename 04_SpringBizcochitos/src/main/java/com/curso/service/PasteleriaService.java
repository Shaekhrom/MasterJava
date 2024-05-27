package com.curso.service;

import java.util.List;

import com.curso.model.Bizcocho;

public interface PasteleriaService {
    long countBizcochos();
    double percentageVeganos();
    List<String> countBizcochosByRepostero();
    long countReposterosByAgeBetween20And30();
    double averageSalary();
    List<Bizcocho> mostrarElementos();
    void insertarElemento(Bizcocho bizcocho);
    void actualizarElemento(Bizcocho bizcocho);
    List<Bizcocho> borrarElemento(int id);
    
}
