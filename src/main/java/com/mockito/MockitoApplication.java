package com.mockito;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockitoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MockitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String s = "{ id:23, name:vishal,interest:[cricket,movies]}";
		
	}

}
