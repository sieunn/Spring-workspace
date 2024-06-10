package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelleController {
	@RequestMapping ("/test") //test 요청시 처리할 메서드 매핑
	public String textMethod() {
		System.out.println("/test 요청받았는지 확인");
		return "test";
	}
}
