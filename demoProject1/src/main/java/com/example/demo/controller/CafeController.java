package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping
@Slf4j
public class CafeController {
	
	@PostMapping("cafe-index")
	public String cafeMainCommnet (@RequestParam("cafeCommentName") String cafeCommentName,
									@RequestParam("cafeCommentOpinion") String cafeCommentOpinion
			
			) {
		log.info("카페 메인으로 이동하기");
		log.debug("cafeCommentNmae"+cafeCommentName);
		log.debug("cafeCommentOpinion"+cafeCommentOpinion);
		
		return "redirect:/cafe/cafe-index";
	}
	
	
}
