package com.irrah.locadora.desafioLocadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.irrah.locadora.desafioLocadora.repository")
@SpringBootApplication
public class DesafioLocadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioLocadoraApplication.class, args);
	}

}
