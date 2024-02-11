package com.capston.bellywelly.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {

	@Id
	private Long memberId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, length = 16)
	private String sex;

	@Column(nullable = false)
	private String birthyear;

	@Builder
	public Member(Long memberId, String name, String sex, String birthyear) {
		this.memberId = memberId;
		this.name = name;
		this.sex = sex;
		this.birthyear = birthyear;
	}
}
