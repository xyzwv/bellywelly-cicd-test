package com.capston.bellywelly.domain.recommendation.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class GptRecRequestDto {

	private List<String> content;

	public GptRecRequestDto(List<String> mealList) {
		this.content = mealList;
	}
}
