package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pig {
	private int pig_id;
    private String pig_name;
    private int pig_age;
    private String pig_image_path;
}
