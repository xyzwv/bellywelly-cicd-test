package com.capston.bellywelly.domain.recommendation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capston.bellywelly.domain.recommendation.dto.GptRecResponseDto;
import com.capston.bellywelly.domain.recommendation.service.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommendations")
public class RecommendationController {

	private final RecommendationService recommendationService;

	@PostMapping
	public GptRecResponseDto getDietRecommendation() {
		return recommendationService.getRecommendation();
	}
}
