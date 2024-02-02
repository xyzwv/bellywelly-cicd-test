package com.capston.bellywelly.domain.record.entity;

import jakarta.persistence.Entity;
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
public class DietMeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dietMealId;

	@ManyToOne
	@JoinColumn(name = "diet_id")
	private Diet diet;

	@ManyToOne
	@JoinColumn(name = "meal_id")
	private Meal meal;

	@Builder
	public DietMeal(Diet diet, Meal meal) {
		this.diet = diet;
		this.meal = meal;
	}
}
