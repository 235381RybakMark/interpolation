package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {
	 
	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
 
	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return canvasjsChartDao.getCanvasjsChartData();
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChart(AlgorithmDataModel algoritmData) {
		List<List<Map<Object, Object>>> data = canvasjsChartDao.getCnavasjsChart(algoritmData); 
		return data;
	}
 
} 
