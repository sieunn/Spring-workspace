package com.kh.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.dto.TodoMember;

@Mapper
public interface TodoMapper {
	int idCheck(String id);
	//int signup(DTO에 만든 TodoMember가져오기);
	int signup(TodoMember member);
	
	TodoMember login(TodoMember member); //id pw만 써도 되고, TodoMember 모두 써도됨
	//TodoMember login(String id, String pw); //id pw 만 가져와서 로그인 하기
}