package com.example.nottodolisttest.member;

import com.example.nottodolisttest.member.model.MemberInsDto;
import com.example.nottodolisttest.member.model.MemoUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;

//    @PostMapping("/member")
//    public int postMember(@RequestBody MemberInsDto dto) {
//        return service.insMember(dto);
//    }
//
//    @GetMapping("/member")
//    public String getMember(int memberId) {
//        return service.selMember(memberId);
//    }
//
//    @GetMapping("/memo")
//    public String getMemo(int memberId) {
//        return service.selMemo(memberId);
//    }
//
//    @PatchMapping("/memo")
//    public int patchMemo(@RequestBody MemoUpdDto dto) {
//        return service.updMemo(dto);
//    }
}
