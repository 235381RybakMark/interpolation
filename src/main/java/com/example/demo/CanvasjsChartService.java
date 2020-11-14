package com.example.demo;

import java.util.List;
import java.util.Map;


public interface CanvasjsChartService {

	List<List<Map<Object, Object>>> getCanvasjsChartData();
	
	List<List<Map<Object, Object>>> getCanvasjsChart(AlgorithmDataModel algoritmData);

}
