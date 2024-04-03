package com.capston.bellywelly.domain.record.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.member.entity.Member;
import com.capston.bellywelly.domain.record.entity.Defecation;

public interface DefecationRepository extends JpaRepository<Defecation, Long> {

	List<Defecation> findAllByMemberAndCreatedDateBetween(Member member, LocalDateTime time1, LocalDateTime time2);
}
