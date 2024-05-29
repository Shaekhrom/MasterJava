package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {

    @Autowired
    RestTemplate template;

    private String url = "http://localhost:8080/cursos";

    @Override
    public List<Object> listarCursos() {
        // Realiza una solicitud GET al servicio de CursosController para obtener la lista de cursos
        Object[] cursos = template.getForObject(url, Object[].class);
        return Arrays.asList(cursos);
    }

    @Override
    public void altaCurso(Object obj) {
        // TODO: Implementa la lógica para dar de alta un curso
    }
}
