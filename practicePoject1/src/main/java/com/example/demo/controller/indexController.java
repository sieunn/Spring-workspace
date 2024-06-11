package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

//index라는 이름은 기본으로 바라보는 페이지명, 보통 처음 맨 앞에 잇는 페이지명은 index로 설정
@Controller
@Slf4j
public class indexController {

	//1. test 메서드를 이용해서 test.html 로 이동하는지 확인하는 메서드 작성
	
	@RequestMapping("test")
	public String testMethod() {
		//-> log.info 사용해서 test 출력
		log.info("테스트 페이지 이동");
		
		return "test";
	}
	
	//홈페이지로 이동하는 코드
	@RequestMapping("home")
	public String homeMethod() {
		log.info("홈페이지로 이동 확인");
		return "index";
	}
}
