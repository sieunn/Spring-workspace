package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Clothes;


@Mapper
public interface ClothesMapper {
		
		public void uploadClothes(Clothes clothes); //uploadClothes 는 mappers 에 있는 html에 있음
}
