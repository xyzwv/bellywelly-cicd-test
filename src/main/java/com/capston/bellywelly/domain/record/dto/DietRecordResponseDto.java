package com.capston.bellywelly.domain.record.dto;

import java.util.List;

import com.capston.bellywelly.domain.record.entity.Diet;

import lombok.Builder;

public class DietRecordResponseDto {

	private String image;
	private String mealtime;
	private List<String> meal;
	private FodmapListDto fodmapList;
	private NutrientDto nutrient;

	@Builder
	public DietRecordResponseDto(Diet diet, List<String> meal, FodmapListDto fodmapList, NutrientDto nutrient) {
		this.image = diet.getImage();
		this.mealtime = diet.getMealtime().name();
		this.meal = meal;
		this.fodmapList = fodmapList;
		this.nutrient = nutrient;
	}
}
