package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LagrangeaAlgorithm {

	public static Map<Integer, Integer> calculate(int from, int to, int period) {

		Map<Integer, Integer> fakeData = new HashMap<>();

		boolean change = false;
		int fake = 90;
		
		for (int i = to; i <= (to + period); i++) {
			fakeData.put(i, fake);
			if(change) {
				change = false;
				fake += period;
			}else {
				fake -= period;
				change = true;
			}
		}
		//fakeData.put(1, 2);
		//fakeData.put(2, 3);
		//fakeData.put(3, 5);
		//fakeData.put(5, 7);
		
		return fakeData;

	}

}
