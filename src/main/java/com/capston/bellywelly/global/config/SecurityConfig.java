package com.capston.bellywelly.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capston.bellywelly.global.jwt.JwtAuthenticationFilter;
import com.capston.bellywelly.global.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtTokenProvider jwtTokenProvider;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable);
		http.cors(Customizer.withDefaults());
		http.sessionManagement(
			sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.formLogin(AbstractHttpConfigurer::disable);
		http.httpBasic(AbstractHttpConfigurer::disable);

		http.authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/auth/**").permitAll()
			.anyRequest().permitAll()
		);

		http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
