package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.algorithm.LagrangeaAlgorithm;

@SpringBootApplication
public class InterpolationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterpolationApplication.class, args);	
		System.out.println(LagrangeaAlgorithm.calculate(0.02));
	}

}
