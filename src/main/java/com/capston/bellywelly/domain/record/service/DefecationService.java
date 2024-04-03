package com.capston.bellywelly.domain.record.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capston.bellywelly.domain.member.entity.Member;
import com.capston.bellywelly.domain.record.dto.DefecationInfoDto;
import com.capston.bellywelly.domain.record.entity.Defecation;
import com.capston.bellywelly.domain.record.entity.StoolColor;
import com.capston.bellywelly.domain.record.entity.StoolScale;
import com.capston.bellywelly.domain.record.repository.DefecationRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DefecationService {

	private final DefecationRepository defecationRepository;

	public void createDefecation(Member member, StoolScale form, Integer urgency, StoolColor color,
		Integer satisfaction, Integer duration) {
		defecationRepository.save(
			Defecation.builder()
				.member(member)
				.form(form)
				.urgency(urgency)
				.color(color)
				.satisfaction(satisfaction)
				.duration(duration)
				.score(calculateScore(form, urgency, color, satisfaction, duration))
				.build()
		);
	}

	public Integer calculateScore(StoolScale form, Integer urgency, StoolColor color, Integer satisfaction,
		Integer duration) {
		int score = 100;

		return score += (form.getScore()
			+ 3 * (1 - urgency)
			+ color.getScore()
			+ 3 * (satisfaction - 5)
			+ 4 * (1 - duration));
	}

	public DefecationInfoDto getDailyDefecationInfo(Member member,
		LocalDateTime startOfToday, LocalDateTime endOfToday) {
		List<Defecation> defecationList =
			defecationRepository.findAllByMemberAndCreatedDateBetween(member, startOfToday, endOfToday);
		return DefecationInfoDto.builder()
			.count(defecationList.size())
			.score(defecationList.stream().mapToInt(Defecation::getScore).sum())
			.build();
	}
}
