package com.bookspider.pilot.member.repository;

import com.bookspider.pilot.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
