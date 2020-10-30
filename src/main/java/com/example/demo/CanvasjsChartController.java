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

	//@Autowired
	private AlgorithmDataModel adm = null;

	@RequestMapping(method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		if(adm != null) {
			List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData(adm);
			modelMap.addAttribute("dataPointsList", canvasjsDataList);
		}else {
			List<List<Map<Object,Object>>> list = null;
			modelMap.addAttribute("dataPointsList", list);
		}
		
		// List<List<Map<Object, Object>>> canvasjsDataList =
		// canvasjsChartService.getCanvasjsChartData();
		//modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "chart";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String springMVC(AlgorithmDataModel data, ModelMap model) {
		adm = new AlgorithmDataModel();
		int from = data.getFrom();
		int to = data.getTo();
		int period = data.getPeriod();
		this.adm.setFrom(from);
		this.adm.setTo(to);
		this.adm.setPeriod(period);

		return "chart";
	}
}
