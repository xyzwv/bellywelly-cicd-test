package com.capston.bellywelly.domain.image.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capston.bellywelly.domain.image.dto.PresignedUrlRequestDto;
import com.capston.bellywelly.domain.image.service.S3Service;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

	private final S3Service s3Service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createPresignedUrl(PresignedUrlRequestDto requestDto) {
		return s3Service.createPresignedGetUrl(requestDto.getFileName());
	}
}
