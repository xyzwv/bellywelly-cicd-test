package com.capston.bellywelly.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capston.bellywelly.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
