package com.khmall.dto;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString //나중에 문제 생겼을 때 = 값이 제대로 안넘어올 때 왜 안넘어오는가!
public class Member {
	private int member_id;
	private String member_name;
	private int member_age;
	private String member_phone;
}
