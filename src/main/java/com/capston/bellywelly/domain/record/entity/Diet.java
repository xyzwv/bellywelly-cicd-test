package com.capston.bellywelly.domain.record.entity;

import java.util.List;

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
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Diet extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dietId;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@Column(nullable = false)
	private String image;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Mealtime mealtime;

	@OneToMany(mappedBy = "diet")
	private List<DietMeal> mealList;

	private Integer lowFodmapCount;

	private Integer highFodmapCount;

	@Builder
	public Diet(Member member, String image, Mealtime mealtime) {
		this.member = member;
		this.image = image;
		this.mealtime = mealtime;
	}

	public void updateLowFodmapCount(Integer lowFodmapCount) {
		this.lowFodmapCount = lowFodmapCount;
	}

	public void updateHighFodmapCount(Integer highFodmapCount) {
		this.highFodmapCount = highFodmapCount;
	}
}
