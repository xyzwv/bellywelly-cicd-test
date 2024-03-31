package com.capston.bellywelly.domain.record.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.record.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {

	Optional<Meal> findByMealName(String mealName);
}
