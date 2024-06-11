package com.example.demo.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller 폴더 밑에 blog라는 폴더 만들어줘서 블로그 컨트롤러 작성

@Controller
@RequestMapping("blog")
public class BlogController {
	@GetMapping("index") //blog/index -> @RequestMapping("blog")으로 묶어줘서 index만 써도됨
	public String blogMainMethod() {
		return "blog/blog-index";
	}
	
	//blog-board GetMapping 연결
	@GetMapping("board") //blog/board -> @RequestMapping("blog")으로 묶어줘서 board만 써도됨
	public String blogBoardMethod() {
		return "blog/blog-board";
	}
}
