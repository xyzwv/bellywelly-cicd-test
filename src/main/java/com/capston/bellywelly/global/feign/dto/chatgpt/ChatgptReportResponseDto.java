package com.capston.bellywelly.global.feign.dto.chatgpt;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatgptReportResponseDto {

	private String id;
	private ArrayList<ChoiceDto> choices;
}
