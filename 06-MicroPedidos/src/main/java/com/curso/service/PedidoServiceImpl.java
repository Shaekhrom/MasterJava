package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.PedidoDAO;
import com.curso.model.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoDAO dao;
	
	@Override
	public void crearPedido(Pedido pedido) {
		dao.save(pedido);

	}

	@Override
	public List<Pedido> listarPedidos() {
		List<Pedido> pedidos = dao.findAll();
	    return pedidos;
	}

}
