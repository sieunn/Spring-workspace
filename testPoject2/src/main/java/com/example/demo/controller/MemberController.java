package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		
		Member mem = new Member();
		mem.setMemberName("황진수");
		mem.setMemberPhone("000-0000-0000");
		mem.setMemberAge(10);
		model.addAttribute("mem",mem);
		
		
		List<Member> memList = new ArrayList<>();
		memList.add(new Member("홍길동","010-1111-1111",10));
		memList.add(new Member("김영희","010-2222-2222",20));
		memList.add(new Member("강철수","010-3333-3333",30));
		
		return "member/memberInfo";
	}
	
}
