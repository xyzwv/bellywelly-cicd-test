package com.capston.bellywelly.global.feign.dto.chatgpt;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatgptReportRequestDto {

	private String model;
	private List<MessageDto> messages;
}
