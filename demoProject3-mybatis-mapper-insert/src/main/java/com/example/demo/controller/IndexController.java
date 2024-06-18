package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.Drink;
import com.example.demo.dto.Goods;

@Controller

public class IndexController {
	@GetMapping("/productRegister")
	public String registerForm(Model model) {
		model.addAttribute("goods", new Goods());
		model.addAttribute("drink", new Drink());
		return "index";
	}
}
