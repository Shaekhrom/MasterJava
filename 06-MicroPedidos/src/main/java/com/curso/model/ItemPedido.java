package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido {
	@Id
	private int productoId;
    private int cantidad;
    
    @ManyToOne
    private Pedido pedido;

    public ItemPedido(int productoId, int cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
    
    
}
