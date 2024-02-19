package com.capston.bellywelly.domain.record.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capston.bellywelly.domain.record.dto.FodmapListDto;
import com.capston.bellywelly.domain.record.dto.NutrientDto;
import com.capston.bellywelly.domain.record.entity.Diet;
import com.capston.bellywelly.domain.record.entity.DietMeal;
import com.capston.bellywelly.domain.record.entity.Meal;
import com.capston.bellywelly.domain.record.repository.DietMealRepository;
import com.capston.bellywelly.domain.record.repository.MealRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MealService {

	private final MealRepository mealRepository;
	private final DietMealRepository dietMealRepository;

	public List<Meal> findMealList(List<String> mealNameList) {
		return mealNameList.stream()
			.map(mealName -> mealRepository.findByMealName(mealName).orElse(null))
			.collect(Collectors.toList());
	}

	public FodmapListDto findLowOrHighFodmap(Diet diet) {
		List<DietMeal> dietMealList = dietMealRepository.findAllByDiet(diet);
		List<String> lowFodmapList = new ArrayList<>();
		List<String> highFodmapList = new ArrayList<>();
		for (DietMeal dietMeal : dietMealList) {
			Meal meal = dietMeal.getMeal();
			if (meal.getIsLowFodmap()) {
				lowFodmapList.add(meal.getMealName());
			} else {
				highFodmapList.add(meal.getMealName());
			}
		}

		diet.updateLowFodmapCount(lowFodmapList.size());
		diet.updateHighFodmapCount(highFodmapList.size());

		return FodmapListDto.builder().lowFodmap(lowFodmapList).highFodmap(highFodmapList).build();
	}

	public NutrientDto sumNutrientComponent(Diet diet) {
		List<DietMeal> dietMealList = dietMealRepository.findAllByDiet(diet);
		Float totalFructose = (float)0;
		Float totalSucrose = (float)0;
		Float totalLactose = (float)0;
		Float totalMaltose = (float)0;
		Float totalFiber = (float)0;
		for (DietMeal dietMeal : dietMealList) {
			Meal meal = dietMeal.getMeal();
			totalFructose += meal.getFructose();
			totalSucrose += meal.getSucrose();
			totalLactose += meal.getLactose();
			totalMaltose += meal.getMaltose();
			totalFiber += meal.getFiber();
		}
		return NutrientDto.builder()
			.fructose(totalFructose)
			.sucrose(totalSucrose)
			.lactose(totalLactose)
			.maltose(totalMaltose)
			.fiber(totalFiber)
			.build();
	}

}
