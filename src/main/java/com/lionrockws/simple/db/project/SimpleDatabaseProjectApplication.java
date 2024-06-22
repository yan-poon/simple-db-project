package com.lionrockws.simple.db.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lionrockws")
public class SimpleDatabaseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDatabaseProjectApplication.class, args);
	}

}
