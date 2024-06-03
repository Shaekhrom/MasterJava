package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.curso.controller"})
public class EjMvc1ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjMvc1ThymeleafApplication.class, args);
	}

}
