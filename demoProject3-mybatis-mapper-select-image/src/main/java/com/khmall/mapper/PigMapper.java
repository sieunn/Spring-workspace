
package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Pig;

@Mapper
public interface PigMapper {
	//전체가져오기 -> List
	List<Pig> getAllPigs();
	
	//돼지정보 하나만 가져오기
	Pig getPigById(int pig_id);
}
