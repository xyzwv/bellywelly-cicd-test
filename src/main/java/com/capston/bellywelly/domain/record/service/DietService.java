package com.capston.bellywelly.domain.record.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capston.bellywelly.domain.member.entity.Member;
import com.capston.bellywelly.domain.record.dto.DietRecordRequestDto;
import com.capston.bellywelly.domain.record.entity.Diet;
import com.capston.bellywelly.domain.record.entity.Mealtime;
import com.capston.bellywelly.domain.record.repository.DietRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DietService {

	private final DietRepository dietRepository;

	public Diet createDiet(Member member, DietRecordRequestDto requestDto) {
		return dietRepository.save(
			Diet.builder()
				.member(member)
				.image(requestDto.getImage())
				.mealtime(Mealtime.from(requestDto.getMealtime()))
				.build());
	}
}
