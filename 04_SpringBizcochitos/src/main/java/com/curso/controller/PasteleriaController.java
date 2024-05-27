package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Bizcocho;
import com.curso.service.PasteleriaServiceImpl;

@RestController
@RequestMapping("/pasteleria")
public class PasteleriaController  {

    @Autowired
    private PasteleriaServiceImpl pasteleriaService;
    
    //URL para postman en GET--> http://localhost:8080/pasteleria/total-bizcochos
    @GetMapping("/total-bizcochos")
    public long getTotalBizcochos() {
        return pasteleriaService.countBizcochos();
    }

    //URL para postman en GET--> http://localhost:8080/pasteleria/porcentaje-veganos
    @GetMapping("/porcentaje-veganos")
    public double getPercentageVeganos() {
        return pasteleriaService.percentageVeganos();
    }
    //URL para postman en GET--> http://localhost:8080/pasteleria/bizcochos-por-repostero
    @GetMapping("/bizcochos-por-repostero")
    public List<String> getBizcochosPorRepostero() {
        return pasteleriaService.countBizcochosByRepostero();
    }
    
    //URL para postman en GET--> http://localhost:8080/pasteleria/reposteros-entre-20-y-30
    @GetMapping("/reposteros-entre-20-y-30")
    public long getReposterosByAgeBetween20And30() {
        return pasteleriaService.countReposterosByAgeBetween20And30();
    }
    
    //URL para postman en GET--> http://localhost:8080/pasteleria/salario-promedio
    @GetMapping("/salario-promedio")
    public double getAverageSalary() {
        return pasteleriaService.averageSalary();
    }
    
    //CREATE para postman en PUT--> http://localhost:8080/pasteleria/insertarBizcochitos
    @PostMapping(value="/insertarBizcochitos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertarElemento(@RequestBody Bizcocho bizcocho) {
    	pasteleriaService.insertarElemento(bizcocho);
    }
    //READ para postman en GET--> http://localhost:8080/pasteleria/listaBizcochitos
    @GetMapping(value = "/listaBizcochitos", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Bizcocho> bizcochos(){
    	return pasteleriaService.mostrarElementos();
    }
    //UPDATE para postman en PUT--> http://localhost:8080/pasteleria/actualizarBizcochitos
    @PutMapping(value="/actualizarBizcochitos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarLibro(@RequestBody Bizcocho bizcocho) {
		pasteleriaService.actualizarElemento(bizcocho);
	}
    //DELETE para postman en DELETE--> http://localhost:8080/pasteleria/xx
    @DeleteMapping(value="/{idBizcocho}")
	List<Bizcocho> eliminar(@PathVariable int idBizcocho){
		return pasteleriaService.borrarElemento(idBizcocho);
	}
}
