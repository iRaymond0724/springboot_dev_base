package com.dumbo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.dumbo.springboot.controller, com.dumbo.springboot.Aspect"})

// for method 2.
//@ServletComponentScan(basePackages = {"com.dumbo.springboot.Filter"})

public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
