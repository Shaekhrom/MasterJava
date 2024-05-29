package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages= {"com.curso.controller","com.curso.service"})
public class ServicioFormacion2805Application {

	public static void main(String[] args) {
		SpringApplication.run(ServicioFormacion2805Application.class, args);
	}
	@Bean
	RestTemplate template() {
		return new RestTemplate();
	}
}
