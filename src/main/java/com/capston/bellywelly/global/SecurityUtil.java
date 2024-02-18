package com.capston.bellywelly.global;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.capston.bellywelly.domain.member.entity.Member;

public class SecurityUtil {

	public static Member getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication.getPrincipal() == null) {
			throw new RuntimeException("No authentication information");
		}
		return (Member)authentication.getPrincipal();
	}
}
