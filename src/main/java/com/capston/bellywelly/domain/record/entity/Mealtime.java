package com.capston.bellywelly.domain.record.entity;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Mealtime {
	BREAKFAST("아침", 1),
	LUNCH("점심", 2),
	DINNER("저녁", 3),
	OTHER("기타", 4);

	private final String name;
	private final int value;

	public static Mealtime from(String name) {
		return Arrays.stream(Mealtime.values())
			.filter(mealtime -> mealtime.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid mealtime: " + name));
	}

	public static String to(Mealtime mealtime) {
		return mealtime.name;
	}

	public static Mealtime fromValue(int value) {
		return Arrays.stream(Mealtime.values())
			.filter(mealtime -> (mealtime.value == value))
			.findFirst()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid mealtime: " + value));
	}
}
