package com.capston.bellywelly.domain.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.record.entity.Stress;

public interface StressRepository extends JpaRepository<Stress, Long> {
}
