package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FristSpringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(FristSpringbootApplication.class, args);
	
	//Student s=context.getBean(Student.class);
	//s.show();
	}}