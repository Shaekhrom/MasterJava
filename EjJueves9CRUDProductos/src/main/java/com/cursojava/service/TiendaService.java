package com.cursojava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cursojava.model.Producto;

public class TiendaService {
	static ArrayList<Producto> productos= new ArrayList<>(List.of(new Producto("vino","alimentacion", 2.7, 25),
			new Producto("leche", "alimentacion",1.2,70), new Producto("cable usb", "informatica", 5.6, 30),
			new Producto("arroz", "alimentacion", 3.1, 16), new Producto("silla", "hogar",30.6,10),
			new Producto("monitor", "informatica", 125.0, 5), new Producto("escritorio", "hogar", 230.0, 4)));
	
	
	//devuelve la lista entera de productos
	public List<Producto> listaProductos(){
		return productos;
	}
	
	
	//metodo que devuelve una lista de productos segun la seccion o sector
	public List<Producto> listaProductosPorSeccion(String seccion) {
	    return productos.stream()
	                   .filter(p -> p.getSector().equals(seccion))
	                   .collect(Collectors.toList());
	}
	
	
	//añade un producto nuevo a la lista original
	public void agregarProducto(Producto nuevoProducto) {
	    productos.add(nuevoProducto);
	}
	
	
	//modifica un producto de la lista por nombre
	public boolean modificarProducto(String nombre, Producto productoModificado) {
	    for (Producto producto : productos) {
	        if (producto.getNombre().equals(nombre)) {
	            producto.setSector(productoModificado.getSector());
	            producto.setPrecio(productoModificado.getPrecio());
	            producto.setStock(productoModificado.getStock());
	            return true;
	        }
	    }
	    return false;
	}
	
	
	//obtener producto por nombre
	public Producto obtenerProductoPorNombre(String nombre) {
	    for (Producto producto : productos) {
	        if (producto.getNombre().equals(nombre)) {
	            return producto;
	        }
	    }
	    return null;
	}
	
	
	//borrar producto por nombre
	public boolean borrarProductoPorNombre(String nombre) {
	    if(productos.removeIf(producto -> producto.getNombre().equals(nombre))) {
	    	return true;
	    }else {
	    	return false;
	    }
	}
	
}
