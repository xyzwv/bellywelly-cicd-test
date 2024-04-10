package com.capston.bellywelly.domain.record.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NutrientValueGraphDto {

	private Float value;
	private Integer graph;
}
