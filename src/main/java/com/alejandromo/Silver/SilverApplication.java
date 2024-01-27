package com.alejandromo.Silver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.alejandromo")
@EntityScan("com.alejandromo.models")
@EnableJpaRepositories("com.alejandromo.repositories")
public class SilverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SilverApplication.class, args);
	}

}