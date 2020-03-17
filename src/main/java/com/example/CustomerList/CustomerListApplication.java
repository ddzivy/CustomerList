package com.example.CustomerList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class CustomerListApplication {
	private static final Logger log = LoggerFactory.getLogger(CustomerListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerListApplication.class, args);
	}
	   
	@Bean
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
		return (args) -> {
	        jdbcTemplate.update("insert into customer(firstName, lastName) values (?, ?)", "Jaden", "Smith");
	        jdbcTemplate.update("insert into customer(firstName, lastName) values (?, ?)", "Lara", "Croft");
	        jdbcTemplate.update("insert into customer(firstName, lastName) values (?, ?)", "Harry", "Potter");
		};
	}

}
