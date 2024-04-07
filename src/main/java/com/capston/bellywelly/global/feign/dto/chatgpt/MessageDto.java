package com.capston.bellywelly.global.feign.dto.chatgpt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {

	private String role;
	private String content;
}
