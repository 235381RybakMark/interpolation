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

		 data = iteracjeProstych(number); 
		
		return data;
	}
	
	public static Map<Integer, Double> iteracjeProstych (double accuracy) { 
		
		List <Double> calculationSteps = new LinkedList <Double>();
		
		calculationSteps.add(0.0);
		
		do {
			double last = calculationSteps.get(calculationSteps.size() - 1);
			double approximateResult = 0.0;
			
			approximateResult = Math.cbrt((-last + Math.sin(last) - 1) /2);
				
			calculationSteps.add(approximateResult);
			
			System.out.println(approximateResult); 
			
		}while (Math.abs(calculationSteps.get(calculationSteps.size() - 1) - calculationSteps.get(calculationSteps.size() - 2)) > accuracy);
			
		Map<Integer, Double> data = new HashMap<Integer, Double>();
		data.put(calculationSteps.size()-1, calculationSteps.get(calculationSteps.size() - 1));
		
		return data;
	}		
}
