package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.ItemPedido;
import com.curso.model.Pedido;
import com.curso.service.PedidoService;
import com.curso.service.ProductoService;

@RestController
public class PedidosController {

    @Autowired
    private PedidoService pedidoService; // Servicio encargado de la lógica de negocio relacionada con los pedidos
    
    @Autowired
    private ProductoService productoService; // Servicio encargado de la lógica de negocio relacionada con los productos

    // Este método maneja las solicitudes POST para crear nuevos pedidos
    @PostMapping("/pedidos")
    public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido) {
        // Antes de crear el pedido, actualizamos el stock de los productos en función de los ítems del pedido
        actualizarStockProductos(pedido);
        
        // Luego, creamos el pedido utilizando el servicio de pedidos
        pedidoService.crearPedido(pedido);
        
        // Devolvemos una respuesta HTTP con el estado 201 (CREATED) y un mensaje indicando que el pedido se creó correctamente
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido creado correctamente");
    }

    // Este método actualiza el stock de los productos en función de los ítems del pedido
    private void actualizarStockProductos(Pedido pedido) {
        // Obtenemos la lista de ítems del pedido
        List<ItemPedido> items = pedido.getItems();
        
        // Verificamos si la lista de ítems no está vacía
        if (!items.isEmpty()) {
            // Iteramos sobre cada ítem del pedido
            for (ItemPedido item : items) {
                int codigoProducto = item.getProductoId(); // Obtenemos el código del producto del ítem
                int unidadesCompradas = item.getCantidad(); // Obtenemos la cantidad comprada del ítem
                
                // Llamamos al servicio de productos para actualizar el stock del producto
                productoService.actualizarStock(codigoProducto, unidadesCompradas);
            }
        } else {
            // Si el pedido no tiene ítems, imprimimos un mensaje de error
            System.out.println("Error: El pedido no tiene ítems.");
        }
    }
}
