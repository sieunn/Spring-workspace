package com.khmall.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Clothes;
import com.khmall.mapper.ClothesMapper;

@Service
public class ClothesService {
	@Autowired
	public ClothesMapper clothesmapper;
	
	//uploadClothes
	public void uploadClothes(String clothes_name, int clothes_price, String  clothes_category, MultipartFile file ) {
		
		//파일 이름 가져오기
		String fileName = file.getOriginalFilename();
		System.out.println("file Name : " + fileName);
		
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/Insert-image-upload/src/main/resources/static/images/";
		
		File imgFile = new File(uploadDir + fileName);
		
		if(! imgFile.exists()) {
			//폴더 생성
			imgFile.mkdirs();
		}
		
		try {
			file.transferTo(imgFile);
			
			Clothes clothes = new Clothes();
			
			clothes.setClothes_name(clothes_name);
			clothes.setClothes_price(clothes_price);
			clothes.setClothes_category(clothes_category);
			clothes.setClothes_image_path("/images/" + fileName);
			
			clothesmapper.uploadClothes(clothes);
			System.out.println("파일 업로드 service를 성공적으로 완료했습니다.");
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
