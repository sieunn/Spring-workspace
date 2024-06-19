package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Company;
import com.khmall.dto.Member;
import com.khmall.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/allMember")
	public String getMember(Model model) {
		//회사목록 리스트를 company.html에 전달
		List<Member> memberList = memberService.getMember();
		//companyList.html에 cList로 가져온 목록들을 companyList라는 이름으로
		//cList에 적힌 목록을 전달
		model.addAttribute("khmemberList",memberList);
		
		return "khmemberList";
	}
	
}
