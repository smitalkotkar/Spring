package com.bsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsmsApplication.class, args);
		
		System.out.println("Welcome to Delux Bakery!");
	}

}
