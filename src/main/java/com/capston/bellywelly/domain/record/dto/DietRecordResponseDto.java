package com.capston.bellywelly.domain.record.dto;

import java.util.List;

import com.capston.bellywelly.domain.record.entity.Diet;
import com.capston.bellywelly.domain.record.entity.Mealtime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DietRecordResponseDto {

	private String image;
	private String mealtime;
	private List<String> meal;
	private FodmapListDto fodmapList;
	private NutrientDto nutrient;

	@Builder
	public DietRecordResponseDto(Diet diet, List<String> meal, FodmapListDto fodmapList, NutrientDto nutrient) {
		this.image = diet.getImage();
		this.mealtime = Mealtime.to(diet.getMealtime());
		this.meal = meal;
		this.fodmapList = fodmapList;
		this.nutrient = nutrient;
	}
}
