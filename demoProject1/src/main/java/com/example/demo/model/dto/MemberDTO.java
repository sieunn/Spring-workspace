package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Getter 와 Setter는 Lombok 라이브러리 활용해서 길게 작성하지 않음
 */
@Getter
@Setter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //필수생성자

public class MemberDTO {
	// 나중에 db랑 연결할 모델들 작성
	
//필드
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
//메서드
	//Getter -> lombok @Getter 자동완성 사용하기
	//Segger -> lombok @Setter 자동완성 사용하기
	//기본생성자 -> lombok @ NoArgsConstructor 
	//필수생성자 -> lombok @ AllArgsConstructor
	//toString -> lombok @ToString
}
