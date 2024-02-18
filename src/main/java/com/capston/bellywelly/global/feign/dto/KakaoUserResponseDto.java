package com.capston.bellywelly.global.feign.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoUserResponseDto {

	private Long id;
	private KakaoAccountDto kakao_account;
}
