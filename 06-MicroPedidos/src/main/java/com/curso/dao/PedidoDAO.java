package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Pedido;

public interface PedidoDAO extends JpaRepository<Pedido, Integer> {

}
