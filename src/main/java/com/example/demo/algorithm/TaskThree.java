package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TaskThree {
	
	public Map<Double, Double> EulerMethod(double n, double b){
	
		//tu ma byc kod ktory oblicza metoda Eulera i zwraca
		//zmienna typu HashMap<Double, Double>, gdzie klucz to
		//przyblizone rozwiazanie zagadnienia i wartosc to 
		//dokladnosc rozwiazania
		Map<Double, Double> fakeResult = new HashMap<>();
		fakeResult.put(0.1d, 0.1d);
		
		return fakeResult;
	}
	
	public Map<Double, Double> EulerMethodModified(double n, double b){
		
		//tu ma byc kod ktory oblicza metoda Eulera zmodyfikowanego i zwraca
		//zmienna typu HashMap<Double, Double>, gdzie klucz to
		//przyblizone rozwiazanie zagadnienia i wartosc to 
		//dokladnosc rozwiazania
		Map<Double, Double> fakeResult = new HashMap<>();
		fakeResult.put(0.2d, 0.2d);
		
		return fakeResult;
	}

	public Map<Double, Double> HeunaMethod(double n, double b){
		
		//tu ma byc kod ktory oblicza metoda Heuna i zwraca
		//zmienna typu HashMap<Double, Double>, gdzie klucz to
		//przyblizone rozwiazanie zagadnienia i wartosc to 
		//dokladnosc rozwiazania
		Map<Double, Double> fakeResult = new HashMap<>();
		fakeResult.put(0.3d, 0.3d);
		
		return fakeResult;
	}
}
