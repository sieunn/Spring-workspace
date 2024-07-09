package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.GoodsItem;
import com.kh.test.mapper.GoodsItemMapper;

@Service
public class GoodsItemService {

	@Autowired
	private GoodsItemMapper goodsItemMapper;
	
	/*
	@Autowired 는 아래와 같은 표현을 가지고 있음
	 
	public GoodsItemService(GoodsItemMapper goodsItemMapper) {
		this.goodsItemMapper = goodsItemMapper;
	}
	*/
	
	public boolean existsByName(String itemName) {
		//Integer로 맞춘 후 integer를 boolean으로 변경해서 전달할 예정
		//Integer count = goodsItemMapper.existsByName(itemName); -> resultMap을 사용하지 않은 방식
		GoodsItem count = goodsItemMapper.existsByName(itemName); //resultMap을 사용한 방식
		//Integer totalCount = 참인지 거짓인지 ? true이고 null이 아닐때 : false null = 0;
		Integer totalCount = count != null ? count.getItemCount() : 0;
		return totalCount != null && totalCount > 0; //true라고 전달할 예정 return = boolean 으로 된것
		
		/*
			return goodsItemMapper.existsByName(itemName);
			Type mismatch: cannot convert from Integer to boolean
			Mapper에서는 integer를 작성하고, service에서 반납할 때는 boolean을 사용하기 때문에 타입불일치 에러 뜸
			Mapper랑 Service 모두 Integer=int 로 작성하거나 boolean 으로 작성하기 
		*/
	
		
	}
}
