package com.capston.bellywelly.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponseDto {

	private String name;
	private String accessToken;
}
