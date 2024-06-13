package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BlogDTO;
import com.example.demo.model.dto.CafeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping
@Slf4j

public class CafeController {
	/*
	@PostMapping("cafe-index")
	public String cafeMainCommnet (@RequestParam("cafeCommentName") String cafeCommentName,
									@RequestParam("cafeCommentOpinion") String cafeCommentOpinion
			
			) {
		log.info("카페 메인으로 이동하기");
		log.debug("cafeCommentNmae"+cafeCommentName);
		log.debug("cafeCommentOpinion"+cafeCommentOpinion);
		
		return "redirect:/cafe/cafe-index";
	}
	*/
	
	//cafeDTO cafe_board
	//@PostMapping("cafe-index") ModelAttribute로 받아오기
	
	@PostMapping("cafe-index")
	public String cafeIndexComment (CafeDTO cafeDTO) {
							/*ModelAttribute 사용해서 변경 blogDTO blogDTO*/
			
		CafeDTO cd = new CafeDTO();
		cd.getCafeCommentName();
		cd.getCafeCommentOpinion();
		
		cd.setCafeCommentName("넣어줄값 = 나중에 db연결에서 전달해줄값 넣어줄것");
		cd.setCafeCommentOpinion("넣어줄값 = 나중에 db연결에서 전달해줄값 넣어줄것");
		
		return "redirect:/blog/cafe-index";
	
}
	
}
