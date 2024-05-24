package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
