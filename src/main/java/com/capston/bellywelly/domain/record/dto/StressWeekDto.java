package com.capston.bellywelly.domain.record.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StressWeekDto {

	private Integer sun;
	private Integer mon;
	private Integer tue;
	private Integer wed;
	private Integer thu;
	private Integer fri;
	private Integer sat;
}
