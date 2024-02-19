package com.capston.bellywelly.domain.record.dto;

import java.util.List;

import lombok.Builder;

@Builder
public class FodmapListDto {

	private List<String> lowFodmap;
	private List<String> highFodmap;
}
