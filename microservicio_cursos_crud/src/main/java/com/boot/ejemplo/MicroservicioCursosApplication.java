package com.boot.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller"})
public class MicroservicioCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCursosApplication.class, args);
	}

}
