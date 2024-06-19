package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Company;
import com.khmall.dto.Snacks;

@Mapper
public interface CompanyMapper {
	//select로 모든 목록 가져올 때는 void가 아니라 List로 작성
	List<Company> getAllCompany();
}
