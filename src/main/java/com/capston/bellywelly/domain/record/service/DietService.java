package com.capston.bellywelly.domain.record.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
		Mealtime mealtime = Mealtime.from(requestDto.getMealtime());
		if (!mealtime.equals(Mealtime.OTHER)) { // mealtime이 아침, 점심, 저녁일 때
			if (dietRepository.existsByCreatedDateBetweenAndMealtime(
				LocalDate.now().atTime(0, 0, 0),
				LocalDate.now().atTime(23, 59, 59, 999999999),
				Mealtime.from(requestDto.getMealtime()))
			) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"해당 시간에 식단 기록이 이미 존재합니다. mealtime: " + requestDto.getMealtime());
			}
		}
		return dietRepository.save(
			Diet.builder()
				.member(member)
				.image(requestDto.getImage())
				.mealtime(Mealtime.from(requestDto.getMealtime()))
				.build());
	}

	public Diet findDiet(LocalDate date, int value) {
		// createdDate의 날짜가 date인 diet list 생성
		List<Diet> dietListByDate = dietRepository.findAllByCreatedDateBetween(
			date.atTime(0, 0, 0),
			date.atTime(23, 59, 59, 999999999));
		// list가 비었으면 에러 발생
		if (dietListByDate.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"해당 날짜에 식단 기록이 존재하지 않습니다. date: " + date);
		}
		// list 존재할 때
		if (value >= 4) {
			// value가 4 이상이면, mealtime=OTHER(기타)
			dietListByDate = dietListByDate.stream().filter(
				d -> d.getMealtime().equals(Mealtime.OTHER)
			).collect(Collectors.toList());
			// createdDate 오름차순으로 정렬
			dietListByDate.sort(Comparator.comparing(Diet::getCreatedDate));
			// 알맞은 인덱스의 diet 반환
			Diet diet = dietListByDate.get(value - 4);
			// diet가 null이면 not found error 발생
			if (diet == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"해당 시간에 식단 기록이 존재하지 않습니다. mealtime: " + value);
			}
			return diet;
		} else if (value >= 1) {
			// value가 1~3이면, 각 mealtime에 맞는 diet 반환
			return dietListByDate.stream()
				.filter(d -> d.getMealtime().equals(Mealtime.fromValue(value)))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
					"해당 시간에 식단 기록이 존재하지 않습니다. mealtime: " + value
						+ "(" + Mealtime.fromValue(value).name() + ")"));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mealtime은 1 이상이어야 합니다.");
		}
	}
}
