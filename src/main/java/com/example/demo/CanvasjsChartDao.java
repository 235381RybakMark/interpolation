package com.example.demo;

import java.util.List;
import java.util.Map;
 
public interface CanvasjsChartDao {
 
	List<List<Map<Object, Object>>> getCanvasjsChartData();
	
	List<List<Map<Object, Object>>> getCnavasjsChart(AlgorithmDataModel algoritmData);
 
}
