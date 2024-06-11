package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping ("param") //공통으로 쓸 주소 만들기 //ParameterController 밑에 작성하는 모든 주소 앞에 param이 기본으로 붙음
@Slf4j
public class ParameterController {
	
	@GetMapping("main")
	public String paramMain() {
		return "param/param-main"; //폴더 param 안에 잇는 param-main.html 파일 바라보기
	}
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		//-> String에서 int로 형변환해줌

		log.info("시작했는지 확인");
		log.info("이름 확인 : " + inputName);
		log.info("나이 확인 : " + inputAge);
		log.info("주소 확인 : " + inputAddress);
		
		log.info("정보확인하기");
		log.debug("이름 확인 : " + inputName);
		log.debug("나이 확인 : " + inputAge);
		log.debug("주소 확인 : " + inputAddress);
		
		return "redirect:/param/main"; //작성 다 되면 메인으로 돌아가기
	}
}
