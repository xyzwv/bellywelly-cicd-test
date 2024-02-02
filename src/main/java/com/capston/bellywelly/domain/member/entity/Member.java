package com.capston.bellywelly.domain.member.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, length = 16)
	private String sex;

	@Column(nullable = false)
	private LocalDate birthday;

	@Builder
	public Member(String name, String sex, LocalDate birthday) {
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}
}
