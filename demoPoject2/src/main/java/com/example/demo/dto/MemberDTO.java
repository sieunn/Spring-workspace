package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
//멤버번호 이름 나이
	
	private String memberNo;
	private String memberName;
	private String memberAge;
}