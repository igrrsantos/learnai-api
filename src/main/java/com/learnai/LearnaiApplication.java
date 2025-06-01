package com.learnai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.learnai"})
public class LearnaiApplication {
	public static void main(String[] args) {
		SpringApplication.run(LearnaiApplication.class, args);
	}
}
