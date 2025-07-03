package com.bytearchitect.bytearchitect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @springBootApplication consist of three annotation.
 * @Configuration // Marks this class as a source of Spring bean definitions
 * @EnableAutoConfiguration // Tells Spring Boot to auto-configure beans based on classpath
 * @ComponentScan // Enables scanning for @Component, @Service, @Controller, etc.
 */
@SpringBootApplication
public class BytearchitectApplication {


	public static void main(String[] args) {
		SpringApplication.run(BytearchitectApplication.class, args);
	}

}
