package com.example.demo.dto;

import lombok.*;

/*lombok 활용한 getter setter 기본 필수생성자 toString*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private int goodsQuantity;
}
