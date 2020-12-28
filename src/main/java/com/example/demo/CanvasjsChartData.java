package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.algorithm.*;


public class CanvasjsChartData {
	
	//@Autowired
	//private static AlgorithmDataModel algoritmData = new AlgorithmDataModel();
	
	static Map<Object,Object> map = null;
	static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();	
	
//	public CanvasjsChartData(AlgorithmDataModel algoritmData) {
//		this.algoritmData = algoritmData;
//	}
	
	
	public static void initData(AlgorithmDataModel algoritmData) {
		list = new ArrayList<List<Map<Object,Object>>>();
		dataPoints1 = new ArrayList<Map<Object, Object>>();
		HashMap<Integer, Double> data = (HashMap<Integer, Double>) LagrangeaAlgorithm.calculate(algoritmData.getFrom());
		TreeMap<Integer, Double> sorted = new TreeMap<>();
		sorted.putAll(data);
		
		for (Map.Entry<Integer, Double> entry : sorted.entrySet()) {
			map = new HashMap<Object,Object>(); 
			map.put("x", entry.getKey()); 
			map.put("y", entry.getValue());
			dataPoints1.add(map);
		}
		
		list.add(dataPoints1);
		
//		map = new HashMap<Object,Object>(); map.put("x", 2006); map.put("y", 13.3);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2007); map.put("y", 17);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2008); map.put("y", 14.8);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2009); map.put("y", 10.9);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2010); map.put("y", 11.8);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2011); map.put("y", 10.8);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2012); map.put("y", 10.5);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2013); map.put("y", 10.6);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2014); map.put("y", 12);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2015); map.put("y", 11.7);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2016); map.put("y", 12);dataPoints1.add(map);
//		
//		list.add(dataPoints1);
	}

	
	
//	static {
//		map = new HashMap<Object,Object>(); map.put("x", 2006); map.put("y", 13.3);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2007); map.put("y", 17);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2008); map.put("y", 14.8);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2009); map.put("y", 10.9);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2010); map.put("y", 11.8);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2011); map.put("y", 10.8);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2012); map.put("y", 10.5);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2013); map.put("y", 10.6);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2014); map.put("y", 12);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2015); map.put("y", 11.7);dataPoints1.add(map);
//		map = new HashMap<Object,Object>(); map.put("x", 2016); map.put("y", 13);dataPoints1.add(map);
//		
//		list.add(dataPoints1);
//	}
 
	public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
		return list;
	}
	
	public static List<List<Map<Object, Object>>> getCanvasjsLagrangeDataList(AlgorithmDataModel algoritmData) {
		initData(algoritmData);
		return list;
	}
}                  
