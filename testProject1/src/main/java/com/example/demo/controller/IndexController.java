package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping ("test") //test 요청시 처리할 메서드 매핑
	public String 테스트페이지연결메서드() {
		System.out.println("test페이지로 제대로 연결됬는지 확인 출력 메서드");
		
		/*
		 *@RequestMapping을 쓰면 기본으로 return 할때 html파일을 바라보겟다는 설정이 들어있음
		 *
		 * classpath : src/main/resources
		 * 기본경로 앞에 붙여진 /templates/폴더가 html을 담는 공간
		 * 파일명 마지막에는 항상 .html이 붙는다
		 * 
		 * */
		//src/main/resources/templates/test.html 로 이동하겠다라는 표시
		return "test";
		//return "html파일명";
		//돌아가기 "html파일명";
		
	}
}
