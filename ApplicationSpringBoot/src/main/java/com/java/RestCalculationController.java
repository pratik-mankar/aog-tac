package com.java;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestCalculationController {

	@Autowired
	private CalculationService calculationservice;
	
	@RequestMapping(value = "/calculate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Calculation saveProduct(@RequestBody Calculation calculation) {
		double ans = 0;
		String user = calculation.getUser(), operationType = calculation.getOperation_type();
		int firstValue = Integer.parseInt(calculation.getFirst_value()),
				secondValue = Integer.parseInt(calculation.getSecond_value());

		switch (operationType) {
			case "add":
				ans = firstValue + secondValue;
				break;
	
			case "sub":
				ans = firstValue - secondValue;
				break;
	
			case "div":
				ans = firstValue / secondValue;
				break;
	
			case "mul":
				ans = firstValue * secondValue;
				break;
		}

		Calculation ob = new Calculation(2,user,String.valueOf(firstValue),String.valueOf(secondValue), operationType, String.valueOf(ans));
		calculationservice.save(ob);
		return ob;
	}

	@RequestMapping(value="/get" ,  method = RequestMethod.GET , headers = "Accept=application/json" )
	public List viewHomePage(Model model) {
		List<Calculation> listProducts = calculationservice.listAll();
		model.addAttribute("listProducts", listProducts);
		return listProducts;
	}
}
