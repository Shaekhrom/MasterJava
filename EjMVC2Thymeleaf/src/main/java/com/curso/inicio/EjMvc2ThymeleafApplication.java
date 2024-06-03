package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.curso.controller"})
public class EjMvc2ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjMvc2ThymeleafApplication.class, args);
	}

}
