package com.capston.bellywelly.domain.recommendation.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GptRecResponseDto {

	private int status;
	private List<String> data;
}
