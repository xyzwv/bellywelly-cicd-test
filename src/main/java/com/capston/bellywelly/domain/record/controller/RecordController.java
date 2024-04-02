package com.capston.bellywelly.domain.record.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capston.bellywelly.domain.record.dto.DefecationRequestDto;
import com.capston.bellywelly.domain.record.dto.DietRecordRequestDto;
import com.capston.bellywelly.domain.record.dto.DietRecordResponseDto;
import com.capston.bellywelly.domain.record.dto.StressRequestDto;
import com.capston.bellywelly.domain.record.service.RecordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "기록", description = "기록 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordController {

	private final RecordService recordService;

	@Operation(summary = "식단 기록 작성")
	@PostMapping("/diet")
	@ResponseStatus(HttpStatus.CREATED)
	public DietRecordResponseDto createDietRecord(@RequestBody DietRecordRequestDto requestDto) {
		return recordService.createDietRecord(requestDto);
	}

	@Operation(summary = "스트레스 기록 작성")
	@PostMapping("/stress")
	@ResponseStatus(HttpStatus.CREATED)
	public void createStressRecord(@RequestBody StressRequestDto requestDto) {
		recordService.createStressRecord(requestDto);
	}

	@Operation(summary = "배변 기록 작성")
	@PostMapping("/defecation")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDefecationRecord(@RequestBody DefecationRequestDto requestDto) {
		recordService.createDefecationRecord(requestDto);
	}

	@Operation(summary = "식단 기록 조회")
	@GetMapping("/records/diet")
	@ResponseStatus(HttpStatus.OK)
	public DietRecordResponseDto findDietRecord(@RequestParam LocalDate date, @RequestParam int mealtime) {
		return recordService.findDietRecord(date, mealtime);
	}

}
