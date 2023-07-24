package com.example.sessiontest.member.model.repository;

import com.example.sessiontest.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository <Member, Long> {
}
