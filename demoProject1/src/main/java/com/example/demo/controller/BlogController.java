package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("blog")
@Slf4j
public class BlogController {
		//메서드명 : blogComment
		//@ 이용해서 PostMapping(comment) 만들고
		//@RequestPAram 이용해서  blog-index.html 파일에 
		//commenName, commentOpinion 작성
		//required=true
		//return "redirect"/blog-index"
	@PostMapping("comment")
	public String blogComment (BlogDTO blogDTO) {
							/*ModelAttribute 사용해서 변경 blogDTO blogDTO*/
			
		BlogDTO bd = new BlogDTO();
		bd.getCommentName();
		bd.getCommentOpinion();
		
		bd.setCommentName("홍길동");
		bd.setCommentOpinion("잘봤습니다.");
		
		log.info("bd에 작성한 내용보기"+bd.toString());
		
		return "redirect:/blog/blog-index";
	}

}
