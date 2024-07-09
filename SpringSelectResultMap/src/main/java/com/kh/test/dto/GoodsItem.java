package com.kh.test.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsItem {
	private int itemId;
	private String itemName;
	private String itemDes;
	//count 결과를 받아서 저장할 변수명 추가
	private Integer itemCount;//count(*)
}
