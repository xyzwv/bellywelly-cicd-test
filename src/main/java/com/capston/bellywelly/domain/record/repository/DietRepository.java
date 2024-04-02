package com.capston.bellywelly.domain.record.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.member.entity.Member;
import com.capston.bellywelly.domain.record.entity.Diet;
import com.capston.bellywelly.domain.record.entity.Mealtime;

public interface DietRepository extends JpaRepository<Diet, Long> {
	boolean existsByMemberAndCreatedDateBetweenAndMealtime(Member member, LocalDateTime time1, LocalDateTime time2,
		Mealtime mealtime);

	List<Diet> findAllByMemberAndCreatedDateBetween(Member member, LocalDateTime time1, LocalDateTime time2);
}
