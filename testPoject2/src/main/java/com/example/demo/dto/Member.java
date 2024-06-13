package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor 
@AllArgsConstructor
public class Member {

	private String memberName;
	private String memberPhone;
	private int memberAge;
}
