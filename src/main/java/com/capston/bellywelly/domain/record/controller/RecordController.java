package com.capston.bellywelly.domain.record.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capston.bellywelly.domain.record.dto.DietRecordRequestDto;
import com.capston.bellywelly.domain.record.dto.DietRecordResponseDto;
import com.capston.bellywelly.domain.record.service.RecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordController {

	private final RecordService recordService;

	@PostMapping("/diet")
	@ResponseStatus(HttpStatus.CREATED)
	public DietRecordResponseDto createDietRecord(@RequestBody DietRecordRequestDto requestDto) {
		return recordService.createDietRecord(requestDto);
	}
}
