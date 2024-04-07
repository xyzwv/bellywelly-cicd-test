package com.capston.bellywelly.global.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.capston.bellywelly.global.feign.dto.chatgpt.ChatgptReportRequestDto;
import com.capston.bellywelly.global.feign.dto.chatgpt.ChatgptReportResponseDto;

@FeignClient(name = "chatGPT", url = "https://api.openai.com/v1/chat/completions")
public interface ChatgptReportClient {

	@PostMapping
	ChatgptReportResponseDto getComment(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
		@RequestBody ChatgptReportRequestDto requestDto);
}
