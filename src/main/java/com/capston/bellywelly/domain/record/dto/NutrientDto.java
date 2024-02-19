package com.capston.bellywelly.domain.record.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NutrientDto {

	private Float fructose;
	private Float sucrose;
	private Float lactose;
	private Float maltose;
	private Float fiber;
}
