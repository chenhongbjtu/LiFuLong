package com.chef.assist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAsync
public class ChefAssistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChefAssistApplication.class, args);
	}

}
