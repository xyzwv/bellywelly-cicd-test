package com.capston.bellywelly.domain.record.dto;

import java.util.List;

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
	private List<Float> graph;
}
