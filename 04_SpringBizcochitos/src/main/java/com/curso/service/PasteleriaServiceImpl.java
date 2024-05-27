package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Bizcocho;
import com.curso.model.Repostero;
import com.curso.dao.BizcochosDao;
import com.curso.dao.ReposteroDao;

@Service
public class PasteleriaServiceImpl implements PasteleriaService {

    @Autowired
    private BizcochosDao bizcochosDao;
    
    @Autowired
    private ReposteroDao reposteroDao;
   
    @Override
    public long countBizcochos() {
        return bizcochosDao.countTotal();
    }
    
    @Override
    public double percentageVeganos() {
        long total = countBizcochos();
        long veganos = bizcochosDao.countVeganos();
        
        if (total > 0) {
            return ((double) veganos / total) * 100;
        } else {
            return 0;
        }
    }
    
    @Override
    public List<String> countBizcochosByRepostero() {
        List<String> result = new ArrayList<>();
        List<Repostero> reposteros = reposteroDao.findAll();
        
        for (Repostero repostero : reposteros) {
            long count = bizcochosDao.countByRepostero(repostero.getIdEmpleado());
            result.add(repostero.getNombre() + ": " + count);
        }

        return result;
    }

    @Override
    public long countReposterosByAgeBetween20And30() {
        return reposteroDao.countByAgeBetween20And30();
    }
    
    @Override
    public double averageSalary() {
        return reposteroDao.findAverageSalary();
    }

    //CREATE
    @Override
	public void insertarElemento(Bizcocho bizcocho) {
		bizcochosDao.save(bizcocho);
	}
    //READ
	@Override
	public List<Bizcocho> mostrarElementos() {
		return bizcochosDao.findAll();
	}
	//UPDATE
	@Override
	public void actualizarElemento(Bizcocho bizcocho) {
		bizcochosDao.save(bizcocho);
	}
	
	//DELETE
	@Override
	public List<Bizcocho> borrarElemento(int idBizcocho) {
		bizcochosDao.deleteById(idBizcocho);
		return bizcochosDao.findAll();
	}
}
