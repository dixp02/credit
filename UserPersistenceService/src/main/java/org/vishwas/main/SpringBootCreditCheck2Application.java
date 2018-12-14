package org.vishwas.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.vishwas.main.DAO")
@ComponentScan("org.vishwas.main")
@EntityScan("org.vishwas.main")

public class SpringBootCreditCheck2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCreditCheck2Application.class, args);
	}
}
