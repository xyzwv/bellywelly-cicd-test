package com.capston.bellywelly.domain.record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.record.entity.Diet;
import com.capston.bellywelly.domain.record.entity.DietMeal;

public interface DietMealRepository extends JpaRepository<DietMeal, Long> {

	List<DietMeal> findAllByDiet(Diet diet);
}
