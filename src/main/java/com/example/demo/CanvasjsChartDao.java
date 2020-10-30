package com.example.demo;

import java.util.List;
import java.util.Map;

import com.example.demo.algorithm.LagrangeaAlgorithm;
 
public interface CanvasjsChartDao {
 
	List<List<Map<Object, Object>>> getCanvasjsChartData(AlgorithmDataModel ob);
 
}
