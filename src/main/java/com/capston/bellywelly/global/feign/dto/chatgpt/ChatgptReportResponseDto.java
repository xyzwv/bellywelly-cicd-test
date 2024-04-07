package com.capston.bellywelly.global.feign.dto.chatgpt;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatgptReportResponseDto {

	private String id;
	private List<ChoiceDto> choices;
}
