package com.capston.bellywelly.domain.record.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NutrientDto {

	private NutrientValueGraphDto fructose;
	private NutrientValueGraphDto sucrose;
	private NutrientValueGraphDto lactose;
	private NutrientValueGraphDto maltose;
	private NutrientValueGraphDto fiber;
}
