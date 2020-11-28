package com.example.demo.algorithm;

import java.io.BufferedReader;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class LagrangeaAlgorithm {

	static long[] xval;
	static long[] yval;
	static long[] denominator;
	static double[] point;

	
	// ------------------------- glowna metoda --------------------------------------
	public static Map<Integer, Integer> calculate(int from, int to, int number) {

		Map<Integer, Integer> data = new HashMap<Integer, Integer>();

		data = prep(from, to);
		
		if(data.containsKey(0) && data.containsValue(0))
			return data;
		

		denominator();
		ppoints();
		data.putAll(futureUsage(to, number));
		Equation.equation = createEquation();

		return data;
	}
	
	// ---------------------------wypisanie wielomianu-------------------------

		private static String createEquation() { // wypisanie wielomianu
			StringBuilder equation = new StringBuilder();
			equation.append(point[0]);
			for (int i = 1; i < point.length; i++) {
				equation.append("+");
				equation.append(point[i]);
				for (int j = 0; j < i; j++) {
					equation.append("*").append("(x-(").append(xval[j]).append("))");
				}

			}

			ExprEvaluator util = new ExprEvaluator();
			IExpr result = util.eval(equation.toString());
			String notSimplified = result.toString();
			IExpr resultSimplified = util.eval("simplify(" + notSimplified + ")");
			System.out.println(resultSimplified);
			String simplified = resultSimplified.fullFormString();
			
			return simplified;

		}

	
	
	
	private static Map<Integer, Integer> prep(int from, int to) {
		Map<Integer, Integer> returnedMap = null;
		try {
			Map<Integer, Integer> map;
			map = readValues();
			
			if(map.containsKey(0) && map.containsValue(0))
				return map;

			for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
				Map.Entry<Integer, Integer> entry = it.next();
				if (entry.getKey() > to || entry.getKey() < from) {
					it.remove();
				}
			}

			xval = new long[map.size()];
			yval = new long[map.size()];
			denominator = new long[map.size()];
			point = new double[map.size()];

			for (int i = 0; i < map.size(); i++) {
				List<Integer> list = new ArrayList<Integer>(map.keySet());
				xval[i] = list.get(i);
				yval[i] = map.get((int) xval[i]);
			}
			
		

			returnedMap = map;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnedMap;

	}


	// obliczanie kolejnych punktow
	public static Map<Integer, Integer> futureUsage(int to, int period) {

		Map<Integer, Integer> newData = new HashMap<>();

		for (int i = to + 1; i < to + period + 1; i++) {
			double value = point[0];
			double temp = 0;
			for (int j = 1; j < point.length; j++) {
				temp = point[j];
				for (int k = 0; k < j; k++) {
					temp = temp * (i - xval[k]);
				}
				value = value + temp;
			}
			newData.put(i, (int) value);

		}

		return newData;
	}

	private static void denominator() {
		Arrays.fill(denominator, 1);
		for (int i = 1; i < xval.length; i++) {
			for (int j = 0; j < i; j++) {
				denominator[i] = denominator[i] * (xval[i] - xval[j]);
			}
		}
	}

	private static void ppoints() {

		point[0] = yval[0];

		for (int i = 1; i < xval.length; i++) {
			point[i] = yval[i] - point[0];
			for (int j = 1; j < i; j++) {

				double temp = point[j];

				for (int k = 0; k < j; k++) {
					temp = temp * (xval[i] - xval[k]);
				}
				point[i] = point[i] - temp;
			}
			point[i] = point[i] / denominator[i];
		}
	}

	

	private static Map<Integer, Integer> readValues() throws IOException {
		String filePath = "src/main/resources/oil3.txt";
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		String line;

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");

			Integer key = Integer.parseInt(parts[0]);
			Integer val = Integer.parseInt(parts[1]);
			
			if(map.containsKey(key)) {
				Map<Integer, Integer> emptyMap =  new HashMap<Integer, Integer>();
				emptyMap.put(0,0);
				return emptyMap;
			}

			map.put(key, val);
		}

		reader.close();

		return map;

	}

}
