package com.capston.bellywelly.domain.record.entity;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StoolColor {

	BROWN("brown", 0),
	YELLOW("yellow", 0),
	RED("red", -15),
	BLACK("black", -15),
	GREEN("green", -15);

	private final String name;
	@Getter
	private final Integer score;

	public static StoolColor from(String name) {
		return Arrays.stream(StoolColor.values())
			.filter(color -> color.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid color: " + name));
	}

	public static String to(StoolColor color) {
		return color.name;
	}
}
