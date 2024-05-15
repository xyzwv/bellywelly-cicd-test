package com.capston.bellywelly.domain.record.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DietInfoDto {

	private String comment;
	private Integer lowFodmapRatio;
	private Integer highFodmapRatio;
	private Boolean hasDiet;
	private Boolean hasBreakfast;
	private Boolean hasLunch;
	private Boolean hasDinner;
	private Boolean hasOther;
}
