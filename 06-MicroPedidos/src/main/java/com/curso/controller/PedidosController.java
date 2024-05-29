package com.curso.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.curso.model.ItemPedido;
import com.curso.model.Pedido;
import com.curso.service.PedidoService;

@RestController
public class PedidosController {

    @Autowired
    private PedidoService pedidoService; // Servicio encargado de la lógica de negocio relacionada con los pedidos

    @Autowired
    private RestTemplate restTemplate;

    private static final String PRODUCTO_SERVICE_URL = "http://localhost:8000/productos";

    //
    //POST --> http://localhost:7000/pedidos
    /*
    {
	    "id": 1,
	    "nombre": "Pedido 1",
	    "items": [
	        {
	            "productoId": 1,
	            "cantidad": 5
	        },
	        {
	            "productoId": 2,
	            "cantidad": 3
	        }
	    ]
	}
     */
    @PostMapping("/pedidos")
    public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido) {
        try {
            // Guardar el pedido y los ítems del pedido en la base de datos
            pedidoService.crearPedido(pedido);

            // Actualizar el stock de los productos (si es necesario)
            actualizarStockProductos(pedido);

            return ResponseEntity.status(HttpStatus.CREATED).body("Pedido creado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el pedido: " + e.getMessage());
        }
    }

    private void actualizarStockProductos(Pedido pedido) {
        List<ItemPedido> items = pedido.getItems();

        if (!items.isEmpty()) {
            for (ItemPedido item : items) {
                int codigoProducto = item.getProductoId();
                int unidadesCompradas = item.getCantidad();

                // Llamar al microservicio de productos para actualizar el stock
                restarYActualizarStock(codigoProducto, unidadesCompradas);
            }
        } else {
            System.out.println("Error: El pedido no tiene ítems.");
        }
    }

    private void restarYActualizarStock(int idProducto, int stockARestar) {
        String url = PRODUCTO_SERVICE_URL + "/" + idProducto + "/" + stockARestar;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Void> response = restTemplate.exchange(
            url,
            HttpMethod.PUT,
            requestEntity,
            Void.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al actualizar el stock del producto con ID: " + idProducto);
        }
    }
    
    //mostrar todos los pedidos
    @GetMapping(value="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> pedidos(){
    	return pedidoService.listarPedidos();
    }
}

