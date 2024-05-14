package com.capston.bellywelly.global.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capston.bellywelly.domain.recommendation.dto.GptRecRequestDto;
import com.capston.bellywelly.domain.recommendation.dto.GptRecResponseDto;

@FeignClient(name = "chatGptRecommendation", url = "https://model.bellywelly.kro.kr/recommend")
public interface GptRecClient {

	@PostMapping
	GptRecResponseDto getRecommendedDiet(@RequestBody GptRecRequestDto requestDto);
}
