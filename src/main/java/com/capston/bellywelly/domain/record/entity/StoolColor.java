package com.capston.bellywelly.domain.record.entity;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StoolColor {

	BROWN("brown"),
	YELLOW("yellow"),
	RED("red"),
	BLACK("black"),
	GREEN("green");

	private final String name;

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
