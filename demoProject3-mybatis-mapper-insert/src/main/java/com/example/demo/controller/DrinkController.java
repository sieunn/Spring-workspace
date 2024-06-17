package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Drink;
import com.example.demo.service.DrinkService;

@Controller
public class DrinkController {
	

	@Autowired
	private DrinkService drinkService;
	
	@PostMapping("")
	public String insertDrink(Drink drink, Model model) {
		drinkService.insertDrink(drink);
		model.addAttribute("msg","음료등록이 완료되었습니다.");
		return "successDrink";
	}
}
