package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Para springboot(sustituye las 3 de abajo):
//@SpringBootApplication(scanBasePackages="com.curso.controller")
//Estas 3 de abajo son para Spring normal
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.curso.controller")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
