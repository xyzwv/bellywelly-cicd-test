package com.capston.bellywelly.global.feign.dto.chatgpt;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChoiceDto {

	private Integer index;
	private MessageDto delta;
}
