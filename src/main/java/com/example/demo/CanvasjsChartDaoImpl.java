package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
 
@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}

	@Override
	public List<List<Map<Object, Object>>> getCnavasjsChart(AlgorithmDataModel algoritmData) {
		return CanvasjsChartData.getCanvasjsLagrangeDataList(algoritmData);
	}

 
}
