package com.capston.bellywelly.domain.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.record.entity.Diet;

public interface DietRepository extends JpaRepository<Diet, Long> {
}
