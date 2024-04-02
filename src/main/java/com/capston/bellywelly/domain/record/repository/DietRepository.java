package com.capston.bellywelly.domain.record.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.record.entity.Diet;

public interface DietRepository extends JpaRepository<Diet, Long> {

	List<Diet> findAllByCreatedDateBetween(LocalDateTime time1, LocalDateTime time2);
}
