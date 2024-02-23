package com.capston.bellywelly.domain.record.service;

import org.springframework.stereotype.Service;

import com.capston.bellywelly.domain.record.entity.StoolColor;
import com.capston.bellywelly.domain.record.entity.StoolScale;

@Service
public class DefecationService {

	public Integer calculateScore(StoolScale form, Integer urgency, StoolColor color, Integer satisfaction,
		Integer duration) {
		Integer score = 0;

		// 점수 계산 로직직

		return score;
	}
}
