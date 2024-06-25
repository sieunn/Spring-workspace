package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.khmall.dto.Member;

@Mapper
/*
  @MapperScan 
  = mapper 위치가 아예 찾아지지 않을 때 main 메서드에 Mapper주소를 작성해주는 어노테이션
  사용법
  @MapperScan("com.khmall.mapper.LoginMapper")
  @MapperScans("com.khmall.mapper.*") -> 매퍼 여러종류 가져오기
  
*/

public interface LoginMapper {
	Member getLogin(@Param("member_name")String member_name,
					@Param("member_phone") String member_phone);
	
	
	//insert 와 update는 void 다!
	void updateMember (Member member);
	
	void deleteMember (@Param("member_id") int member_id);
	
	
	
	//select에서 1개의 값을 볼때는 list를 안쓰고
	//2개 이상의 값을 볼 때는 list를 붙인다.
	List<Member> searchMembers(@Param("keyword") String keyword);
	
	
	}

