package com.capston.bellywelly.domain.record.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capston.bellywelly.domain.member.entity.Member;
import com.capston.bellywelly.domain.record.dto.StressWeekDto;
import com.capston.bellywelly.domain.record.entity.Stress;
import com.capston.bellywelly.domain.record.repository.StressRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StressService {

	private final StressRepository stressRepository;

	public StressWeekDto getStressInfoInThisWeek(Member member, LocalDate today) {
		LocalDate startDateOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

		List<Stress> stressList = stressRepository.findAllByMemberAndCreatedDateBetween(member,
			startDateOfWeek.atTime(0, 0, 0),
			startDateOfWeek.plusDays(6).atTime(23, 59, 59, 999999999)
		);

		Map<DayOfWeek, Integer> stressMap = stressList.stream()
			.collect(Collectors.toMap(
				stress -> stress.getCreatedDate().getDayOfWeek(),
				Stress::getDegree,
				(degree1, degree2) -> degree1));

		return StressWeekDto.builder()
			.sun(stressMap.getOrDefault(DayOfWeek.SUNDAY, null))
			.mon(stressMap.getOrDefault(DayOfWeek.MONDAY, null))
			.tue(stressMap.getOrDefault(DayOfWeek.TUESDAY, null))
			.wed(stressMap.getOrDefault(DayOfWeek.WEDNESDAY, null))
			.thu(stressMap.getOrDefault(DayOfWeek.THURSDAY, null))
			.fri(stressMap.getOrDefault(DayOfWeek.FRIDAY, null))
			.sat(stressMap.getOrDefault(DayOfWeek.SATURDAY, null))
			.build();
	}
}
