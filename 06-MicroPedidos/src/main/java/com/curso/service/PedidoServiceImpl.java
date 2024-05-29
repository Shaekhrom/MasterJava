package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ItemPedidoDAO;
import com.curso.dao.PedidoDAO;
import com.curso.model.ItemPedido;
import com.curso.model.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDAO dao;
    
    @Autowired
    ItemPedidoDAO daoItem;

    @Override
    public void crearPedido(Pedido pedido) {
        // Guardar el pedido
        dao.save(pedido);

        // Guardar los items del pedido
        List<ItemPedido> items = pedido.getItems();
        if (items != null) {
            for (ItemPedido item : items) {
                // Asignar el pedido al item y luego guardar el item
                item.setPedido(pedido);
                daoItem.save(item);
            }
        }
    }

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = dao.findAll();
        return pedidos;
    }

}
