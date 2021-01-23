package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.algorithm.LagrangeaAlgorithm;
import com.example.demo.algorithm.TaskThree;

@Controller
@RequestMapping("/zad3")
public class ZadThreeController {

	@Autowired
	private TaskThree taskThree;
		
	@Autowired
	private ZadThreeDataModel ztdm;
	
	@RequestMapping(method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		modelMap.addAttribute("zadThreeObject", ztdm);
		return "zad3";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String springMVC(@ModelAttribute("precision")ZadThreeDataModel zad3Data, ModelMap modelMap, BindingResult result) {
		Map<Double, Double> algResult1 = taskThree.EulerMethod(zad3Data.getN(), zad3Data.getB());
		Map<Double, Double> algResult2 = taskThree.EulerMethodModified(zad3Data.getN(), zad3Data.getB());
		Map<Double, Double> algResult3 = taskThree.HeunaMethod(zad3Data.getN(), zad3Data.getB());
		double key1 = (double)algResult1.keySet().toArray()[0];
		double value1 = (double)algResult1.get(key1);
		double key2 = (double)algResult2.keySet().toArray()[0];
		double value2 = (double)algResult2.get(key2);
		double key3 = (double)algResult3.keySet().toArray()[0];
		double value3 = (double)algResult3.get(key3);
		modelMap.addAttribute("key1", key1);
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("key2", key2);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("key3", key3);
		modelMap.addAttribute("value3", value3);
		return "zad3";
	}
	
}
