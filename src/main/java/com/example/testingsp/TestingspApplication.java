package com.example.testingsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan("com.example.testingsp")
public class TestingspApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingspApplication.class, args);
	}

}
