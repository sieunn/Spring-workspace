package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone;
	//번호는 0으로 시작하기 때문에 String으로 작성, int로 작성하면 맨 앞의 0 없어짐
}
