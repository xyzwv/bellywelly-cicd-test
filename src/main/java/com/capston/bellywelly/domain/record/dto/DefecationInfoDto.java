package com.capston.bellywelly.domain.record.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DefecationInfoDto {

	private Integer count;
	private Integer score;
}
