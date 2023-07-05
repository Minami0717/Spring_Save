package com.example.nottodolisttest.member;

import com.example.nottodolisttest.member.model.MemberInsDto;
import com.example.nottodolisttest.member.model.MemoUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;

    @PostMapping
    public int postMember(@RequestBody MemberInsDto dto) {
        return service.insMember(dto);
    }

    @GetMapping
    public String getMember(int memberId) {
        return service.selMember(memberId);
    }
}
