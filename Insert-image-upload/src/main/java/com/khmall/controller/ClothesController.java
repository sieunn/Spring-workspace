package com.khmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.service.ClothesService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ClothesController {

	@Autowired
	private ClothesService clothesService;
	
	@GetMapping("/")
	public String uploadMain() {
		return "index";
	}
	
	@GetMapping("/imageUpload")
	public String uploadClothes(
			@RequestParam("clothes_name") String clothes_name,
			@RequestParam("clothes_price") int clothes_price,
			@RequestParam("clothes_category") String clothes_category,
			@RequestParam("clothes_image_path") MultipartFile file,
			Model model) {
		
		clothesService.uploadClothes(clothes_name, clothes_price, clothes_category, file);
		
		log.info("업로드 확인");
		
		return "/redirect:/";
	}
	
	
}
