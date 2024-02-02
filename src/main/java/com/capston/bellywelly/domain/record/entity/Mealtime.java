package com.capston.bellywelly.domain.record.entity;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Mealtime {
	BREAKFAST("아침"),
	LUNCH("점심"),
	DINNER("저녁"),
	OTHER("기타");

	private final String name;

	public static Mealtime from(String name) {
		return Arrays.stream(Mealtime.values())
			.filter(mealtime -> mealtime.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid mealtime: " + name));
	}

	public static String to(Mealtime mealtime) {
		return mealtime.name;
	}
}
