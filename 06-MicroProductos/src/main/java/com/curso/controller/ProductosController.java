package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Producto;
import com.curso.service.ProductosService;

@RestController
public class ProductosController {

	@Autowired
	ProductosService service;
	
	//obtiene todos los productos
	//  http://localhost:8000/productos
	@GetMapping(value="productos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos(){
		return service.listarProductos();
	}
	
	// actualiza el stock de un producto
	// http://localhost:8000/productos/{id}/{stock}
	// http://localhost:8000/productos/5/100
	@PutMapping(value="productos/{id}/{stock}", produces=MediaType.APPLICATION_JSON_VALUE)
    public void actualizarStock(@PathVariable("id") int idProducto, @PathVariable("stock") int stock) {
		service.restarYActualizarStock(idProducto, stock);
    }

    // Obtiene el precio de un producto
    //http://localhost:8000/productos/1/precio
    @GetMapping(value="productos/{id}/precio", produces=MediaType.APPLICATION_JSON_VALUE)
    public double obtenerPrecioDeProducto(@PathVariable("id") int idProducto) {
        return service.obtenerPrecioDeProducto(idProducto);
    }
	
	
}
