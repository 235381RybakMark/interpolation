package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/canvasjschart")
public class CanvasjsChartController {

	@Autowired
	private CanvasjsChartService canvasjsChartService;
	
	private static boolean displayChart = false;
	
	@RequestMapping(method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		displayChart = false;
		//List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		//modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("displayChart", displayChart);
		return "chart";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String springMVC(AlgorithmDataModel data, ModelMap modelMap) {
		
		displayChart = true;
		
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChart(data);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("displayChart", displayChart);
		
		return "chart";
	}
	
	
}


