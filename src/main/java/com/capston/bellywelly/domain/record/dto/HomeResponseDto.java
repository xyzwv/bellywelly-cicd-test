package com.capston.bellywelly.domain.record.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomeResponseDto {

	private StressWeekDto stress;
	private DietInfoDto diet;
	private DefecationInfoDto defecation;
}
