package com.capston.bellywelly.domain.record.entity;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StoolScale {

	NORMAL("촉촉한 변"),
	HARD("딱딱한 변"),
	CRACKED("갈라진 변"),
	LIQUID("묽은 변");

	private final String name;

	public static StoolScale from(String name) {
		return Arrays.stream(StoolScale.values())
			.filter(scale -> scale.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid form: " + name));
	}

	public static String to(StoolScale scale) {
		return scale.name;
	}
}
