package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Company;
import com.khmall.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/allCompany")
	public String getAllCompany(Model model) {
		//회사목록 리스트를 company.html에 전달
		List<Company> cList = companyService.getAllCompany();
		//companyList.html에 cList로 가져온 목록들을 companyList라는 이름으로
		//cList에 적힌 목록을 전달
		model.addAttribute("comList",cList);
		
		return "companyList";
	}
}
