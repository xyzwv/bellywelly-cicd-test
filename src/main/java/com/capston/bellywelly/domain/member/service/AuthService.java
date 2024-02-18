package com.capston.bellywelly.domain.member.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.capston.bellywelly.global.feign.client.KakaoTokenClient;
import com.capston.bellywelly.global.feign.client.KakaoUserClient;
import com.capston.bellywelly.global.feign.dto.KakaoTokenRequestDto;
import com.capston.bellywelly.global.feign.dto.KakaoTokenResponseDto;
import com.capston.bellywelly.global.feign.dto.KakaoUserResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

	private final KakaoTokenClient kakaoTokenClient;
	private final KakaoUserClient kakaoUserClient;

	@Value("${kakao.client-id}")
	private String clientId;

	@Value("${kakao.client-secret}")
	private String clientSecret;

	@Value("${kakao.redirect-uri}")
	private String redirectUri;

	public void login(String code) {
		// 카카오에 인가 코드를 보내 토큰 발급받기
		String kakaoAccessToken = getKakaoToken(code);
		// 카카오에 토큰을 보내 사용자 정보 받기
		KakaoUserResponseDto kakaoUserInfo = getKakaoUserInfo(kakaoAccessToken);
	}

	public String getKakaoToken(String code) {
		KakaoTokenResponseDto responseDto = kakaoTokenClient.getAccessToken(
			KakaoTokenRequestDto.builder()
				.grant_type("authorization_code")
				.client_id(clientId)
				.redirect_uri(redirectUri)
				.code(code)
				.client_secret(clientSecret)
				.build()
		);
		return responseDto.getAccess_token();
	}

	public KakaoUserResponseDto getKakaoUserInfo(String kakaoAccessToken) {
		String authorization = "Bearer " + kakaoAccessToken;
		return kakaoUserClient.getUserInfo(authorization);
	}
}

