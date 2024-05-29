package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Producto;

import jakarta.transaction.Transactional;

public interface ProductoDAO extends JpaRepository<Producto, Integer> {

	// Método para actualizar el stock del producto
	@Query("SELECT p.stockProducto FROM Producto p WHERE p.idProducto = :id")
    int findStockById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.stockProducto = :stock WHERE p.idProducto = :id")
    int actualizarStockProducto(@Param("id") int id, @Param("stock") int stock);

    // Método para obtener el precio de un producto
    @Query("SELECT p.precio FROM Producto p WHERE p.idProducto = :idProducto")
    double obtenerPrecioProducto(@Param("idProducto") int idProducto);
	
}
