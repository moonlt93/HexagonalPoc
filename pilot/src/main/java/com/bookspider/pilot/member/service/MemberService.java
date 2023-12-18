package com.bookspider.pilot.member.service;

import com.bookspider.pilot.member.domain.Member;
import com.bookspider.pilot.member.dto.CreateMemberDto;
import com.bookspider.pilot.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long createMember(CreateMemberDto createMemberDto) {

        Member newMember = Member.builder()
                .name(createMemberDto.getName())
                .build();

        Member savedMember = memberRepository.save(newMember);
        return savedMember.getId();
    }
}
