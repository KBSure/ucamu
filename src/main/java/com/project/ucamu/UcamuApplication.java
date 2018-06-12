package com.project.ucamu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UcamuApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(UcamuApplication.class, args);
	}
}
