package com.capston.bellywelly.domain.record.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class DietRecordRequestDto {

	private String image;
	private String mealtime;
	private List<String> meal;
}
