package com.capston.bellywelly.global;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;

import com.capston.bellywelly.domain.member.entity.Member;

public class SecurityUtil {

	public static Member getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication.getPrincipal() == null
			|| authentication.getName().equals("anonymousUser")) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No authentication information");
		}
		return (Member)authentication.getPrincipal();
	}
}
