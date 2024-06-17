package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Drink;

@Mapper
public interface DrinkMapper {
	void insertDrink(Drink drink);
}

