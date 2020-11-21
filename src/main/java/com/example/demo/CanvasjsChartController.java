package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.algorithm.Equation;
import com.example.demo.algorithm.LagrangeaAlgorithm;

@Controller
@RequestMapping("/canvasjschart")
public class CanvasjsChartController {

	@Autowired
	private CanvasjsChartService canvasjsChartService;
	@Autowired
	private LagrangeaAlgorithm la;
	
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
	public String springMVC(@ModelAttribute("data")AlgorithmDataModel data, ModelMap modelMap, BindingResult result) {
		
		displayChart = true;	
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChart(data);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		modelMap.addAttribute("displayChart", displayChart);
		modelMap.addAttribute("equation", Equation.equation);
		
		return "chart";
	}
	
	
}


