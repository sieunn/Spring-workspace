package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Member;

@Mapper
public interface MemberMapper {
	List<Member> getMember();
	
}
