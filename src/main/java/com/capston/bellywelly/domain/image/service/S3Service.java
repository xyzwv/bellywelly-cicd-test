package com.capston.bellywelly.domain.image.service;

import static com.capston.bellywelly.global.SecurityUtil.*;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capston.bellywelly.domain.member.entity.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3Service {

	@Value("${aws.s3.bucket}")
	private String bucket;

	private final S3Client s3Client;

	public String upload(MultipartFile multipartFile) {

		if (multipartFile.isEmpty()) {
			log.info("image is null");
			return "";
		}

		Member member = getCurrentUser();

		String fileName = member.getMemberId().toString() + "/" + LocalDateTime.now();

		try {
			PutObjectRequest putObjectRequest = PutObjectRequest.builder()
				.bucket(bucket)
				.contentType(multipartFile.getContentType())
				.contentLength(multipartFile.getSize())
				.key(fileName)
				.build();
			RequestBody requestBody = RequestBody.fromBytes(multipartFile.getBytes());
			s3Client.putObject(putObjectRequest, requestBody);
		} catch (IOException e) {
			log.error("cannot upload image", e);
			throw new RuntimeException(e);
		}
		GetUrlRequest getUrlRequest = GetUrlRequest.builder()
			.bucket(bucket)
			.key(fileName)
			.build();

		return s3Client.utilities().getUrl(getUrlRequest).toString();
	}

	//private final S3Presigner s3Presigner;
	//private final AmazonS3Client amazonS3Client;

	/* Create a presigned URL to use in a subsequent PUT request - aws sdk for java 2*/
	// public String createPresignedUrl(PresignedUrlRequestDto requestDto) {
	//
	// 	String fileName = requestDto.getFileName();
	// 	Map<String, String> metadata = new HashMap<>();
	// 	metadata.put("Content-Type", requestDto.getContentType());
	//
	// 	PutObjectRequest objectRequest = PutObjectRequest.builder()
	// 		.bucket(bucket)
	// 		.key(requestDto.getFileName())
	// 		.build();
	//
	// 	PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
	// 		.signatureDuration(Duration.ofMinutes(10))  // The URL expires in 10 minutes.
	// 		.putObjectRequest(objectRequest)
	// 		.build();
	//
	// 	PresignedPutObjectRequest presignedRequest = s3Presigner.presignPutObject(presignRequest);
	// 	String myURL = presignedRequest.url().toString();
	// 	log.info("Presigned URL to upload a file to: [{}]", myURL);
	// 	log.info("HTTP method: [{}]", presignedRequest.httpRequest().method());
	//
	// 	return presignedRequest.url().toExternalForm();
	// }
}
