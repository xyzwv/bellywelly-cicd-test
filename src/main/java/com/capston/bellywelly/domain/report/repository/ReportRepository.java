package com.capston.bellywelly.domain.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.report.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
