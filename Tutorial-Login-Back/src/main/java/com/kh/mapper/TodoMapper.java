package com.kh.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.dto.TodoMember;

@Mapper
public interface TodoMapper {
	int idCheck(String id);
	
	//int signup(DTO에 만든 TodoMember가져오기);
	int signup(TodoMember member);
}
