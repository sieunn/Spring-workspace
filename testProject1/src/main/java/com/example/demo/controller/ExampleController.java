package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//어노테이션컨트롤러
@Controller
public class ExampleController {
	/*
	 *@GettMapping을 쓰면 기본으로 return 할때 html파일을 바라보겟다는 설정이 들어있음
	 *
	 * classpath : src/main/resources
	 * 기본경로 앞에 붙여진 /templates/폴더가 html을 담는 공간
	 * 파일명 마지막에는 항상 .html이 붙는다
	 * 
	 * */
	
	@GetMapping("example")// /example Get 방식 요청 매핑
	public String 이그잼플메서드() {
		//이그잼플 html 파일로 돌아가기
		return "example";
	}
}
