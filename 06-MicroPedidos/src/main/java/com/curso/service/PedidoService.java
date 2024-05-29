package com.curso.service;

import java.util.List;

import com.curso.model.Pedido;

public interface PedidoService {
	void crearPedido(Pedido pedido);
	
	List<Pedido>listarPedidos();
}
