package com.capston.bellywelly.domain.record.service;

import static com.capston.bellywelly.global.SecurityUtil.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capston.bellywelly.domain.member.entity.Member;
import com.capston.bellywelly.domain.record.dto.DefecationRequestDto;
import com.capston.bellywelly.domain.record.dto.DietRecordRequestDto;
import com.capston.bellywelly.domain.record.dto.DietRecordResponseDto;
import com.capston.bellywelly.domain.record.dto.HomeResponseDto;
import com.capston.bellywelly.domain.record.dto.StressRequestDto;
import com.capston.bellywelly.domain.record.entity.Diet;
import com.capston.bellywelly.domain.record.entity.DietMeal;
import com.capston.bellywelly.domain.record.entity.StoolColor;
import com.capston.bellywelly.domain.record.entity.StoolScale;
import com.capston.bellywelly.domain.record.repository.DietMealRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RecordService {

	private final DietService dietService;
	private final DietMealRepository dietMealRepository;
	private final MealService mealService;
	private final StressService stressService;
	private final DefecationService defecationService;

	public DietRecordResponseDto createDietRecord(DietRecordRequestDto requestDto) {
		Member member = getCurrentUser();

		Diet diet = dietService.createDiet(member, requestDto);

		mealService.findMealList(requestDto.getMeal())
			.forEach(meal -> dietMealRepository.save(DietMeal.builder().diet(diet).meal(meal).build()));

		return DietRecordResponseDto.builder()
			.diet(diet)
			.meal(requestDto.getMeal())
			.fodmapList(mealService.findLowOrHighFodmap(diet))
			.nutrient(mealService.sumNutrientComponent(diet))
			.build();
	}

	public void createStressRecord(StressRequestDto requestDto) {
		Member member = getCurrentUser();
		stressService.createStress(member, requestDto.getStress());
	}

	public void createDefecationRecord(DefecationRequestDto requestDto) {
		Member member = getCurrentUser();
		defecationService.createDefecation(member, StoolScale.from(requestDto.getForm()), requestDto.getUrgency(),
			StoolColor.from(requestDto.getColor()), requestDto.getSatisfaction(), requestDto.getDuration());
	}

	public DietRecordResponseDto findDietRecord(LocalDate date, int mealtime) {
		Diet diet = dietService.findDiet(date, mealtime);

		return DietRecordResponseDto.builder()
			.diet(diet)
			.meal(mealService.findMealnameList(diet))
			.fodmapList(mealService.findLowOrHighFodmap(diet))
			.nutrient(mealService.sumNutrientComponent(diet))
			.build();
	}

	public HomeResponseDto getDailyRecord() {
		Member member = getCurrentUser();
		LocalDate today = LocalDate.now();
		LocalDateTime startOfToady = today.atStartOfDay();
		LocalDateTime endOfToady = today.atTime(23, 59, 59, 999999999);

		return HomeResponseDto.builder()
			.diet(dietService.getDailyDietInfo(member, startOfToady, endOfToady))
			.defecation(defecationService.getDailyDefecationInfo(member, startOfToady, endOfToady))
			.stress(stressService.getStressInfoInThisWeek(member, today))
			.build();
	}
}
