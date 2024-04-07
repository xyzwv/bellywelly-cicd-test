package com.capston.bellywelly.global.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${server.url}")
	private String serverUrl;

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
			.info(new Info()
				.title("Bellywelly API Documentation")
				.description(
					"Ewha W. Univ. CSE 2024 Capston Design Project [BellyWelly] by Team17 Chaewon Song, Chaeyeon Ahn, and Yeji Kim")
				.version("0.0.1"))
			.components(new Components()
				.addSecuritySchemes("authorization",
					new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
						.scheme("bearer")
						.bearerFormat("JWT")))
			.security(Collections.singletonList(
				new SecurityRequirement().addList("authorization")))
			.servers(Collections.singletonList(
				new Server().url(serverUrl)));
	}
}
