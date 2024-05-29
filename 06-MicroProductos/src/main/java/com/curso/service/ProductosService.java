package com.curso.service;

import java.util.List;

import com.curso.model.Producto;

public interface ProductosService {
	List<Producto>listarProductos();
	
	void restarYActualizarStock(int idProducto, int stock);
	
	double obtenerPrecioDeProducto(int idProducto);
}
