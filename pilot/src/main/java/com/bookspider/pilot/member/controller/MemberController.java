package com.bookspider.pilot.member.controller;

import com.bookspider.pilot.member.dto.CreateMemberDto;
import com.bookspider.pilot.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Long createMember(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.createMember(createMemberDto);
    }

}
