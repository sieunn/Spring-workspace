package com.khmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Company;
import com.khmall.dto.Member;
import com.khmall.dto.Snacks;

@Controller
public class IndexController {

	@GetMapping("/")
	public String SnackCompany (Model model) {
		model.addAttribute("snacks",new Snacks());
		model.addAttribute("company",new Company());
		model.addAttribute("khmember",new Member());
		return "index";
	}
}
