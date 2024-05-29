package com.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductoService {

    private static final String PRODUCTOS_URL = "http://localhost:8000/productos";

    @Autowired
    private RestTemplate restTemplate;

    public double obtenerPrecioProducto(int codigoProducto) {
        String url = PRODUCTOS_URL + "/precio/" + codigoProducto;
        ResponseEntity<Double> response = restTemplate.exchange(url, HttpMethod.GET, null, Double.class);
        return response.getBody();
    }

    public void actualizarStock(int codigoProducto, int cantidad) {
        String url = PRODUCTOS_URL + "/stock/" + codigoProducto + "?cantidad=" + cantidad;
        restTemplate.put(url, null);
    }
}
