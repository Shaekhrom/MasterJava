package com.curso.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ProductoDAO;
import com.curso.model.Producto;

import jakarta.transaction.Transactional;

@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
    ProductoDAO dao;
	
	
    @Override
    public List<Producto> listarProductos() {
        return dao.findAll();
    }

    @Transactional
    public void restarYActualizarStock(int idProducto, int stockARestar) {
        int stockActual = dao.findStockById(idProducto);
        int nuevoStock = stockActual - stockARestar;
        dao.actualizarStockProducto(idProducto, nuevoStock);
    }

    @Override
    public double obtenerPrecioDeProducto(int idProducto) {
        return dao.obtenerPrecioProducto(idProducto);
    }
}
