package com.capston.bellywelly.domain.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.record.entity.Defecation;

public interface DefecationRepository extends JpaRepository<Defecation, Long> {
}
