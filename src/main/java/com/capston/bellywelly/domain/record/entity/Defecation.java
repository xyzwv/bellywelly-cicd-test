package com.capston.bellywelly.domain.record.entity;

import com.capston.bellywelly.domain.member.entity.Member;
import com.capston.bellywelly.global.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Defecation extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long defecationId;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private StoolScale form;

	@Column(nullable = false)
	private Integer urgency;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private StoolColor color;

	@Column(nullable = false)
	private Integer satisfaction;

	@Column(nullable = false)
	private Integer duration;

	private Integer score;

	@Builder
	public Defecation(Member member, StoolScale form, Integer urgency, StoolColor color, Integer satisfaction,
		Integer duration, Integer score) {
		this.member = member;
		this.form = form;
		this.urgency = urgency;
		this.color = color;
		this.satisfaction = satisfaction;
		this.duration = duration;
		this.score = score;
	}
}
