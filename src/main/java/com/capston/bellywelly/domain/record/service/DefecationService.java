package com.capston.bellywelly.domain.record.service;

import org.springframework.stereotype.Service;

import com.capston.bellywelly.domain.record.entity.StoolColor;
import com.capston.bellywelly.domain.record.entity.StoolScale;

@Service
public class DefecationService {

	public Integer calculateScore(StoolScale form, Integer urgency, StoolColor color, Integer satisfaction,
		Integer duration) {
		int score = 100;

		return score += (form.getScore()
			+ 3 * (1 - urgency)
			+ color.getScore()
			+ 3 * (satisfaction - 5)
			+ 4 * (1 - duration));
	}
}
