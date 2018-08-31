package com.project.ucamu;

import com.project.ucamu.interceptor.LoginCheckInterceptor;
import com.project.ucamu.interceptor.RefererCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UcamuApplication implements WebMvcConfigurer {

	@Autowired
	LoginCheckInterceptor loginCheckInterceptor;

	@Autowired
	RefererCheckInterceptor refererCheckInterceptor;

	public static void main(String[] args) {
		SpringApplication.run(UcamuApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/user/login");
		registry.addInterceptor(refererCheckInterceptor)
				.addPathPatterns("/**");
	}
}
