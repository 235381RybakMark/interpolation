package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
 
@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData(AlgorithmDataModel ob) {
		CanvasjsChartData data = new CanvasjsChartData(ob);
		return data.getCanvasjsDataList();
		//return CanvasjsChartData.getCanvasjsDataList();
	}
 
}
