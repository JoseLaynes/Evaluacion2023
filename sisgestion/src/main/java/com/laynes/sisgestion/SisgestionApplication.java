package com.laynes.sisgestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SisgestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisgestionApplication.class, args);
	}

}
