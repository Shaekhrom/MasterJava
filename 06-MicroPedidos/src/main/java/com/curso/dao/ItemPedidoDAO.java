package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.ItemPedido;

public interface ItemPedidoDAO extends JpaRepository<ItemPedido, Integer> {

}
