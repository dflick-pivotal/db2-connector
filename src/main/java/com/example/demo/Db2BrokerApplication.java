package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class Db2BrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Db2BrokerApplication.class, args);
	}
}
