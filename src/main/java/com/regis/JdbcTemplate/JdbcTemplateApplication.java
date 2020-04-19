package com.regis.JdbcTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateApplication.class, args);
	}

}
