package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LagrangeaAlgorithm {

	public static Map<Integer, Integer> calculate(int from, int to, int period) {

		Map<Integer, Integer> fakeData = new HashMap<>();

		int fake = 80;
		for (int i = to; i <= (to + period); i++) {
			fakeData.put(i, fake + 5);
		}

		return fakeData;

	}

}
