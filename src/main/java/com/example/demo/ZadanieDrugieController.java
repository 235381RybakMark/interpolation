package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.algorithm.LagrangeaAlgorithm;

@Controller
@RequestMapping("/zad2")
public class ZadanieDrugieController {
	
	private boolean displayResult = false;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView  springMVC(ModelMap modelMap, ZadTwoDataModel precision) {
		displayResult = false;
		modelMap.addAttribute("displayResult", displayResult);
		modelMap.addAttribute("precision",new ZadTwoDataModel());
		return new ModelAndView("zad2", "ZadTwoDataModel", new ZadTwoDataModel());
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String springMVC(@ModelAttribute("precision")ZadTwoDataModel precision, ModelMap modelMap, BindingResult result) {
		displayResult = true;
		Map<Integer, Double> algResult = LagrangeaAlgorithm.calculate(precision.getPrecision());
		int key = (int) algResult.keySet().toArray()[0];;
		double value = algResult.get(key);
		modelMap.addAttribute("key", key);
		modelMap.addAttribute("value", value);
		modelMap.addAttribute("displayResult", displayResult);
		return "zad2";
	}
}
