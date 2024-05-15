package com.capston.bellywelly.domain.record.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capston.bellywelly.domain.record.dto.HomeResponseDto;
import com.capston.bellywelly.domain.record.service.RecordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "홈", description = "홈 화면 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

	private final RecordService recordService;

	@Operation(summary = "일일 기록 현황 조회")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public HomeResponseDto getDailyRecord(@RequestParam LocalDate date) {
		return recordService.getDailyRecord(date);
	}
}
