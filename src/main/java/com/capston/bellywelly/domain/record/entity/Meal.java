package com.capston.bellywelly.domain.record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mealId;

	@Column(nullable = false)
	private String mealName;

	@Column(nullable = false)
	private Boolean isLowFodmap;

	@Column(nullable = false)
	private Float fructose;

	@Column(nullable = false)
	private Float sucrose;

	@Column(nullable = false)
	private Float lactose;

	@Column(nullable = false)
	private Float maltose;

	@Column(nullable = false)
	private Float fiber;
}
