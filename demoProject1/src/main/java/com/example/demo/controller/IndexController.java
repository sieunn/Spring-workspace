package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
//Bean : 스프링이 만들고 관리하는 표시
@Controller //-> 요청이나 응답을 받는 표시, 스프링에서 컨트롤러로 작성하라 명시되어있음
@Slf4j // 각 메서드 이동할 때마다 log.info 사용해서 위치이동 찍기
public class IndexController {

	@GetMapping("cafe/cafe-index") //주소창에서 back과 front가 만나는 주소
	public String cafeMainMethod() {
		log.info("cafe index 메인으로 이동");
		return "cafe/cafe-index"; //html파일 위치
	}
	
	@GetMapping("blog/blog-index") //주소창에서 back과 front가 만나는 주소
	public String blogMainMethod() {
		log.info("blog index 메인으로 이동");
		return "blog/blog-index"; //html파일 위치
	}
	
	//blog-board로 이동하는 getMapping 만들기
	@GetMapping("blog/blog-board")
	public String blogBoardMethod() {
		log.info("blog board로 이동");
		return "blog/blog-board";
	}
	
	//cafe-board로 이동하는 getMapping 만들기
	@GetMapping("cafe/cafe-board")
	public String cafeBoardMethod() {
		log.info("cafe board로 이동");
		return "cafe/cafe-board";
	}
}
