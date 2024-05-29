package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

import jakarta.transaction.Transactional;

@Service
public class CursosServiceImpl implements CursosService {
	@Autowired
	CursosDao dao;
	@Override
	public void altaCurso(Curso curso) {
		dao.save(curso);
	}

	@Override
	public List<Curso> eliminar(int codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
    @Transactional
    public void actualizarDuracion(int codCurso, int horasDuracion) {
        Curso curso = dao.findById(codCurso).orElse(null);
        if (curso != null) {
            curso.setDuracion(horasDuracion);
            dao.save(curso);
        }
    }

	@Override
	public Curso buscarCurso(int codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	@Override
    public List<Curso> buscarPorRangoDePrecio(int precio1, int precio2) {
        return dao.findByPrecioBetween(precio1, precio2);
    }
	
	@Override
    public List<Curso> obtenerTodosLosCursos() {
        return dao.findAll();
    }

}
