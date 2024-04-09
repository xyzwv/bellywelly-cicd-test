package com.capston.bellywelly.domain.image.service;

import static com.capston.bellywelly.global.SecurityUtil.*;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.capston.bellywelly.domain.member.entity.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3Service {

	@Value("${aws.s3.bucket}")
	private String bucket;

	private final S3Presigner s3Presigner;

	public String createPresignedGetUrl(String fileName) {
		Member member = getCurrentUser();

		GetObjectRequest objectRequest = GetObjectRequest.builder()
			.bucket(bucket)
			.key(member.getMemberId() + "/" + fileName)
			.build();

		GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
			.signatureDuration(Duration.ofMinutes(1))
			.getObjectRequest(objectRequest)
			.build();

		PresignedGetObjectRequest presignedRequest = s3Presigner.presignGetObject(presignRequest);
		log.info("Presigned URL: [{}]", presignedRequest.url().toString());
		log.info("HTTP method: [{}]", presignedRequest.httpRequest().method());

		return presignedRequest.url().toExternalForm();
	}
}
