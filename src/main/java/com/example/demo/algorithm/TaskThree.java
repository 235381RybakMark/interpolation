package com.example.demo.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class TaskThree {
	
	private double firstVal = 6.0;
	
	public Map<Double, Double> EulerMethod(double n, double b){
		
		n = 5;
		b = 2;
	
		//tu ma byc kod ktory oblicza metoda Eulera i zwraca
		//zmienna typu HashMap<Double, Double>, gdzie klucz to
		//przyblizone rozwiazanie zagadnienia i wartosc to 
		//dokladnosc rozwiazania
		NavigableMap<Double, Double> result = new TreeMap<>();
		result.put(firstVal, Double.MAX_VALUE);
		
		double part = (b - 1) / n;
		
		for(int i = 1; i <= n; i++) {
			double trueResult = trueResult(1+i*part);
			double calcualtedResult = result.lastEntry().getKey() + part * calculation(1+i*part, result.lastEntry().getKey());
			result.put(calcualtedResult, Math.abs(calcualtedResult- trueResult));
			System.out.println("wynik"+i+" " +calcualtedResult +" blad: " + (calcualtedResult - trueResult));
		}
			
			Entry<Double, Double> minVal = Collections.min(result.entrySet(), Entry.comparingByValue());
			
			Map <Double, Double> finalRes = new HashMap<Double,Double>();
		
			finalRes.put(minVal.getKey(), minVal.getValue());
		
		
		return finalRes;
	}
	
	public Map<Double, Double> EulerMethodModified(double n, double b){
		
		n = 5;
		b = 2;
	
		
		//tu ma byc kod ktory oblicza metoda Eulera zmodyfikowanego i zwraca
		//zmienna typu HashMap<Double, Double>, gdzie klucz to
		//przyblizone rozwiazanie zagadnienia i wartosc to 
		//dokladnosc rozwiazania
		NavigableMap<Double, Double> result = new TreeMap<>();
		result.put(firstVal, Double.MAX_VALUE);
		
		double part = (b - 1) / n;
		
		for(int i = 1; i <= n; i++) {
			double trueResult = trueResult(1+i*part);
			double calcualtedResult = result.lastEntry().getKey() + part * calculation(1+i*part + part/2, result.lastEntry().getKey() + part/2 * calculation(1+i*part, result.lastEntry().getKey()));
			result.put(calcualtedResult, Math.abs(calcualtedResult- trueResult));
			System.out.println("wynik"+i+" " +calcualtedResult +" blad: " + (calcualtedResult - trueResult));
		}
			
			Entry<Double, Double> minVal = Collections.min(result.entrySet(), Entry.comparingByValue());
			
			Map <Double, Double> finalRes = new HashMap<Double,Double>();
		
			finalRes.put(minVal.getKey(), minVal.getValue());
		
		
		return finalRes;
	}

	public Map<Double, Double> HeunaMethod(double n, double b){
		
		n = 5;
		b = 2;
		
		//tu ma byc kod ktory oblicza metoda Heuna i zwraca
		//zmienna typu HashMap<Double, Double>, gdzie klucz to
		//przyblizone rozwiazanie zagadnienia i wartosc to 
		//dokladnosc rozwiazania
		NavigableMap<Double, Double> result = new TreeMap<>();
		result.put(firstVal, Double.MAX_VALUE);
		
		double part = (b - 1) / n;
		
		for(int i = 1; i <= n; i++) {
			double trueResult = trueResult(1+i*part);
			double calcualtedResult = result.lastEntry().getKey() + part * (calculation(1+i*part, result.lastEntry().getKey()) + calculation(1+i*part + part, result.lastEntry().getKey() + part*calculation(1+i*part, result.lastEntry().getKey())));
			result.put(calcualtedResult, Math.abs(calcualtedResult- trueResult));
			System.out.println("wynik"+i+" " +calcualtedResult +" blad: " + (calcualtedResult - trueResult));
		}
			
			Entry<Double, Double> minVal = Collections.min(result.entrySet(), Entry.comparingByValue());
			
			Map <Double, Double> finalRes = new HashMap<Double,Double>();
		
			finalRes.put(minVal.getKey(), minVal.getValue());
		
		
		return finalRes;
	}
	
	/////////////////////////////////
	
	private double calculation(double x, double y) {
	//	double part = 5.0 * Math.pow(y, 4.0) - 3.0 * Math.pow(y, 2.0) + 4.0 * y;
		double result = 20.0 * Math.pow(x, 3.0) - 3.0/2.0 * (y - 5.0 * Math.pow(x, 4.0) + (3.0 * Math.pow(x, 2.0))) + 4.0;
		return result;
	}
	
	private double trueResult(double x) {
		double trueResult = 5.0 * Math.pow(x, 4.0) - 3.0 * Math.pow(x, 2.0) + 4.0 * x;
		return trueResult;
	}
	
}
