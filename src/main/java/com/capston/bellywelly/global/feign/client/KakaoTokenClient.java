package com.capston.bellywelly.global.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capston.bellywelly.global.feign.dto.KakaoTokenRequestDto;
import com.capston.bellywelly.global.feign.dto.KakaoTokenResponseDto;

@FeignClient(name = "kakaoToken", url = "https://kauth.kakao.com/oauth/token")
public interface KakaoTokenClient {

	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	KakaoTokenResponseDto getAccessToken(@RequestBody KakaoTokenRequestDto requestDto);

}
