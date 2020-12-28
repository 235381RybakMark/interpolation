package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math; 

import org.springframework.stereotype.Component;

@Component
public class LagrangeaAlgorithm {


	
	// ------------------------- glowna metoda --------------------------------------
	public static Map<Integer, Double> calculate(double number) {

		Map<Integer, Double> data = new HashMap<Integer, Double>();

		// data = iteracjeProstych(number); 
		
		data.put(1, 3.14); //fake response
		
		return data;
	}
	
	public static Map<Integer, Double> iteracjeProstych (double accuracy) { // incorrect
		
		List <Double> calculationSteps = new LinkedList <Double>();
		
		calculationSteps.add(0.0);
		
		do {
			double last = calculationSteps.get(calculationSteps.size() - 1);
			double approximateResult = 0.0;
			
			approximateResult = 2 * Math.pow(last, 3) + last - Math.sin(last) + 1;
			
			calculationSteps.add(approximateResult);
			
			System.out.println(approximateResult);
			
		}while (calculationSteps.get(calculationSteps.size() - 1) - calculationSteps.get(calculationSteps.size() - 2) > accuracy);
			
		Map<Integer, Double> data = new HashMap<Integer, Double>();
		data.put(calculationSteps.size()-1, calculationSteps.get(calculationSteps.size() - 1));
		
		
		return data;
	}
	
	
}
