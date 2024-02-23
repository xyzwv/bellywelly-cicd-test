package com.capston.bellywelly.domain.record.dto;

import lombok.Getter;

@Getter
public class DefecationRequestDto {

	private String form;
	private Integer urgency;
	private String color;
	private Integer satisfaction;
	private Integer duration;
}
